package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import controller.MenuControl;
import util.GraphicsUtil;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;
/**
 * 
 * @author alvesmarcos
 *
 */
public class MenuView extends JFrame {
	
	// atributes
	private JPanel contentPane;
	private JPanel panelMenu;
	private JLabel lblImageButtonCadastro;
	private JLabel lblImageButtonRelatorio;
	private JLabel lblImageButtonConsulta;
	private JLabel lblImageButtonConfiguracoes;
	private JLabel lblImageButtonVenda;
	private JLabel lblCadastro;
	private JLabel lblRelatorio;
	private JLabel lblConsulta;
	private JLabel lblConfiguracoes;
	private JLabel lblVenda;
	private JLabel lblImageCadastro;
	private JLabel lblImageRelatorio;
	private JLabel lblImageConsulta;
	private JLabel lblImageConfiguracoes;
	private JLabel lblImageVenda;
	private JLabel lblImageButtonCadastroOut;
	private JLabel lblImageButtonRelatorioOut;
	private JLabel lblImageButtonConsultaOut;
	private JLabel lblImageButtonConfiguracoesOut;
	private JLabel lblImageButtonVendaOut;
	private JLabel lblImageButtonClose;
	private JPanel panelDialog;
	private JLabel lblCloseMessage;
	private JLabel lblIconMessage;
	private JLabel lblMessagedialog;
	private JButton btnNao;
	private JButton btnSim;
	
	
	// controller
	private MenuControl menuControl;
	
	// constructor
	public MenuView() {
		initMenuView();
		menuControl = new MenuControl(this);
	}
	
	// methods
	private void initMenuView(){
		final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setSize(screenSize);
		setLocationRelativeTo(null);
		
		contentPane = new JPanel(null);
		contentPane.setBackground(new Color(Integer.parseInt("9013FE", 16)));
		contentPane.setBorder(null);
		contentPane.setSize(screenSize);
		setContentPane(contentPane);

		panelMenu = new JPanel(null);
		panelMenu.setSize(1024, 640);
		panelMenu.setLocation(GraphicsUtil.getLocaleCenter(panelMenu.getSize(), screenSize));
		panelMenu.setBackground(new Color(Integer.parseInt("9013FE", 16)));
		contentPane.add(panelMenu);
		
		panelDialog = new JPanel();
		panelDialog.setBackground(new Color(Integer.parseInt("827C7B", 16)));
		panelDialog.setBorder(new LineBorder(Color.WHITE, 2));
		panelDialog.setBounds(300, 190, 416, 225);
		panelDialog.setLayout(null);
		panelDialog.setVisible(false);
		panelMenu.add(panelDialog);
		
		lblCloseMessage = new JLabel();
		lblCloseMessage.setBounds(376, 15, 24, 24);
		lblCloseMessage.setIcon(GraphicsUtil.adjustImage("/drawable/button-exit.png", lblCloseMessage.getSize()));
		lblCloseMessage.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelDialog.add(lblCloseMessage);
		
		lblIconMessage = new JLabel("");
		lblIconMessage.setBounds(25, 46, 100, 100);
		lblIconMessage.setIcon(GraphicsUtil.adjustImage("/drawable/warning.png", lblIconMessage.getSize()));
		panelDialog.add(lblIconMessage);
		
		lblMessagedialog = new JLabel("<html>Você realmente<br>deseja sair ?<html>");
		lblMessagedialog.setForeground(Color.WHITE);
		lblMessagedialog.setFont(new Font("DejaVu Sans", Font.PLAIN, 26));
		lblMessagedialog.setBounds(151, 46, 208, 97);
		panelDialog.add(lblMessagedialog);
		
		btnNao = new JButton("NÃO");
		btnNao.setBackground(Color.WHITE);
		btnNao.setForeground(Color.DARK_GRAY);
		btnNao.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		btnNao.setBounds(254, 158, 105, 34);
		panelDialog.add(btnNao);
		
		btnSim = new JButton("SIM");
		btnSim.setBackground(Color.WHITE);
		btnSim.setForeground(Color.DARK_GRAY);
		btnSim.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		btnSim.setBounds(134, 158, 105, 34);
		panelDialog.add(btnSim);
		
		lblImageButtonClose = new JLabel();
		lblImageButtonClose.setSize(50, 50);
		lblImageButtonClose.setLocation(screenSize.width-140, 20);
		lblImageButtonClose.setIcon(GraphicsUtil.adjustImage("/drawable/button-exit.png", lblImageButtonClose.getSize()));
		lblImageButtonClose.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(lblImageButtonClose);
		
		lblImageButtonCadastroOut = new JLabel();
		lblImageButtonCadastroOut.setBounds(28, 61, 250, 250);
		lblImageButtonCadastroOut.setIcon(GraphicsUtil.adjustImage("/drawable/background-out.png", lblImageButtonCadastroOut.getSize()));
		lblImageButtonCadastroOut.setVisible(false);
		panelMenu.add(lblImageButtonCadastroOut);
		
		lblImageButtonRelatorioOut = new JLabel();
		lblImageButtonRelatorioOut.setBounds(392, 61, 250, 250);
		lblImageButtonRelatorioOut.setIcon(GraphicsUtil.adjustImage("/drawable/background-out.png", lblImageButtonRelatorioOut.getSize()));
		lblImageButtonRelatorioOut.setVisible(false);
		panelMenu.add(lblImageButtonRelatorioOut);
		
		lblImageButtonConsultaOut = new JLabel();
		lblImageButtonConsultaOut.setBounds(746, 61, 250, 250);
		lblImageButtonConsultaOut.setIcon(GraphicsUtil.adjustImage("/drawable/background-out.png", lblImageButtonConsultaOut.getSize()));
		lblImageButtonConsultaOut.setVisible(false);
		panelMenu.add(lblImageButtonConsultaOut);
		
		lblImageButtonConfiguracoesOut = new JLabel();
		lblImageButtonConfiguracoesOut.setBounds(211, 363, 250, 250);
		lblImageButtonConfiguracoesOut.setIcon(GraphicsUtil.adjustImage("/drawable/background-out.png", lblImageButtonConfiguracoesOut.getSize()));
		lblImageButtonConfiguracoesOut.setVisible(false);
		panelMenu.add(lblImageButtonConfiguracoesOut);
		
		
		lblImageButtonVendaOut = new JLabel();
		lblImageButtonVendaOut.setBounds(572, 363, 250, 250);
		lblImageButtonVendaOut.setIcon(GraphicsUtil.adjustImage("/drawable/background-out.png", lblImageButtonVendaOut.getSize()));
		lblImageButtonVendaOut.setVisible(false);
		panelMenu.add(lblImageButtonVendaOut);
		
		lblCadastro = new JLabel("Cadastro (F1)");
		lblCadastro.setFont(new Font("DejaVu Sans", Font.PLAIN, 24));
		lblCadastro.setForeground(Color.WHITE);
		lblCadastro.setBounds(68, 248, 171, 27);
		lblCadastro.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblCadastro);
		
