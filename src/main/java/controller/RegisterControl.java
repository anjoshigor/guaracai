package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//import controller.RegisterControl.Events;
import view.RegisterView;
import view.MenuView;
import view.CategoryRegisterView;
import view.ClientRegisterView;
import view.GoodsRegisterView;

public class RegisterControl {
	
	// attributes
		private RegisterView registerView;
		//private MenuView menuView;
		private Events events;
		
		public RegisterControl(RegisterView registerView){
			
			this.registerView = registerView;
			this.events = new Events();
			
			registerView.getLblImageButtonProduto().addMouseListener(events);
			registerView.getLblImageButtonCliente().addMouseListener(events);
			registerView.getLblImageButtonFuncionario().addMouseListener(events);
			registerView.getLblImageButtonCategoria().addMouseListener(events);
			registerView.getLblImageButtonVoltar().addMouseListener(events);
		}
	
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
				}
				if(e.getSource() == registerView.getLblImageButtonProduto() ){
					new GoodsRegisterView().setVisible(true);
				}
				if(e.getSource() == registerView.getLblImageButtonCliente() ){
					new ClientRegisterView().setVisible(true);
				}
			}
			
			@Override
			public void mousePressed(MouseEvent e) { /* unimplemented method */  }
			
			@Override
			public void mouseReleased(MouseEvent e) { /* unimplemented method */ }
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
				if(e.getSource() == registerView.getLblImageButtonProduto())
					effectSelected(true, false, false, false);
				
				else if(e.getSource() == registerView.getLblImageButtonCliente())
					effectSelected(false, true, false, false);
				
				else if(e.getSource() == registerView.getLblImageButtonFuncionario())
					effectSelected(false, false, true, false);
				
				else if(e.getSource() == registerView.getLblImageButtonCategoria())
					effectSelected(false, false, false, true);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				effectSelected(false, false, false, false);
			}
		}
}