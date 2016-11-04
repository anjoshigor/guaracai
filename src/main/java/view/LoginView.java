package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import util.GraphicsUtil;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import controller.LoginControl;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
/**
 * 
 * @author marcos-alves
 *
 */
@SuppressWarnings("serial")
public class LoginView extends JFrame {
	
	// attributes
	private JPanel contentPane;
	private JLabel lblImageGuaracai;
	private JPanel panelLogin;
	private JLabel lblUsuario;
	private JLabel lblSenha;
	private JTextField txtUsuario;
	private JPasswordField pwdSenha;
	private JLabel lblBemVindo;
	private JButton btnEntrar;
	private JPanel panelWhiteUser;
	private JPanel panelWhitePwd;
	private JLabel lblImageLoading;
	private JLabel lblMessageError;
	
	// controller
	private LoginControl loginControl;
	
	// constructor
	public LoginView() {
		initLoginView();
		loginControl = new LoginControl(this);
	}
	
	// methods
	private void initLoginView() {
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
		
		panelLogin = new JPanel(null);
		panelLogin.setSize(800, 600);
		panelLogin.setLocation(GraphicsUtil.getLocaleCenter(panelLogin.getSize(), screenSize));
		panelLogin.setBackground(new Color(Integer.parseInt("9013FE", 16)));
		contentPane.add(panelLogin);
		
		lblImageGuaracai = new JLabel();
		lblImageGuaracai.setSize(350, 300);
		lblImageGuaracai.setLocation(GraphicsUtil.getLocaleCenterX(lblImageGuaracai.getSize(), 
																   panelLogin.getSize()), 20);
		lblImageGuaracai.setIcon(GraphicsUtil.adjustImage("/drawable/Logo.png", lblImageGuaracai.getSize()));
		panelLogin.add(lblImageGuaracai);
		
		lblUsuario = new JLabel("usuário");
		lblUsuario.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBounds(206, 391, 105, 33);
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblImageGuaracai.setVerticalAlignment(SwingConstants.CENTER);
		lblUsuario.setOpaque(true);
		lblUsuario.setBackground(new Color(Integer.parseInt("BD7DF5", 16)));
		panelLogin.add(lblUsuario);
		
		panelWhiteUser = new JPanel(null);
		panelWhiteUser.setBounds(206, 391, 112, 33);
		panelWhiteUser.setBackground(Color.WHITE);
		panelLogin.add(panelWhiteUser);
		
		lblSenha = new JLabel("senha");
		lblSenha.setOpaque(true);
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblSenha.setBackground(new Color(189, 125, 245));
		lblSenha.setBounds(206, 434, 105, 33);
		panelLogin.add(lblSenha);
		
		panelWhitePwd = new JPanel(null);
		panelWhitePwd.setBounds(206, 434, 112, 33);
		panelWhitePwd.setBackground(Color.WHITE);
		panelLogin.add(panelWhitePwd);
		
		txtUsuario = new JTextField();
		txtUsuario.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		txtUsuario.setBorder(null);
		txtUsuario.setBounds(314, 391, 276, 33);
		panelLogin.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		pwdSenha = new JPasswordField();
		pwdSenha.setBorder(null);
		pwdSenha.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		pwdSenha.setBounds(314, 434, 276, 33);
		panelLogin.add(pwdSenha);
		
		lblBemVindo = new JLabel("Bem-vindo ao Guaraçaí.");
		lblBemVindo.setForeground(Color.WHITE);
		lblBemVindo.setFont(new Font("DejaVu Sans", Font.PLAIN, 26));
		lblBemVindo.setBounds(235, 345, 326, 39);
		panelLogin.add(lblBemVindo);
		
		lblImageLoading = new JLabel();
		lblImageLoading.setBounds(389, 485, 50, 50);
		lblImageLoading.setIcon(new ImageIcon(LoginView.class.getResource("/drawable/ajax-loader.gif")));
		lblImageLoading.setVisible(false);
		
		btnEntrar = new JButton("ENTRAR");
		btnEntrar.setBorder(null);
		btnEntrar.setBackground(new Color(Integer.parseInt("4A90E2", 16)));
		btnEntrar.setForeground(Color.WHITE);
		btnEntrar.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		btnEntrar.setBounds(276, 485, 245, 45);
		panelLogin.add(btnEntrar);
		
		lblMessageError = new JLabel("Tente Novamente, usuário ou senha incorreto(s)!", SwingConstants.CENTER);
		lblMessageError.setForeground(new Color(Integer.parseInt("EA9999", 16)));
		lblMessageError.setFont(new Font("DejaVu Sans", Font.PLAIN, 14));
		lblMessageError.setBounds(206, 535, 384, 39);
		lblMessageError.setVisible(false);
		panelLogin.add(lblMessageError);

		panelLogin.add(lblImageLoading);
	}

	public JTextField getTxtUsuario() {
		return txtUsuario;
	}

	public JPasswordField getPwdSenha() {
		return pwdSenha;
	}

	public JButton getBtnEntrar() {
		return btnEntrar;
	}

	public JLabel getLblImageLoading() {
		return lblImageLoading;
	}

	public JLabel getLblMessageError() {
		return lblMessageError;
	}
}
	