		lblRelatorio = new JLabel("Relatório (F2)");
		lblRelatorio.setForeground(Color.WHITE);
		lblRelatorio.setFont(new Font("DejaVu Sans", Font.PLAIN, 24));
		lblRelatorio.setBounds(435, 248, 171, 27);
		lblRelatorio.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblRelatorio);
		
		lblConsulta = new JLabel("Consulta (F3)");
		lblConsulta.setForeground(Color.WHITE);
		lblConsulta.setFont(new Font("DejaVu Sans", Font.PLAIN, 24));
		lblConsulta.setBounds(790, 248, 171, 27);
		lblConsulta.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblConsulta);
		
		lblConfiguracoes = new JLabel("Config. (F4)");
		lblConfiguracoes.setForeground(Color.WHITE);
		lblConfiguracoes.setFont(new Font("DejaVu Sans", Font.PLAIN, 24));
		lblConfiguracoes.setBounds(259, 550, 171, 27);
		lblConfiguracoes.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblConfiguracoes); 
		
		lblVenda = new JLabel("Venda (F5)");
		lblVenda.setForeground(Color.WHITE);
		lblVenda.setFont(new Font("DejaVu Sans", Font.PLAIN, 24));
		lblVenda.setBounds(630, 550, 171, 27);
		lblVenda.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblVenda);
		
		lblImageCadastro = new JLabel("");
		lblImageCadastro.setIcon(new ImageIcon(MenuView.class.getResource("/drawable/plus.png")));
		lblImageCadastro.setBounds(87, 95, 128, 128);
		lblImageCadastro.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblImageCadastro);
		
		lblImageRelatorio = new JLabel("");
		lblImageRelatorio.setIcon(new ImageIcon(MenuView.class.getResource("/drawable/newspaper.png")));
		lblImageRelatorio.setBounds(452, 95, 128, 128);
		lblImageRelatorio.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblImageRelatorio);
		
		lblImageConsulta = new JLabel("");
		lblImageConsulta.setIcon(new ImageIcon(MenuView.class.getResource("/drawable/search.png")));
		lblImageConsulta.setBounds(804, 95, 128, 128);
		lblImageConsulta.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblImageConsulta);
		
		lblImageConfiguracoes = new JLabel("");
		lblImageConfiguracoes.setBounds(269, 397, 128, 128);
		lblImageConfiguracoes.setIcon(new ImageIcon(MenuView.class.getResource("/drawable/settings.png")));
		lblImageConfiguracoes.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblImageConfiguracoes);
		
		lblImageVenda = new JLabel("");
		lblImageVenda.setBounds(633, 397, 128, 128);
		lblImageVenda.setIcon(new ImageIcon(MenuView.class.getResource("/drawable/stopwatch.png")));
		lblImageVenda.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblImageVenda);
		
		lblImageButtonVenda = new JLabel();
		lblImageButtonVenda.setBounds(572, 363, 250, 250);
		lblImageButtonVenda.setIcon(GraphicsUtil.adjustImage("/drawable/background-button.png", lblImageButtonVenda.getSize()));
		lblImageButtonVenda.setCursor(new Cursor(Cursor.HAND_CURSOR));

		panelMenu.add(lblImageButtonVenda);
		
		lblImageButtonCadastro = new JLabel();
		lblImageButtonCadastro.setBounds(28, 61, 250, 250);
		lblImageButtonCadastro.setIcon(GraphicsUtil.adjustImage("/drawable/background-button.png", lblImageButtonCadastro.getSize()));
		lblImageButtonCadastro.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblImageButtonCadastro);
	
		lblImageButtonRelatorio = new JLabel();
		lblImageButtonRelatorio.setBounds(392, 61, 250, 250);
		lblImageButtonRelatorio.setIcon(GraphicsUtil.adjustImage("/drawable/background-button.png", lblImageButtonRelatorio.getSize()));
		lblImageButtonRelatorio.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblImageButtonRelatorio);
		
		lblImageButtonConsulta = new JLabel();
		lblImageButtonConsulta.setBounds(746, 61, 250, 250);
		lblImageButtonConsulta.setIcon(GraphicsUtil.adjustImage("/drawable/background-button.png", lblImageButtonConsulta.getSize()));
		lblImageButtonConsulta.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblImageButtonConsulta);
		
		lblImageButtonConfiguracoes = new JLabel();
		lblImageButtonConfiguracoes.setBounds(211, 363, 250, 250);
		lblImageButtonConfiguracoes.setIcon(GraphicsUtil.adjustImage("/drawable/background-button.png", lblImageButtonConfiguracoes.getSize()));
		lblImageButtonConfiguracoes.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblImageButtonConfiguracoes);
		
		
	}
	
	// methods getters
	public JLabel getLblImageButtonCadastro() {
		return lblImageButtonCadastro;
	}
	
	public JLabel getLblImageButtonClose() {
		return lblImageButtonClose;
	}

	public JLabel getLblImageButtonRelatorio() {
		return lblImageButtonRelatorio;
	}

	public JLabel getLblImageButtonConsulta() {
		return lblImageButtonConsulta;
	}

	public JLabel getLblImageButtonConfiguracoes() {
		return lblImageButtonConfiguracoes;
	}

	public JLabel getLblImageButtonVenda() {
		return lblImageButtonVenda;
	}

	public JLabel getLblImageButtonCadastroOut() {
		return lblImageButtonCadastroOut;
	}

	public JLabel getLblImageButtonRelatorioOut() {
		return lblImageButtonRelatorioOut;
	}

	public JLabel getLblImageButtonConsultaOut() {
		return lblImageButtonConsultaOut;
	}

	public JLabel getLblImageButtonConfiguracoesOut() {
		return lblImageButtonConfiguracoesOut;
	}

	public JLabel getLblImageButtonVendaOut() {
		return lblImageButtonVendaOut;
	}
	
	public JPanel getPaneDialog() {
		return panelDialog;	
	}
	
	public JButton getBtnNao() {
		return btnNao;
	}

	public JButton getBtnSim() {
		return btnSim;
	}

	public JLabel getLblCloseMessage() {
		return lblCloseMessage;
	}
}
