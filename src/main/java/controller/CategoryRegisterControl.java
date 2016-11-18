package controller;

import java.awt.Font;
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
import util.GraphicsUtil;
import util.SystemConstUtil;
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
	private short call;
	private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
	
	// constructor
	public CategoryRegisterControl(CategoryRegisterView categoryRegisterView){
		this.categoryRegisterView = categoryRegisterView;
		this.events = new Events();
		this.categoryDAO = new CategoryDAO();
		this.category = null;
		this.call = SystemConstUtil.INSERT;
		
		this.categoryRegisterView.getContentPane().getInputMap(IFW).put(KeyStroke.getKeyStroke("F11"),"cadastrar");
		this.categoryRegisterView.getContentPane().getInputMap(IFW).put(KeyStroke.getKeyStroke("F12"),"limpar");
		//TODO this.categoryRegisterView.getContentPane().getInputMap(IFW).put(KeyStroke.getKeyStroke("ESC"),"voltar");
		
		this.categoryRegisterView.getContentPane().getActionMap().put("cadastrar", cadastrarAction);
		this.categoryRegisterView.getContentPane().getActionMap().put("limpar", limparAction);
		this.categoryRegisterView.getContentPane().getActionMap().put("voltar", voltarAction);

		categoryRegisterView.getBtnNao().addActionListener(events);
		categoryRegisterView.getBtnSim().addActionListener(events);
		categoryRegisterView.getBtnCadastrar().addActionListener(events);
		categoryRegisterView.getBtnLimpar().addActionListener(events);
		categoryRegisterView.getBtnOK().addActionListener(events);
		categoryRegisterView.getLblImageButtonVoltar().addMouseListener(events);	
	}
	
	public CategoryRegisterControl(CategoryRegisterView categoryRegisterView, Category category){
		this(categoryRegisterView);
		
		this.call = SystemConstUtil.UPDATE;
		this.category = category;
		categoryRegisterView.getBtnCadastrar().setText("Atualizar");
		categoryRegisterView.getBtnLimpar().setText("Deletar");
		categoryRegisterView.getLblTitleCategory().setText("Atualização de Categoria");
		categoryRegisterView.getLblTitleCategory().setFont(new Font("DejaVu Sans", Font.PLAIN, 48));
		
		categoryRegisterView.getTxtNome().setText(category.getName());
		categoryRegisterView.getTxtDescricao().setText(category.getDescription());
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
	
	
	public boolean checkFields(){
		if(categoryRegisterView.getTxtNome().getText().isEmpty() || 
		   categoryRegisterView.getTxtDescricao().getText().isEmpty())
			return false;
		return true;
	}
	
	private void cleanFields(){
		categoryRegisterView.getTxtNome().setText("");
		categoryRegisterView.getTxtDescricao().setText("");
	}
	
	private void inflate(){
		category.setName(categoryRegisterView.getTxtNome().getText());
		category.setDescription(categoryRegisterView.getTxtDescricao().getText());
	}
	
	private void insert(){
		category = new Category();
		inflate();
		
		if(checkFields()) {
			showPanelDialog();
			categoryDAO.add(category);
		} else {
			categoryRegisterView.getLblMessageError().setVisible(true);
		} 
	}
	
	private void showPanelDialog(){
		categoryRegisterView.getPanelDialog().setVisible(true);
		
		categoryRegisterView.getTxtDescricao().setEnabled(false);
		categoryRegisterView.getTxtNome().setEnabled(false);
		
		categoryRegisterView.getBtnCadastrar().setEnabled(false);
		categoryRegisterView.getBtnLimpar().setEnabled(false);
	}
	
	private void disposePanelDialog(){
		categoryRegisterView.getPanelDialog().setVisible(false);
		
		categoryRegisterView.getTxtDescricao().setEnabled(true);
		categoryRegisterView.getTxtNome().setEnabled(true);
		
		categoryRegisterView.getBtnCadastrar().setEnabled(true);
		categoryRegisterView.getBtnLimpar().setEnabled(true);
		
		cleanFields();
	}
	
	private void update(){
		inflate();
		
		if(checkFields()){
			showPanelDialog();
			categoryDAO.update(category);
		} else 
			categoryRegisterView.getLblMessageError().setVisible(true);
	}
	
	// inner class
	private class Events implements ActionListener, MouseListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == categoryRegisterView.getBtnCadastrar()){
				if(call == SystemConstUtil.INSERT)
					insert();
				else if(call == SystemConstUtil.UPDATE)
					update();
			} else if(e.getSource() == categoryRegisterView.getBtnOK()){
				disposePanelDialog();
				if(call == SystemConstUtil.UPDATE)
					categoryRegisterView.dispose();
				
			} else if (e.getSource() == categoryRegisterView.getBtnLimpar()){
				if(call == SystemConstUtil.INSERT)
					cleanFields();
				else if(call == SystemConstUtil.UPDATE){
					categoryRegisterView.getBtnOK().setVisible(false);
					categoryRegisterView.getBtnSim().setVisible(true);
					categoryRegisterView.getBtnNao().setVisible(true);
					
					categoryRegisterView.getLblMessagedialog().setText("<html>Deseja realmente<br>excluir registro ?<html>");
					categoryRegisterView.getLblIconMessage().setIcon(GraphicsUtil.adjustImage("/drawable/warning.png", 
																		categoryRegisterView.getLblIconMessage().getSize()));
					showPanelDialog();
				}
			} else if(e.getSource() == categoryRegisterView.getBtnSim()){
				categoryDAO.delete(category);
				categoryRegisterView.dispose();
			
			} else if(e.getSource() == categoryRegisterView.getBtnNao()){
				categoryRegisterView.dispose();
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
