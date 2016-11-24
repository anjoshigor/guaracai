 	/**
 * 
 */
package controller;

import view.EmployeeRegisterView;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import dao.EmployeeDAO;
import model.Address;

import model.Employee;
import util.GraphicsUtil;
import util.SystemConstUtil;

/**
 * @author diogodantas
 *
 */
public class EmployeeRegisterControl {
	
	private EmployeeRegisterView employeeRegisterView;
	private Events events;
	private EmployeeDAO employeeDAO;
	private Employee employee;
	private short call;
	
	public EmployeeRegisterControl(EmployeeRegisterView employeeRegisterView) {
		this.employeeRegisterView = employeeRegisterView;
		this.events = new Events();
		this.employeeDAO = new EmployeeDAO();
		this.employee = null;
		this.call = SystemConstUtil.INSERT;
		
		//add listeners
		employeeRegisterView.getBtnSim().addActionListener(events);
		employeeRegisterView.getBtnNao().addActionListener(events);
		employeeRegisterView.getBtnCadastrar().addActionListener(events);
		employeeRegisterView.getBtnLimpar().addActionListener(events);
		employeeRegisterView.getLblImageButtonVoltar().addMouseListener(events);
		employeeRegisterView.getBtnOK().addActionListener(events);
	}
	
	public EmployeeRegisterControl(EmployeeRegisterView employeeRegisterView, Employee employee) {
		this(employeeRegisterView);
		this.call = SystemConstUtil.UPDATE;
		this.employee = employee;
		employeeRegisterView.getBtnCadastrar().setText("Atualizar");
		employeeRegisterView.getBtnLimpar().setText("Deletar");
		employeeRegisterView.getLblTitleEmployee().setText("Atualização de Funcionários");
		employeeRegisterView.getLblTitleEmployee().setFont(new Font("DejaVu Sans", Font.PLAIN, 44));
		
		employeeRegisterView.getTxtNome().setText(employee.getName());
		employeeRegisterView.getTxtEmail().setText(employee.getEmail());
		employeeRegisterView.getTxtTelefone().setText(employee.getPhone());
		employeeRegisterView.getTxtDataNasc().setText(employee.getDateOfBirth());
		employeeRegisterView.getTxtAgencia().setText(employee.getAgency());
		employeeRegisterView.getTxtConta().setText(employee.getCount());
		employeeRegisterView.getTxtCPF().setText(employee.getCpf());
		employeeRegisterView.getComboTipoFunc().setSelectedItem(employee.getType());
		employeeRegisterView.getTxtLogradouro().setText(employee.getAddress().getStreet());
		employeeRegisterView.getTxtNumero().setText(String.valueOf(employee.getAddress().getNumber()));
		employeeRegisterView.getTxtBairro().setText(employee.getAddress().getDistrict());
		employeeRegisterView.getTxtComplemento().setText(employee.getAddress().getComplement());
		employeeRegisterView.getComboUF().setSelectedIndex(0);
		employeeRegisterView.getTxtCidade().setText(employee.getAddress().getCity());
		employeeRegisterView.getTxtLogin().setText(employee.getUsername());
		employeeRegisterView.getPwdSenha().setText(employee.getPassword());	
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
	
	private void inflate(){
		Address address = new Address(employeeRegisterView.getTxtComplemento().getText(),
				employeeRegisterView.getTxtCidade().getText(), employeeRegisterView.getTxtCidade().getText(),
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

	}
	
	private void insert(){
		employee = new Employee();
		inflate();
		
		if(checkFields()){
			employeeDAO.add(employee);
			showPanelDialog();
		} else 
			employeeRegisterView.getLblMessageError().setVisible(true);
	}
	
	private void update() {
		inflate();
		
		if(checkFields()){
			showPanelDialog();
			employeeDAO.update(employee);
		} else 
			employeeRegisterView.getLblMessageError().setVisible(true);
	}
	
	private void showPanelDialog(){
		employeeRegisterView.getPanelDialog().setVisible(true);

		employeeRegisterView.getTxtNome().setEnabled(false);
		employeeRegisterView.getTxtEmail().setEnabled(false);
		employeeRegisterView.getTxtTelefone().setEnabled(false);
		employeeRegisterView.getTxtDataNasc().setEnabled(false);
		employeeRegisterView.getTxtAgencia().setEnabled(false);
		employeeRegisterView.getTxtConta().setEnabled(false);
		employeeRegisterView.getTxtCPF().setEnabled(false);
		employeeRegisterView.getComboTipoFunc().setEnabled(false);
		employeeRegisterView.getTxtLogradouro().setEnabled(false);
		employeeRegisterView.getTxtNumero().setEnabled(false);
		employeeRegisterView.getTxtBairro().setEnabled(false);
		employeeRegisterView.getTxtComplemento().setEnabled(false);
		employeeRegisterView.getComboUF().setEnabled(false);
		employeeRegisterView.getTxtCidade().setEnabled(false);
		employeeRegisterView.getTxtLogin().setEnabled(false);
		employeeRegisterView.getPwdSenha().setEnabled(false);
		
		employeeRegisterView.getBtnCadastrar().setEnabled(false);
		employeeRegisterView.getBtnLimpar().setEnabled(false);
	}
	
	
	private void disposePanelDialog(){
		employeeRegisterView.getPanelDialog().setVisible(false);
		employeeRegisterView.getTxtNome().requestFocus();

		employeeRegisterView.getTxtNome().setEnabled(true);
		employeeRegisterView.getTxtEmail().setEnabled(true);
		employeeRegisterView.getTxtTelefone().setEnabled(true);
		employeeRegisterView.getTxtDataNasc().setEnabled(true);
		employeeRegisterView.getTxtAgencia().setEnabled(true);
		employeeRegisterView.getTxtConta().setEnabled(true);
		employeeRegisterView.getTxtCPF().setEnabled(true);
		employeeRegisterView.getComboTipoFunc().setEnabled(true);
		employeeRegisterView.getTxtLogradouro().setEnabled(true);
		employeeRegisterView.getTxtNumero().setEnabled(true);
		employeeRegisterView.getTxtBairro().setEnabled(true);
		employeeRegisterView.getTxtComplemento().setEnabled(true);
		employeeRegisterView.getComboUF().setEnabled(true);
		employeeRegisterView.getTxtCidade().setEnabled(true);
		employeeRegisterView.getTxtLogin().setEnabled(true);
		employeeRegisterView.getPwdSenha().setEnabled(true);
		
		employeeRegisterView.getBtnCadastrar().setEnabled(true);
		employeeRegisterView.getBtnLimpar().setEnabled(true);
		cleanFields();
	}
		
	//inner class
	private class Events implements ActionListener, MouseListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == employeeRegisterView.getBtnCadastrar()){
				if(call == SystemConstUtil.INSERT)
					insert();
				else if(call == SystemConstUtil.UPDATE)
					update();
				
			} else if(e.getSource() == employeeRegisterView.getBtnOK()){
				disposePanelDialog();
				
				if(call == SystemConstUtil.UPDATE)
					employeeRegisterView.dispose();	
			} 
			else if (e.getSource() == employeeRegisterView.getBtnLimpar()){
				if(call == SystemConstUtil.INSERT)
					cleanFields();
				else if(call == SystemConstUtil.UPDATE){
					employeeRegisterView.getBtnOK().setVisible(false);
					employeeRegisterView.getBtnSim().setVisible(true);
					employeeRegisterView.getBtnNao().setVisible(true);
					
					employeeRegisterView.getLblMessagedialog().setText("<html>Deseja realmente<br>excluir registro ?<html>");
					employeeRegisterView.getLblIconMessage().setIcon(GraphicsUtil.adjustImage("/drawable/warning.png", 
							employeeRegisterView.getLblIconMessage().getSize()));
					showPanelDialog();
				}
			}else if(e.getSource() == employeeRegisterView.getBtnSim()){
				employeeDAO.delete(employee);
				employeeRegisterView.dispose();
			
			} else if(e.getSource() == employeeRegisterView.getBtnNao()){
				employeeRegisterView.dispose();
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
