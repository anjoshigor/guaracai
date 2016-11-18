package controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

//import controller.RegisterControl.Events;
import view.RegisterView;

import view.CategoryRegisterView;
import view.ClientRegisterView;
import view.EmployeeRegisterView;
import view.GoodsRegisterView;

public class RegisterControl {
	
	// attributes
		private RegisterView registerView;
		//private MenuView menuView;
		private Events events;
		private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
		
		public RegisterControl(RegisterView registerView){
			
			this.registerView = registerView;
			this.events = new Events();
			
			this.registerView.getContentPane().getInputMap(IFW).put(KeyStroke.getKeyStroke("F1"),"produto");
			this.registerView.getContentPane().getInputMap(IFW).put(KeyStroke.getKeyStroke("F2"),"cliente");
			this.registerView.getContentPane().getInputMap(IFW).put(KeyStroke.getKeyStroke("F3"),"funcionario");
			this.registerView.getContentPane().getInputMap(IFW).put(KeyStroke.getKeyStroke("F4"),"categoria");
			
			this.registerView.getContentPane().getActionMap().put("produto", produtoAction);
			this.registerView.getContentPane().getActionMap().put("cliente", clienteAction);
			this.registerView.getContentPane().getActionMap().put("funcionario", funcionarioAction);
			this.registerView.getContentPane().getActionMap().put("categoria", categoriaAction);

			
			registerView.getLblImageButtonProduto().addMouseListener(events);
			registerView.getLblImageButtonCliente().addMouseListener(events);
			registerView.getLblImageButtonFuncionario().addMouseListener(events);
			registerView.getLblImageButtonCategoria().addMouseListener(events);
			registerView.getLblImageButtonVoltar().addMouseListener(events);
		}
	

		/**ACTIONS**/
	
		Action produtoAction = new AbstractAction() {
		    public void actionPerformed(ActionEvent e) {
		    	new GoodsRegisterView().setVisible(true);
		    }
		};
		
		Action clienteAction = new AbstractAction() {
		    public void actionPerformed(ActionEvent e) {
		    	new ClientRegisterView().setVisible(true);
		    }
		};
		
		Action funcionarioAction = new AbstractAction() {
		    public void actionPerformed(ActionEvent e) {
		    	new EmployeeRegisterView().setVisible(true);
		    }
		};
		
		Action categoriaAction = new AbstractAction() {
		    public void actionPerformed(ActionEvent e) {
		    	new CategoryRegisterView().setVisible(true);
		    }
		};
			
		// methods
		private void effectSelected(boolean bprod, boolean bcli, boolean bfun, boolean bcat){
			registerView.getLblImageButtonProdutoOut().setVisible(bprod);
			registerView.getLblImageButtonClienteOut().setVisible(bcli);
			registerView.getLblImageButtonFuncionarioOut().setVisible(bfun);
			registerView.getLblImageButtonCategoriaOut().setVisible(bcat);
		}
		
		// inner class
		private class Events implements MouseListener {
			@Override	
			public void mouseClicked(MouseEvent e) {
				if(e.getSource() == registerView.getLblImageButtonVoltar()){
					registerView.dispose();
				}
				if(e.getSource() == registerView.getLblImageButtonCategoria() ){
					new CategoryRegisterView().setVisible(true);
					registerView.dispose();
				}
				if(e.getSource() == registerView.getLblImageButtonProduto() ){
					GoodsRegisterView cadastro = new GoodsRegisterView();
					cadastro.setWhoCalled(1);
					cadastro.setVisible(true);
					registerView.dispose();
				}
				if(e.getSource() == registerView.getLblImageButtonCliente() ){
					new ClientRegisterView().setVisible(true);
					registerView.dispose();
				}
				if(e.getSource() == registerView.getLblImageButtonFuncionario() ){
					new EmployeeRegisterView().setVisible(true);
					registerView.dispose();
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) { /* unimplemented method */  }
			
			@Override
			public void mouseReleased(MouseEvent e) { /* unimplemented method */ }
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				if(e.getSource() == registerView.getLblImageButtonProduto())
					effectSelected(false, true, true, true);
				
				else if(e.getSource() == registerView.getLblImageButtonCliente())
					effectSelected(true, false, true, true);
				
				else if(e.getSource() == registerView.getLblImageButtonFuncionario())
					effectSelected(true, true, false, true);
				
				else if(e.getSource() == registerView.getLblImageButtonCategoria())
					effectSelected(true, true, true, false);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				effectSelected(false, false, false, false);
			}
		}
}