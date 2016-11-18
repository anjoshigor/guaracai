package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import dao.EmployeeDAO;
import view.LoginView;
import view.MenuView;

/**
 * 
 * @author marcos-alves
 *
 */
public class LoginControl {
	
	// attributes
	private LoginView loginView;
	private EmployeeDAO employeeDAO;
	private Events events;
	
	// constructor
	public LoginControl(LoginView loginView) {
		this.loginView = loginView;
		this.employeeDAO = new EmployeeDAO();
		this.events = new Events();
		
		loginView.getRootPane().setDefaultButton(loginView.getBtnEntrar());
		
		loginView.getBtnEntrar().addActionListener(events);
	}
	
	// methods
	private void clearFields() {
		loginView.getTxtUsuario().setText("");
		loginView.getPwdSenha().setText("");
		loginView.getTxtUsuario().requestFocus();
	}
	
	private void showMenu() {
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				loginView.getBtnEntrar().setVisible(false);
				loginView.getLblImageLoading().setVisible(true);
				try {
					Thread.sleep(1200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				if(validateLogin() == 1){
					new MenuView().setVisible(true);
					loginView.dispose();
					
				} else {
					loginView.getBtnEntrar().setVisible(true);
					loginView.getLblImageLoading().setVisible(false);
					loginView.getLblMessageError().setVisible(true);
					clearFields();
				}
			}
		});
		t.start();
	}
	
	private int validateLogin() {
		String user = loginView.getTxtUsuario().getText();
		String password = String.valueOf(loginView.getPwdSenha().getPassword());
	
		return employeeDAO.checkLogin(user, password);
	}
	
	// inner class
	private class Events implements ActionListener, KeyListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			showMenu();
		}
		
		@Override
		public void keyTyped(KeyEvent e) { /* unimplemented method */ }
		
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				showMenu();
			}
		}
		
		@Override
		public void keyReleased(KeyEvent e) { /* unimplemented method */ }
	}
}
