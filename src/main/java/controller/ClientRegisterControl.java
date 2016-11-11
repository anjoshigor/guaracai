package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.Client;
import view.ClientRegisterView;
import view.RegisterView;

public class ClientRegisterControl {
	
	// attributes
	private ClientRegisterView clientRegisterView;
	private Events events;
	private Client client;
	
	// constructor
	public ClientRegisterControl(ClientRegisterView clientRegisterView){
		this.clientRegisterView = clientRegisterView;
		this.events = new Events();
		this.client = null;
		
		// add listeners
		clientRegisterView.getBtnCadastrar().addActionListener(events);
		clientRegisterView.getBtnLimpar().addActionListener(events);
		clientRegisterView.getLblImageButtonVoltar().addMouseListener(events);
	}
	
	private void cleanFields(){
		clientRegisterView.getTxtDataNasc().setText("");
		clientRegisterView.getTxtEmail().setText("");
		clientRegisterView.getTxtNome().setText("");
		clientRegisterView.getTxtSaldo().setText("");
		clientRegisterView.getTxtTelefone().setText("");
		clientRegisterView.getTxtValorEmCompras().setText("");
	}
	
	private void insert(){
		client = new Client();
		
		client.setName(clientRegisterView.getTxtNome().getText());
		client.setPhone(clientRegisterView.getTxtTelefone().getText());
		client.setDateOfBirth(clientRegisterView.getTxtDataNasc().getText());
		client.setBalance(Double.parseDouble(clientRegisterView.getTxtSaldo().getText()));
		client.setAmountSpent(Double.parseDouble(clientRegisterView.getTxtValorEmCompras().getText()));
	}
	
	// inner class
	private class Events implements ActionListener, MouseListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == clientRegisterView.getBtnCadastrar())
				;
			else if(e.getSource() == clientRegisterView.getBtnLimpar())
				cleanFields();
		}
		
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == clientRegisterView.getLblImageButtonVoltar())
				clientRegisterView.dispose();
		}
		
		@Override
		public void mousePressed(MouseEvent e) { /* unimplemented method */ }
		
		@Override
		public void mouseReleased(MouseEvent e) { /* unimplemented method */ }
		
		@Override
		public void mouseEntered(MouseEvent e) { /* unimplemented method */ }
		
		@Override
		public void mouseExited(MouseEvent e) { /* unimplemented method */ }
	}
}
