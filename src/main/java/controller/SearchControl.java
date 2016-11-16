package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import dao.CategoryDAO;
import dao.ClientDAO;
import dao.EmployeeDAO;
import dao.GoodsDAO;
import model.Category;
import model.Client;
import model.Employee;
import model.Goods;
import view.SearchResultsView;
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
	
	private String comboxFilter, comboxField;
	
	// constructor
	public SearchControl(SearchView searchView){
		this.searchView = searchView;
		this.events = new Events();
	
		this.categoryDAO = new CategoryDAO();
		this.clientDAO = new ClientDAO();
		this.employeeDAO = new EmployeeDAO();
		this.goodsDAO = new GoodsDAO();
		
		this.comboxFilter = "";
		this.comboxField = "";
		
		// add listeners
		searchView.getComboCampo().addActionListener(events);
		searchView.getComboFiltro().addActionListener(events);
		searchView.getLblButtonPesquisar().addMouseListener(events);
		searchView.getLblImageButtonVoltar().addMouseListener(events);
	}
	
	private void seek(){
		SearchResultsView searchResultsView = new SearchResultsView();
		comboxField = String.valueOf(searchView.getComboCampo().getSelectedItem());
		
		DefaultTableModel model = (DefaultTableModel) searchResultsView.getResultTable().getModel();
		model.setRowCount(0);
		
		searchResultsView.setVisible(true);
		String search = searchView.getTxtPesquisar().getText();
		
		if(comboxFilter.equals("categoria")){
			searchResultsView.getResultTable().getColumnModel().getColumn(0).setHeaderValue("id");
			searchResultsView.getResultTable().getColumnModel().getColumn(1).setHeaderValue("nome");
			searchResultsView.getResultTable().getColumnModel().getColumn(2).setHeaderValue("descrição");
			
			Category category = categoryDAO.findByName(search);
		
			model.addRow(new Object[]{" "+category.getId()," "+ category.getName()," "+ category.getDescription()});
			
		} else if(comboxFilter.equals("cliente")){
			searchResultsView.getResultTable().getColumnModel().getColumn(0).setHeaderValue("id");
			searchResultsView.getResultTable().getColumnModel().getColumn(1).setHeaderValue("nome");
			searchResultsView.getResultTable().getColumnModel().getColumn(2).setHeaderValue("telefone");

			List<Client> clientList = null;
	
			if(CONTENT_CLIENT[0].equals(comboxField))
				clientList = clientDAO.findByName(search);
			
			else if(CONTENT_CLIENT[1].equals(comboxField))
				clientList = clientDAO.findByDateOfBirth(search);
			
			else if(CONTENT_CLIENT[2].equals(comboxField))
				clientList = clientDAO.findByBalance(Double.parseDouble(search));
			
			else if(CONTENT_CLIENT[3].equals(comboxField))
				clientList = clientDAO.findByAmountSpent(Double.parseDouble(search));
			
			int size = clientList.size();
			
			for(int i = 0; i < size;  i++)	
				model.addRow(new Object[]{" "+clientList.get(i).getId()," "+ clientList.get(i).getName()," "+ clientList.get(i).getPhone()});
			
				
		} else if(comboxFilter.equals("funcionário")){
			searchResultsView.getResultTable().getColumnModel().getColumn(0).setHeaderValue("id");
			searchResultsView.getResultTable().getColumnModel().getColumn(1).setHeaderValue("nome");
			searchResultsView.getResultTable().getColumnModel().getColumn(2).setHeaderValue("cpf");
			
			List<Employee> employeeList = null;
			
			if(CONTENT_EMPLOYEE[0].equals(comboxField))
				employeeList = employeeDAO.findByName(search);
			
			else if(CONTENT_EMPLOYEE[1].equals(comboxField))
				employeeList = employeeDAO.findByDateOfBirth(search);
			
			else if(CONTENT_EMPLOYEE[2].equals(comboxField))
				employeeList = employeeDAO.findByCpf(search);
			
			else if(CONTENT_EMPLOYEE[3].equals(comboxField))
				employeeList = employeeDAO.findByCity(search);
			
			else if(CONTENT_EMPLOYEE[4].equals(comboxField))
				employeeList = employeeDAO.findByDistrict(search);
			
			else if(CONTENT_EMPLOYEE[5].equals(comboxField))
				employeeList = employeeDAO.findByState(search);
			
			else if(CONTENT_EMPLOYEE[6].equals(comboxField))
				employeeList = employeeDAO.findByType(search);
			
			int size = employeeList.size();
			
			for(int i = 0; i < size;  i++)	
				model.addRow(new Object[]{" "+employeeList.get(i).getId()," "+ employeeList.get(i).getName()," "+ employeeList.get(i).getCpf()});
			
		} else if(comboxFilter.equals("produto")){
			List<Goods> goodsList = null;

			if(CONTENT_GOODS[0].equals(comboxField))
				goodsList = goodsDAO.findByCode(Integer.parseInt(search));
			
			else if(CONTENT_GOODS[1].equals(comboxField)){
				Category tmpCategory = categoryDAO.findByName(search);
			
				goodsList = goodsDAO.findByCategoryId(tmpCategory.getId());
			}
			else if(CONTENT_GOODS[2].equals(comboxField))
				goodsList = goodsDAO.findByName(search);
		
			else if(CONTENT_GOODS[3].equals(comboxField))
				goodsList = goodsDAO.findByPrice(Double.parseDouble(search));
			
			else if(CONTENT_GOODS[4].equals(comboxField))
				goodsList = goodsDAO.findBySize(search);	
			
			int size = goodsList.size();
		
			for(int i = 0; i < size;  i++)	
				model.addRow(new Object[]{" "+goodsList.get(i).getId()," "+ goodsList.get(i).getName()," "+ goodsList.get(i).getSize()});
		}	
	}
	
	private void selectedComboxFilter(){
		comboxFilter = String.valueOf(searchView.getComboFiltro().getSelectedItem());
		searchView.getTxtPesquisar().setText("");
		searchView.getComboCampo().removeAllItems();
		
		if(comboxFilter.equals("categoria")){
			for(String s: CONTENT_CATEGORY)
				searchView.getComboCampo().addItem(s);
			
		} else if(comboxFilter.equals("cliente")){
			for(String s: CONTENT_CLIENT)
				searchView.getComboCampo().addItem(s);
			
		} else if(comboxFilter.equals("funcionário")){
			for(String s: CONTENT_EMPLOYEE)
				searchView.getComboCampo().addItem(s);

		} else if(comboxFilter.equals("produto")){
			for(String s: CONTENT_GOODS)
				searchView.getComboCampo().addItem(s);
		}
	}
	
	private class Events implements ActionListener, MouseListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == searchView.getComboFiltro())
				selectedComboxFilter();
		}
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == searchView.getLblImageButtonVoltar()){
				searchView.dispose();	
				categoryDAO.disconnect();
				clientDAO.disconnect();
				employeeDAO.disconnect();
				goodsDAO.disconnect();
			
			} else if(e.getSource() == searchView.getLblButtonPesquisar())
				seek();
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
