package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import dao.CategoryDAO;
import model.Category;
import view.CategoryRegisterView;

/**
 * 
 * @author alvesmarcos
 *
 */
public class CategoryRegisterControl {
	
	// attributes
	private CategoryRegisterView categoryRegisterView;
	private Events events;
	private CategoryDAO categoryDAO;
	private Category category;
	
	// constructor
	public CategoryRegisterControl(CategoryRegisterView categoryRegisterView){
		this.categoryRegisterView = categoryRegisterView;
		this.events = new Events();
		this.categoryDAO = new CategoryDAO();
		this.category = null;
		
		categoryRegisterView.getBtnCadastrar().addActionListener(events);
		categoryRegisterView.getBtnLimpar().addActionListener(events);
		categoryRegisterView.getBtnOK().addActionListener(events);
		categoryRegisterView.getLblImageButtonVoltar().addMouseListener(events);
		
		
	}
	
	private void cleanFields(){
		categoryRegisterView.getTxtNome().setText("");
		categoryRegisterView.getTxtDescricao().setText("");
	}
	
	private void insert(){
		category = new Category();
		
		if(categoryRegisterView.getTxtNome().getText().isEmpty() || 
		   categoryRegisterView.getTxtDescricao().getText().isEmpty()) {
			categoryRegisterView.getLblMessageError().setVisible(true);
		} else {
			category.setName(categoryRegisterView.getTxtNome().getText());
			category.setDescription(categoryRegisterView.getTxtDescricao().getText());
			
			if(categoryDAO.add(category)==1){
				categoryRegisterView.getPanelDialog().setVisible(true);
			} 
			
		}
	}
	
	// inner class
	private class Events implements ActionListener, MouseListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == categoryRegisterView.getBtnCadastrar()){
				insert();
			}else if(e.getSource() == categoryRegisterView.getBtnOK()){
					categoryRegisterView.getPanelDialog().setVisible(false);
					cleanFields();
			} if (e.getSource() == categoryRegisterView.getBtnLimpar()){
					cleanFields();
			}
		}

		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == categoryRegisterView.getLblImageButtonVoltar()){
				categoryRegisterView.dispose();
				categoryDAO.disconnect();
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
	}
}
