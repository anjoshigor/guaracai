package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import view.MenuView;
import view.RegisterView;
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
	
	// constructor
	public MenuControl(MenuView menuView){
		this.menuView = menuView;
		this.events = new Events();
		
		menuView.addKeyListener(events);
		
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
	
	// methods
	private void effectSelected(boolean bcad, boolean breal, boolean bcons, boolean bconfig, boolean bvend){
		menuView.getLblImageButtonCadastroOut().setVisible(bcad);
		menuView.getLblImageButtonRelatorioOut().setVisible(breal);
		menuView.getLblImageButtonConsultaOut().setVisible(bcons);
		menuView.getLblImageButtonConfiguracoesOut().setVisible(bconfig);
		menuView.getLblImageButtonVendaOut().setVisible(bvend);
	}
	
	// inner class
	private class Events implements ActionListener, KeyListener, MouseListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == menuView.getBtnNao())
				menuView.getPaneDialog().setVisible(false);
		
			else if(e.getSource() == menuView.getBtnSim())
				menuView.dispose();
		}
		@Override
		public void keyTyped(KeyEvent e) { /* unimplemented method */ }
		
		@Override
		public void keyPressed(KeyEvent e) {
			if(e.getID() == KeyEvent.VK_1){
				new RegisterView().setVisible(true);
			}
		}
		
		@Override
		public void keyReleased(KeyEvent e) { /* unimplemented method */ }
		
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
