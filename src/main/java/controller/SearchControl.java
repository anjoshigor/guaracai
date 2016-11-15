package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import dao.CategoryDAO;
import dao.ClientDAO;
import dao.EmployeeDAO;
import dao.GoodsDAO;
import view.SearchView;

/**
 * 
 * @author alvesmarcos
 *
 */
public class SearchControl {
	
	// attributes
	private SearchView searchView;
	private Events events;
	private CategoryDAO categoryDAO;
	private ClientDAO clientDAO;
	private EmployeeDAO employeeDAO;
	private GoodsDAO goodsDAO;
	
	// contents jcombox
	private static final String[] CONTENT_CATEGORY = {"nome"};
	private static final String[] CONTENT_CLIENT = {"nome", "data nascimento", "saldo","valor em compras"};
	private static final String[] CONTENT_EMPLOYEE = {"nome","data nascimento", "cpf", "cidade", "bairro", "estado", "tipo"};
	private static final String[] CONTENT_GOODS = {"codigo", "categoria", "nome", "preço", "tamanho"};
	
	// constructor
	public SearchControl(SearchView searchView){
		this.searchView = searchView;
		this.events = new Events();
	
		this.categoryDAO = new CategoryDAO();
		this.clientDAO = new ClientDAO();
		this.employeeDAO = new EmployeeDAO();
		this.goodsDAO = new GoodsDAO();
		
		// add listeners
		searchView.getComboFiltro().addActionListener(events);
		searchView.getLblButtonPesquisar().addMouseListener(events);
		searchView.getLblImageButtonVoltar().addMouseListener(events);
	}
	
	private void selectedCombox(){
		searchView.getComboCampo().removeAllItems();
		
		if(String.valueOf(searchView.getComboFiltro().getSelectedItem()).equals("categoria")){
			for(String s: CONTENT_CATEGORY)
				searchView.getComboCampo().addItem(s);
			
		} else if(String.valueOf(searchView.getComboFiltro().getSelectedItem()).equals("cliente")){
			for(String s: CONTENT_CLIENT)
				searchView.getComboCampo().addItem(s);
			
		} else if(String.valueOf(searchView.getComboFiltro().getSelectedItem()).equals("funcionário")){
			for(String s: CONTENT_EMPLOYEE)
				searchView.getComboCampo().addItem(s);

		} else if(String.valueOf(searchView.getComboFiltro().getSelectedItem()).equals("produto")){
			for(String s: CONTENT_GOODS)
				searchView.getComboCampo().addItem(s);
		}
	}
	
	private void seek(){ /* TODO */ }
	
	private class Events implements ActionListener, MouseListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == searchView.getComboFiltro()){
				selectedCombox();
			}
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == searchView.getLblImageButtonVoltar()){
				searchView.dispose();
				
				categoryDAO.disconnect();
				clientDAO.disconnect();
				employeeDAO.disconnect();
				goodsDAO.disconnect();
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
