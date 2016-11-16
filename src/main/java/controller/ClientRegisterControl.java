package controller;

import java.awt.Color;
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
import view.ClientRegisterView;


public class ClientRegisterControl {
	
	// attributes
	private ClientRegisterView clientRegisterView;
	private Events events;
	private ClientDAO clientDAO;
	private Client client;	

	// constructor
	public ClientRegisterControl(ClientRegisterView clientRegisterView){
		this.clientRegisterView = clientRegisterView;
		this.events = new Events();
		this.clientDAO = new ClientDAO();
		this.client = null;
		
		// add listeners
		clientRegisterView.getTxtSaldo().addFocusListener(events);
		clientRegisterView.getTxtValorEmCompras().addFocusListener(events);
		clientRegisterView.getBtnCadastrar().addActionListener(events);
		clientRegisterView.getBtnLimpar().addActionListener(events);
		clientRegisterView.getLblImageButtonVoltar().addMouseListener(events);
	}
	
	private void cleanFields(){
		clientRegisterView.getTxtDataNasc().setText("");
		clientRegisterView.getTxtEmail().setText("");
		clientRegisterView.getTxtNome().setText("");
		clientRegisterView.getTxtSaldo().setText("R$ 0,00");
		clientRegisterView.getTxtTelefone().setText("");
		clientRegisterView.getTxtValorEmCompras().setText("R$ 0,00");
	}
	
	private void insert() throws ParseException {
		client = new Client();
		
		client.setName(clientRegisterView.getTxtNome().getText());
		client.setPhone(clientRegisterView.getTxtTelefone().getText());
		client.setDateOfBirth(clientRegisterView.getTxtDataNasc().getText());
		client.setEmail(clientRegisterView.getTxtEmail().getText());
		
	    double balance = 0.0, amountSpent = 0.0;
	    
	    NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
	    
	    String formattedBalance = clientRegisterView.getTxtSaldo().getText().replaceAll("R\\$ ", "");
	    String formattedAmountSpent = clientRegisterView.getTxtValorEmCompras().getText().replaceAll("R\\$ ", "");
	    
	    if(!formattedBalance.equals("0,00"))
			balance = nf.parse(formattedBalance).doubleValue();
	    
	    if(!formattedAmountSpent.equals("0,00"))
	    	amountSpent = nf.parse(formattedAmountSpent).doubleValue();
	    
		client.setBalance(balance);
		client.setAmountSpent(amountSpent);
	
		clientDAO.add(client);
	}
	
	// inner class
	private class Events implements ActionListener, FocusListener, MouseListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == clientRegisterView.getBtnCadastrar()){
				try {
					insert();
				} catch (ParseException pe) {
					pe.printStackTrace();
				}
			} else if(e.getSource() == clientRegisterView.getBtnLimpar())
				cleanFields();
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
