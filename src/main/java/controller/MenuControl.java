package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import view.ConfigView;
import view.MenuView;
import view.RegisterView;
import view.SaleView;
import view.SearchView;

/**
 * 
 * @author marcos-alves
 *
 */
public class MenuControl {
	
	// attributes
	private MenuView menuView;
	private Events events;
	private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
	// constructor
	public MenuControl(MenuView menuView){
		this.menuView = menuView;
		this.events = new Events();
		
		this.menuView.getContentPane().getInputMap(IFW).put(KeyStroke.getKeyStroke("F1"),"cadastro");
		this.menuView.getContentPane().getInputMap(IFW).put(KeyStroke.getKeyStroke("F2"),"relatorio");
		this.menuView.getContentPane().getInputMap(IFW).put(KeyStroke.getKeyStroke("F3"),"consulta");
		this.menuView.getContentPane().getInputMap(IFW).put(KeyStroke.getKeyStroke("F4"),"configuracoes");
		this.menuView.getContentPane().getInputMap(IFW).put(KeyStroke.getKeyStroke("F5"),"venda");
		
		this.menuView.getContentPane().getActionMap().put("cadastro", cadastroAction);
		this.menuView.getContentPane().getActionMap().put("relatorio", relatorioAction);
		this.menuView.getContentPane().getActionMap().put("consulta", consultaAction);
		this.menuView.getContentPane().getActionMap().put("configuracoes", configuracoesAction);
		this.menuView.getContentPane().getActionMap().put("venda", vendaAction);

		
		menuView.getLblImageButtonCadastro().addMouseListener(events);
		menuView.getLblImageButtonRelatorio().addMouseListener(events);
		menuView.getLblImageButtonConsulta().addMouseListener(events);
		menuView.getLblImageButtonConfiguracoes().addMouseListener(events);
		menuView.getLblImageButtonVenda().addMouseListener(events);
		menuView.getLblImageButtonClose().addMouseListener(events);
		menuView.getLblCloseMessage().addMouseListener(events);
		menuView.getBtnNao().addActionListener(events);
		menuView.getBtnSim().addActionListener(events);
	}
	
/**ACTIONS**/
	
	Action cadastroAction = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
	    	new RegisterView().setVisible(true);
	    }
	};
	
	Action relatorioAction = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
	    	//unimplemented
	    }
	};
	
	Action consultaAction = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
	    	new SearchView().setVisible(true);
	    }
	};
	
	Action configuracoesAction = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
	    	new ConfigView().setVisible(true);
	    }
	};
	
	Action vendaAction = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
	    	new SaleView().setVisible(true);
	    }
	};
	
	// methods	
	private void effectSelected(boolean bcad, boolean breal, boolean bcons, boolean bconfig, boolean bvend){
		menuView.getLblImageButtonCadastroOut().setVisible(bcad);
		menuView.getLblImageButtonRelatorioOut().setVisible(breal);
		menuView.getLblImageButtonConsultaOut().setVisible(bcons);
		menuView.getLblImageButtonConfiguracoesOut().setVisible(bconfig);
		menuView.getLblImageButtonVendaOut().setVisible(bvend);
	}
	
	// inner class
	private class Events implements ActionListener, MouseListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == menuView.getBtnNao())
				menuView.getPaneDialog().setVisible(false);
		
			else if(e.getSource() == menuView.getBtnSim())
				menuView.dispose();
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == menuView.getLblImageButtonClose()){
				menuView.getPaneDialog().setVisible(true);
				menuView.getBtnNao().requestFocus();
			}
			else if(e.getSource() == menuView.getLblCloseMessage())
				menuView.getPaneDialog().setVisible(false);
			
			else if(e.getSource() == menuView.getLblImageButtonCadastro()){
				new RegisterView().setVisible(true);
			}
			else if(e.getSource() == menuView.getLblImageButtonConsulta()){
				new SearchView().setVisible(true);
			}
			else if(e.getSource() == menuView.getLblImageButtonVenda()){
				new SaleView().setVisible(true);
			}
			else if(e.getSource() == menuView.getLblImageButtonConfiguracoes()){
				new ConfigView().setVisible(true);
			}
		}
		
		@Override
		public void mousePressed(MouseEvent e) { /* unimplemented method */ }
		
		@Override
		public void mouseReleased(MouseEvent e) { /* unimplemented method */ }
		
		@Override
		public void mouseEntered(MouseEvent e) {
			if(menuView.getPaneDialog().isVisible())
				return;
			if(e.getSource() == menuView.getLblImageButtonCadastro())
				effectSelected(false, true, true, true, true);
			
			else if(e.getSource() == menuView.getLblImageButtonRelatorio())
				effectSelected(true, false, true, true, true);
			
			else if(e.getSource() == menuView.getLblImageButtonConsulta())
				effectSelected(true, true, false, true, true);
			
			else if(e.getSource() == menuView.getLblImageButtonConfiguracoes())
				effectSelected(true, true, true, false, true);
			
			else if(e.getSource() == menuView.getLblImageButtonVenda())
				effectSelected(true, true, true, true, false);
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			effectSelected(false, false, false, false, false);
		}
	}
}
