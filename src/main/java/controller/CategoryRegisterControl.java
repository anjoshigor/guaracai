package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import dao.CategoryDAO;
import model.Category;
import view.CategoryRegisterView;
import view.ConfigView;
import view.RegisterView;
import view.SaleView;
import view.SearchView;

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
	private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
	
	// constructor
	public CategoryRegisterControl(CategoryRegisterView categoryRegisterView){
		this.categoryRegisterView = categoryRegisterView;
		this.events = new Events();
		this.categoryDAO = new CategoryDAO();
		this.category = null;
		
		this.categoryRegisterView.getContentPane().getInputMap(IFW).put(KeyStroke.getKeyStroke("F11"),"cadastrar");
		this.categoryRegisterView.getContentPane().getInputMap(IFW).put(KeyStroke.getKeyStroke("F12"),"limpar");
		//TODO this.categoryRegisterView.getContentPane().getInputMap(IFW).put(KeyStroke.getKeyStroke("ESC"),"voltar");
		
		this.categoryRegisterView.getContentPane().getActionMap().put("cadastrar", cadastrarAction);
		this.categoryRegisterView.getContentPane().getActionMap().put("limpar", limparAction);
		this.categoryRegisterView.getContentPane().getActionMap().put("voltar", voltarAction);

		
		categoryRegisterView.getBtnCadastrar().addActionListener(events);
		categoryRegisterView.getBtnLimpar().addActionListener(events);
		categoryRegisterView.getBtnOK().addActionListener(events);
		categoryRegisterView.getLblImageButtonVoltar().addMouseListener(events);
		
		
	}
	

/**ACTIONS**/
	
	Action cadastrarAction = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
	    	insert();
	    }
	};
	
	Action limparAction = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
	    	cleanFields();
	    }
	};
	
	Action voltarAction = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
	    	categoryRegisterView.dispose();
	    	categoryDAO.disconnect();
	    }
	};
	
	
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
				categoryRegisterView.getBtnOK().requestFocus();
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
