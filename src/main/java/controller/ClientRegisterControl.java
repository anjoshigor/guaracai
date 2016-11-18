package controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import dao.ClientDAO;
import model.Client;
import util.GraphicsUtil;
import util.SystemConstUtil;
import view.ClientRegisterView;

public class ClientRegisterControl {
	
	// attributes
	private ClientRegisterView clientRegisterView;
	private Events events;
	private ClientDAO clientDAO;
	private Client client;	
	private short call;

	// constructor
	public ClientRegisterControl(ClientRegisterView clientRegisterView){
		this.clientRegisterView = clientRegisterView;
		this.events = new Events();
		this.clientDAO = new ClientDAO();
		this.client = null;
		this.call = SystemConstUtil.INSERT;
		
		// add listeners
		clientRegisterView.getBtnSim().addActionListener(events);
		clientRegisterView.getBtnNao().addActionListener(events);
		clientRegisterView.getTxtSaldo().addFocusListener(events);
		clientRegisterView.getTxtValorEmCompras().addFocusListener(events);
		clientRegisterView.getBtnCadastrar().addActionListener(events);
		clientRegisterView.getBtnLimpar().addActionListener(events);
		clientRegisterView.getBtnOK().addActionListener(events);
		clientRegisterView.getLblImageButtonVoltar().addMouseListener(events);
	}
	
	public ClientRegisterControl(ClientRegisterView clientRegisterView, Client client){
		this(clientRegisterView);
		this.call = SystemConstUtil.UPDATE;
		this.client = client;
		clientRegisterView.getBtnCadastrar().setText("Atualizar");
		clientRegisterView.getBtnLimpar().setText("Deletar");
		clientRegisterView.getLblTitleClient().setText("Atualização de Clientes");
		clientRegisterView.getLblTitleClient().setFont(new Font("DejaVu Sans", Font.PLAIN, 50));
		clientRegisterView.getTxtDataNasc().setText(client.getDateOfBirth());
		clientRegisterView.getTxtEmail().setText(client.getEmail());
		clientRegisterView.getTxtNome().setText(client.getName());
		clientRegisterView.getTxtTelefone().setText(client.getPhone());
		
		String mask = String.format("R$ %.2f", client.getBalance());
		clientRegisterView.getTxtSaldo().setText(mask.replaceAll("\\.", ","));
		
		mask = String.format("R$ %.2f", client.getAmountSpent());
		clientRegisterView.getTxtValorEmCompras().setText(mask.replaceAll("\\.", ","));
	}
	
	private void cleanFields(){
		clientRegisterView.getTxtDataNasc().setText("");
		clientRegisterView.getTxtEmail().setText("");
		clientRegisterView.getTxtNome().setText("");
		clientRegisterView.getTxtSaldo().setText("R$ 0,00");
		clientRegisterView.getTxtTelefone().setText("");
		clientRegisterView.getTxtValorEmCompras().setText("R$ 0,00");
		
		clientRegisterView.getTxtNome().requestFocus();
	}
	
	private boolean checkFields(){
		if(clientRegisterView.getTxtNome().getText().isEmpty() ||
		   clientRegisterView.getTxtEmail().getText().isEmpty() ||
		   clientRegisterView.getTxtDataNasc().getText().isEmpty() ||
		   clientRegisterView.getTxtTelefone().getText().isEmpty()){
				
			return false;
		}
		return true;	
	}
	
	private void inflate(){
		client.setName(clientRegisterView.getTxtNome().getText());
		client.setPhone(clientRegisterView.getTxtTelefone().getText());
		client.setDateOfBirth(clientRegisterView.getTxtDataNasc().getText());
		client.setEmail(clientRegisterView.getTxtEmail().getText());
		
	    double balance = 0.0, amountSpent = 0.0;
	    
	    NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
	    
	    String formattedBalance = clientRegisterView.getTxtSaldo().getText().replaceAll("R\\$ ", "");
	    String formattedAmountSpent = clientRegisterView.getTxtValorEmCompras().getText().replaceAll("R\\$ ", "");
	    
	    try {
		    if(!formattedBalance.equals("0,00"))
				balance = nf.parse(formattedBalance).doubleValue();
		    if(!formattedAmountSpent.equals("0,00"))
		    	amountSpent = nf.parse(formattedAmountSpent).doubleValue();
	  
	    } catch(ParseException ep){
	    	ep.printStackTrace();
	    }
		client.setBalance(balance);
		client.setAmountSpent(amountSpent);
	}
	
	private void insert() {
		client = new Client();
		inflate();
		
		if(checkFields()){
			clientDAO.add(client);
			showPanelDialog();
		} else 
			clientRegisterView.getLblMessageError().setVisible(true);
	}
	
	private void update() {
		inflate();
		
		if(checkFields()){
			showPanelDialog();
			clientDAO.update(client);
		} else 
			clientRegisterView.getLblMessageError().setVisible(true);
	}
	
