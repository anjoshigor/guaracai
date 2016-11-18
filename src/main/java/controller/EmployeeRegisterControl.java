/**
 * 
 */
package controller;

import view.EmployeeRegisterView;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JDialog;

import dao.EmployeeDAO;
import model.Address;
import model.Employee;

/**
 * @author diogodantas
 *
 */
public class EmployeeRegisterControl {
	
	private EmployeeRegisterView employeeRegisterView;
	private Events events;
	private EmployeeDAO employeeDAO;
	private Employee employee;
	
	
	public EmployeeRegisterControl(EmployeeRegisterView employeeRegisterView) {
		this.employeeRegisterView = employeeRegisterView;
		this.events = new Events();
		this.employeeDAO = new EmployeeDAO();
		this.employee = null;
		
		//add listeners
		employeeRegisterView.getBtnCadastrar().addActionListener(events);
		employeeRegisterView.getBtnLimpar().addActionListener(events);
		employeeRegisterView.getLblImageButtonVoltar().addMouseListener(events);
		employeeRegisterView.getBtnOK().addActionListener(events);
	}
	
	
	private void cleanFields(){
		employeeRegisterView.getTxtNome().setText("");
		employeeRegisterView.getTxtEmail().setText("");
		employeeRegisterView.getTxtTelefone().setText("");
		employeeRegisterView.getTxtDataNasc().setText("");
		employeeRegisterView.getTxtAgencia().setText("");
		employeeRegisterView.getTxtConta().setText("");
		employeeRegisterView.getTxtCPF().setText("");
		employeeRegisterView.getComboTipoFunc().setSelectedIndex(0);
		employeeRegisterView.getTxtLogradouro().setText("");
		employeeRegisterView.getTxtNumero().setText("");
		employeeRegisterView.getTxtBairro().setText("");
		employeeRegisterView.getTxtComplemento().setText("");
		employeeRegisterView.getComboUF().setSelectedIndex(0);
		employeeRegisterView.getTxtCidade().setText("");
		employeeRegisterView.getTxtLogin().setText("");
		employeeRegisterView.getPwdSenha().setText("");	
	}
	
	private boolean checkFields(){
		
		if(employeeRegisterView.getTxtNome().getText().isEmpty() ||
		   employeeRegisterView.getTxtDataNasc().getText().isEmpty() || 
		   employeeRegisterView.getTxtTelefone().getText().isEmpty() ||
		   employeeRegisterView.getTxtCPF().getText().isEmpty() ||
		   employeeRegisterView.getTxtLogin().getText().isEmpty()){
			
			return false;
		}
		
		return true;
	}
	
	private void insert(){
		
		employee = new Employee();
		Address address =  new Address(employeeRegisterView.getTxtComplemento().getText(), 
									   employeeRegisterView.getTxtCidade().getText(), 
									   employeeRegisterView.getTxtCidade().getText(), 
									   employeeRegisterView.getTxtBairro().getText(), 
									   Integer.parseInt(employeeRegisterView.getTxtNumero().getText()), 
									   employeeRegisterView.getComboUF().getSelectedItem().toString());
		
		
		employee.setName(employeeRegisterView.getTxtNome().getText());
		employee.setEmail(employeeRegisterView.getTxtEmail().getText());
		employee.setPhone(employeeRegisterView.getTxtTelefone().getText());
		employee.setDateOfBirth(employeeRegisterView.getTxtDataNasc().getText());
		employee.setAgency(employeeRegisterView.getTxtAgencia().getText());
		employee.setCount(employeeRegisterView.getTxtConta().getText());
		employee.setCpf(employeeRegisterView.getTxtCPF().getText());
		employee.setType(employeeRegisterView.getComboTipoFunc().getSelectedItem().toString());
		employee.setAddress(address);
		employee.setUsername(employeeRegisterView.getTxtLogin().getText());
		employee.setPassword(String.valueOf(employeeRegisterView.getPwdSenha().getPassword()));
		
		if(checkFields()){
			employeeDAO.add(employee);
			
		}else{
			System.out.println("Error !");
		}
	}
		
	//inner class
	private class Events implements ActionListener, MouseListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == employeeRegisterView.getBtnCadastrar()){
				insert();
			} else if(e.getSource() == employeeRegisterView.getBtnOK()){
				employeeRegisterView.getPanelDialog().setVisible(false);
				cleanFields();
			} if (e.getSource() == employeeRegisterView.getBtnLimpar()){
					cleanFields();
			}
			
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == employeeRegisterView.getLblImageButtonVoltar()){
				employeeRegisterView.dispose();
				employeeDAO.disconnect();
			}
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {/* unimplemented method */ }
		
		@Override
		public void mouseReleased(MouseEvent e) {/* unimplemented method */ }
		
		@Override
		public void mouseEntered(MouseEvent e) {/* unimplemented method */ }

		@Override
		public void mouseExited(MouseEvent e) {/* unimplemented method */ }
		
	}
}
