package view;


import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import util.GraphicsUtil;

public class ConfigView extends JFrame {

	private JPanel contentPane;
	private JPanel panelMenu;
	private JLabel lblImageButtonBanco;
	private JLabel lblBanco;
	private JLabel lblImageBanco;
	private JLabel lblImageButtonBancoOut;
	private JLabel lblImageButtonVoltar;
	private JLabel lblVoltar;

	//TODO controller
	//private ConfigControl configControl;

	public ConfigView() {
		initConfigView();
		//configControl =  new ConfigControl(this);
		
	}
	
	private void initConfigView(){
		final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setSize(screenSize);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel(null);
		contentPane.setBackground(new Color(Integer.parseInt("9013FE", 16)));
		contentPane.setBorder(null);
		contentPane.setSize(screenSize);
		setContentPane(contentPane);
		
		lblVoltar = new JLabel("Voltar");
		lblVoltar.setForeground(Color.WHITE);
		lblVoltar.setFont(new Font("DejaVu Sans",Font.PLAIN, 24));
		lblVoltar.setBounds(getWidth() - 150,20,150,60);
		lblVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(lblVoltar);
	
		lblImageButtonVoltar =  new JLabel();
		lblImageButtonVoltar.setSize(150,60);
		lblImageButtonVoltar.setLocation(getWidth() - 200, 20);
		lblImageButtonVoltar.setIcon(GraphicsUtil.adjustImage("/drawable/botao-voltar.png", lblImageButtonVoltar.getSize()));
		lblImageButtonVoltar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(lblImageButtonVoltar);

		panelMenu = new JPanel(null);
		panelMenu.setSize(1024, 640);
		panelMenu.setLocation(GraphicsUtil.getLocaleCenter(panelMenu.getSize(), screenSize));
		panelMenu.setBackground(new Color(Integer.parseInt("9013FE", 16)));
		contentPane.add(panelMenu);
		
		lblImageButtonBancoOut = new JLabel();
		lblImageButtonBancoOut.setBounds(450, 200, 250, 250);
		lblImageButtonBancoOut.setIcon(GraphicsUtil.adjustImage("/drawable/background-out.png", lblImageButtonBancoOut.getSize()));
		lblImageButtonBancoOut.setVisible(false);
		panelMenu.add(lblImageButtonBancoOut);
		
		
		lblBanco = new JLabel("Exportar Banco");
		lblBanco.setForeground(Color.WHITE);
		lblBanco.setFont(new Font("DejaVu Sans", Font.PLAIN, 24));
		lblBanco.setBounds(470, 380, 200, 27);
		lblBanco.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblBanco.setHorizontalAlignment(SwingConstants.CENTER);
		panelMenu.add(lblBanco);
	
		lblImageBanco = new JLabel("");
		lblImageBanco.setBounds(510, 240, 128, 128);
		lblImageBanco.setIcon(GraphicsUtil.adjustImage("/drawable/database.png", lblImageBanco.getSize()));
		lblImageBanco.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblImageBanco);

		lblImageButtonBanco = new JLabel();
		lblImageButtonBanco.setBounds(450, 200, 250, 250);
		lblImageButtonBanco.setIcon(GraphicsUtil.adjustImage("/drawable/background-button.png", lblImageButtonBanco.getSize()));
		lblImageButtonBanco.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblImageButtonBanco);
	


	}
	
	public JLabel getLblImageButtonBanco() {
		return lblImageButtonBanco;
	}


	public JLabel getLblImageButtonBancoOut() {
		return lblImageButtonBancoOut;
	}


	public JPanel getContentPane() {
		return contentPane;
	}

	public JPanel getPanelMenu() {
		return panelMenu;
	}
}