	private void showPanelDialog(){
		clientRegisterView.getPanelDialog().setVisible(true);
		clientRegisterView.getTxtDataNasc().setEnabled(false);
		clientRegisterView.getTxtEmail().setEnabled(false);
		clientRegisterView.getTxtNome().setEnabled(false);
		clientRegisterView.getTxtSaldo().setEnabled(false);
		clientRegisterView.getTxtTelefone().setEnabled(false);
		clientRegisterView.getTxtValorEmCompras().setEnabled(false);
		
		clientRegisterView.getBtnCadastrar().setEnabled(false);
		clientRegisterView.getBtnLimpar().setEnabled(false);
	}
	
	private void disposePanelDialog(){
		clientRegisterView.getPanelDialog().setVisible(false);
		clientRegisterView.getTxtNome().requestFocus();
		
		clientRegisterView.getTxtDataNasc().setEnabled(true);
		clientRegisterView.getTxtEmail().setEnabled(true);
		clientRegisterView.getTxtNome().setEnabled(true);
		clientRegisterView.getTxtSaldo().setEnabled(true);
		clientRegisterView.getTxtTelefone().setEnabled(true);
		clientRegisterView.getTxtValorEmCompras().setEnabled(true);
		
		clientRegisterView.getBtnCadastrar().setEnabled(true);
		clientRegisterView.getBtnLimpar().setEnabled(true);
		
		cleanFields();
	}
	
	// inner class
	private class Events implements ActionListener, FocusListener, MouseListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == clientRegisterView.getBtnCadastrar()){
				if(call == SystemConstUtil.INSERT)
					insert();
				else if(call == SystemConstUtil.UPDATE)
					update();
			
			} else if(e.getSource() == clientRegisterView.getBtnOK()){
				disposePanelDialog();
				
				if(call == SystemConstUtil.UPDATE)
					clientRegisterView.dispose();
			}
			else if(e.getSource() == clientRegisterView.getBtnLimpar()){
				if(call == SystemConstUtil.INSERT)
					cleanFields();
				else if(call == SystemConstUtil.UPDATE){
					clientRegisterView.getBtnOK().setVisible(false);
					clientRegisterView.getBtnSim().setVisible(true);
					clientRegisterView.getBtnNao().setVisible(true);
					
					clientRegisterView.getLblMessagedialog().setText("<html>Deseja realmente<br>excluir registro ?<html>");
					clientRegisterView.getLblIconMessage().setIcon(GraphicsUtil.adjustImage("/drawable/warning.png", 
																	clientRegisterView.getLblIconMessage().getSize()));
					showPanelDialog();
				}
			} else if(e.getSource() == clientRegisterView.getBtnSim()){
				clientDAO.delete(client);
				clientRegisterView.dispose();
			
			} else if(e.getSource() == clientRegisterView.getBtnNao()){
				clientRegisterView.dispose();
			}
		}
		
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == clientRegisterView.getLblImageButtonVoltar()){
				clientRegisterView.dispose();
				clientDAO.disconnect();
			}
		}
		
		@Override
		public void mousePressed(MouseEvent e) { /* unimplemented method */ }
		
		@Override
		public void mouseReleased(MouseEvent e) { /* unimplemented method */ }
		
		@Override
		public void mouseEntered(MouseEvent e) { /* unimplemented method */ }
		
		@Override
		public void mouseExited(MouseEvent e) { /* unimplemented method */ }

		@Override
		public void focusGained(FocusEvent e) {
			if(e.getSource() == clientRegisterView.getTxtSaldo()){
				clientRegisterView.getTxtSaldo().setForeground(new Color(51, 51, 51));
				clientRegisterView.getTxtSaldo().setText("");
			}
			else if(e.getSource() == clientRegisterView.getTxtValorEmCompras()){
				clientRegisterView.getTxtValorEmCompras().setForeground(new Color(51, 51, 51));
				clientRegisterView.getTxtValorEmCompras().setText("");
			}
		}

		@Override
		public void focusLost(FocusEvent e) {
			if(e.getSource() == clientRegisterView.getTxtSaldo()){
				if(clientRegisterView.getTxtSaldo().getText().isEmpty()){
					clientRegisterView.getTxtSaldo().setForeground(Color.GRAY);
					clientRegisterView.getTxtSaldo().setText("R$ 0,00");
				} else {
					clientRegisterView.getTxtSaldo().setForeground(new Color(51, 51, 51));
					String previous = clientRegisterView.getTxtSaldo().getText();
					clientRegisterView.getTxtSaldo().setText("R$ "+previous);
				}
			}
			else if(e.getSource() == clientRegisterView.getTxtValorEmCompras()){
				if(clientRegisterView.getTxtValorEmCompras().getText().isEmpty()){
					clientRegisterView.getTxtValorEmCompras().setForeground(Color.GRAY);
					clientRegisterView.getTxtValorEmCompras().setText("R$ 0,00");
				} else {
					clientRegisterView.getTxtValorEmCompras().setForeground(new Color(51, 51, 51));
					String previous = clientRegisterView.getTxtValorEmCompras().getText();
					clientRegisterView.getTxtValorEmCompras().setText("R$ "+previous);
				}
			}
		}
	}
}
