package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import dao.tables.Employee;
import util.PgSqlConnectionUtil;
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
	private Events events;
	
	// constructor
	public LoginControl(LoginView loginView) {
		this.loginView = loginView;
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
				if(validateLogin()){
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
	
	private boolean validateLogin() {
		Connection con = null;
		try{
			//Conectando com o banco de dados POSTGRESQL
			con = PgSqlConnectionUtil.getConnection();
			
			//Realizando a query utilizando o ORM JOOQ
			DSLContext query = DSL.using(con, SQLDialect.POSTGRES); // Conectando ao DB e selecionando o SGBD
			
			//Executando um SELECT * na tabela Employee
			org.jooq.Result<Record> result =  query.select().from(Employee.EMPLOYEE).fetch();
		
			for(Record r : result){
				if(loginView.getTxtUsuario().getText().
						equals(String.valueOf(r.getValue(Employee.EMPLOYEE.USERNAME))) && 
						String.valueOf(loginView.getPwdSenha().getPassword())
						.equals(String.valueOf(r.getValue(Employee.EMPLOYEE.PASSWORD)))) 
						return true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		} 
		
		// login provisorio enquanto a tabela estiver vazia
		if(loginView.getTxtUsuario().getText().equals("guaracai"))
			return true;
		
		return false;
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
