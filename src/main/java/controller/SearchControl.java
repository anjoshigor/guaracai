package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

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
		
		DefaultTableModel model = (DefaultTableModel) searchResultsView.getResultTable().getModel();
		model.setRowCount(0);
		
		searchResultsView.setVisible(true);
		String search = searchView.getTxtPesquisar().getText();
		
		if(comboxFilter.equals("categoria")){
			searchResultsView.getResultTable().getColumnModel().getColumn(0).setHeaderValue("id");
			searchResultsView.getResultTable().getColumnModel().getColumn(1).setHeaderValue("nome");
			searchResultsView.getResultTable().getColumnModel().getColumn(2).setHeaderValue("descrição");
			
			List<Category> categoryList = categoryDAO.findByName(search);
			
			int size = categoryList.size();
			
			for(int i = 0; i < size;  i++)	
				model.addRow(new Object[]{" "+categoryList.get(i).getId()," "+ categoryList.get(i).getName()," "+ categoryList.get(i).getDescription()});
			
		} else if(comboxFilter.equals("cliente")){
			searchResultsView.getResultTable().getColumnModel().getColumn(0).setHeaderValue("id");
			searchResultsView.getResultTable().getColumnModel().getColumn(1).setHeaderValue("nome");
			searchResultsView.getResultTable().getColumnModel().getColumn(2).setHeaderValue("telefone");

			List<Client> clientList = null;
	
			if(CONTENT_CLIENT[0].equals("nome"))
				clientList = clientDAO.findByName(search);
			
			else if(CONTENT_CLIENT[1].equals("nascimento"))
				clientList = clientDAO.findByDateOfBirth(search);
			
			else if(CONTENT_CLIENT[2].equals("saldo"))
				clientList = clientDAO.findByBalance(Double.parseDouble(search));
			
			else if(CONTENT_CLIENT[3].equals("valor em compras"))
				clientList = clientDAO.findByAmountSpent(Double.parseDouble(search));
			
			int size = clientList.size();
			
			for(int i = 0; i < size;  i++)	
				model.addRow(new Object[]{" "+clientList.get(i).getId()," "+ clientList.get(i).getName()," "+ clientList.get(i).getPhone()});
			
				
		} else if(comboxFilter.equals("funcionário")){
			searchResultsView.getResultTable().getColumnModel().getColumn(0).setHeaderValue("id");
			searchResultsView.getResultTable().getColumnModel().getColumn(1).setHeaderValue("nome");
			searchResultsView.getResultTable().getColumnModel().getColumn(2).setHeaderValue("cpf");
			
			List<Employee> employeeList = null;
			
			if(CONTENT_EMPLOYEE[0].equals("nome"))
				employeeList = employeeDAO.findByName(search);
			
			else if(CONTENT_EMPLOYEE[1].equals("data nascimento"))
				employeeList = employeeDAO.findByDateOfBirth(search);
			
			else if(CONTENT_EMPLOYEE[2].equals("cpf"))
				employeeList = employeeDAO.findByCpf(search);
			
			else if(CONTENT_EMPLOYEE[3].equals("cidade"))
				employeeList = employeeDAO.findByCity(search);
			
			else if(CONTENT_EMPLOYEE[4].equals("bairro"))
				employeeList = employeeDAO.findByDistrict(search);
			
			else if(CONTENT_EMPLOYEE[5].equals("estado"))
				employeeList = employeeDAO.findByState(search);
			
			else if(CONTENT_EMPLOYEE[6].equals("tipo"))
				employeeList = employeeDAO.findByType(search);
			
			int size = employeeList.size();
			
			for(int i = 0; i < size;  i++)	
				model.addRow(new Object[]{" "+employeeList.get(i).getId()," "+ employeeList.get(i).getName()," "+ employeeList.get(i).getCpf()});
			
		} else if(comboxFilter.equals("produto")){
			List<Goods> goodsList = null;
			
			if(CONTENT_GOODS[0].equals("codigo"))
				goodsList = goodsDAO.findByCode(Integer.parseInt(search));
			
			else if(CONTENT_GOODS[1].equals("categoria"))
				goodsList = goodsDAO.findByCategoryId(Integer.parseInt(search));
	
			else if(CONTENT_GOODS[2].equals("nome"))
				goodsList = goodsDAO.findByName(search);
			
			else if(CONTENT_GOODS[3].equals("preço"))
				goodsList = goodsDAO.findByPrice(Double.parseDouble(search));
			
			else if(CONTENT_GOODS[4].equals("codigo"))
				goodsList = goodsDAO.findByCode(Integer.parseInt(search));	
			
			int size = goodsList.size();
			
			for(int i = 0; i < size;  i++)	
				model.addRow(new Object[]{" "+goodsList.get(i).getId()," "+ goodsList.get(i).getName()," "+ goodsList.get(i).getSize()});
		}	
	}
	
	private void selectedComboxFilter(){
		comboxFilter = String.valueOf(searchView.getComboFiltro().getSelectedItem());
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
	
	private void selectedComboxFieldFormatter() throws ParseException {
		comboxField = String.valueOf(searchView.getComboCampo().getSelectedItem());
		MaskFormatter mask;
		
		if(comboxField.equals("data nascimento")){
			// mask date
			mask = new MaskFormatter("##/##/####");
			mask.install(searchView.getTxtPesquisar());
			
		} else if(comboxField.equals("cpf")){
			// mask cpf
			mask = new MaskFormatter("###.###.###-##");
			mask.install(searchView.getTxtPesquisar());

		} else if(comboxField.equals("estado")){
			//TODO
		} 
	}
	
	private class Events implements ActionListener, MouseListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == searchView.getComboFiltro())
				selectedComboxFilter();
			else if (e.getSource() == searchView.getComboCampo()){
				try {
					selectedComboxFieldFormatter();
				} catch (ParseException ep) {
					ep.printStackTrace();
				}
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
			
			} else if(e.getSource() == searchView.getLblButtonPesquisar()){
				seek();
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
