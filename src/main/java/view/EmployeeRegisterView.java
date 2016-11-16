package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import util.GraphicsUtil;
import util.UFArray;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;


import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;

import controller.EmployeeRegisterControl;
/**
 * 
 * @author anjoshigor
 *
 */
@SuppressWarnings("serial")
public class EmployeeRegisterView extends JFrame {
	
	// attributes

	/**Outermost content**/
	private JPanel contentPane;
	
	/**Title of the form**/
	private JLabel lblIconEmployee;
	private JLabel lblTitleEmployee;
	
	/**Form Content**/
	private JPanel panelForm;
	
	/**Name field**/
	private JLabel lblNome;
	private JTextField txtNome;
	private JPanel panelNome;
	
	/**e-mail field**/
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JPanel panelEmail;
	
	/**phone field**/
	private JLabel lblTelefone;
	private JFormattedTextField txtTelefone;
	private JPanel panelTelefone;
	
	/**BirthDay field**/
	private JLabel lblDataNasc;
	private JFormattedTextField txtDataNasc;
	private JPanel panelDataNasc;
	
	
	/**agency field**/
	private JLabel lblAgencia;
	private JTextField txtAgencia;
	private JPanel panelAgencia;
	
	/**account field**/
	private JLabel lblConta;
	private JTextField txtConta;
	private JPanel panelConta;
	
	/**cpf field**/
	private JLabel lblCPF;
	private JFormattedTextField txtCPF;
	private JPanel panelCPF;
		
	/**Employee type field**/
	private JLabel lblTipoFunc;
	private JComboBox<String> comboTipoFunc;
	private JPanel panelTipoFunc;
	
	/**Street field**/
	private JLabel lblLogradouro;
	private JTextField txtLogradouro;
	private JPanel panelLogradouro;
	
	/**number field**/
	private JLabel lblNumero;
	private JTextField txtNumero;
	private JPanel panelNumero;
	
	/**district field**/
	private JLabel lblBairro;
	private JTextField txtBairro;
	private JPanel panelBairro;
	
	/**complement field**/
	private JLabel lblComplemento;
	private JTextField txtComplemento;
	private JPanel panelComplemento;
	
	/**Province/State field**/
	private JLabel lblUF;
	private JComboBox<String> comboUF;
	private JPanel panelUF;
	
	/**City field**/
	
	/*
	private JLabel lblCidade;
	private JComboBox<String> comboCidade;
	private JPanel panelCidade;
	*/
	private JLabel lblCidade;
	private JTextField txtCidade;
	private JPanel panelCidade;
	
	
	/**login field**/
	private JLabel lblLogin;
	private JTextField txtLogin;
	private JPanel panelLogin;
	
	/**Password field**/
	private JLabel lblSenha;
	private JPasswordField pwdSenha;
	private JPanel panelSenha;
	
	/**Buttons**/
	private JButton btnCadastrar;
	private JButton btnLimpar;
	
	/**Back Button**/
	private JLabel lblVoltar;
	private JLabel lblImageButtonVoltar;
	
	/**Message**/
	private JLabel lblImageLoading;
	private JLabel lblMessageError;

	// TODO controller
	private EmployeeRegisterControl employeeRegisterControl;
	
	// constructor
	public EmployeeRegisterView() {
		initEmployeeRegisterView();
		employeeRegisterControl = new EmployeeRegisterControl(this);
	}
	
	// methods
	private void initEmployeeRegisterView() {
		final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setSize(screenSize);
		setLocationRelativeTo(null);
		
		/**Formats**/
		DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		
		
		/**Setting outermost content**/
		contentPane = new JPanel(null);
		contentPane.setBackground(new Color(Integer.parseInt("9013FE", 16)));
		contentPane.setBorder(null);
		contentPane.setSize(screenSize);
		setContentPane(contentPane);
		
		/**Setting working area**/
		panelForm = new JPanel(null);
		panelForm.setSize(800, 600);
		panelForm.setLocation(GraphicsUtil.getLocaleCenter(panelForm.getSize(), screenSize));
		panelForm.setBackground(new Color(Integer.parseInt("9013FE", 16)));
		contentPane.add(panelForm);
		
		/**Employee Icon**/
		lblIconEmployee = new JLabel();
		lblIconEmployee.setSize(155, 155);
		lblIconEmployee.setLocation(0, 0);
		lblIconEmployee.setIcon(GraphicsUtil.adjustImage("/drawable/manager-avatar.png", lblIconEmployee.getSize()));
		panelForm.add(lblIconEmployee);
		
		/**Title text**/
		lblTitleEmployee = new JLabel("Cadastro de Funcionários");
		lblTitleEmployee.setFont(new Font("DejaVu Sans", Font.PLAIN, 48));
		lblTitleEmployee.setForeground(Color.WHITE);
		lblTitleEmployee.setBounds(165, 60, 620, 60);
		lblTitleEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblTitleEmployee);
		
		/**Name field**/
		lblNome = new JLabel("nome");
		lblNome.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(30, 167, 112, 33);
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblNome);
		
		panelNome = new JPanel(null);
		panelNome.setBounds(30, 167, 112, 33);
		panelNome.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelForm.add(panelNome);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		txtNome.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtNome.setBounds(143, 167, 620, 33);
		panelForm.add(txtNome);
		
		/**Email field**/
		lblEmail = new JLabel("e-mail");
		lblEmail.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(30, 205, 112, 33);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblEmail);
		
		panelEmail = new JPanel(null);
		panelEmail.setBounds(30, 205, 112, 33);
		panelEmail.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelForm.add(panelEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		txtEmail.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtEmail.setBounds(143, 205, 620, 33);
		panelForm.add(txtEmail);
		
		/**phone Field**/
		lblTelefone = new JLabel("telefone");
		lblTelefone.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setBounds(30, 242, 125, 33);
		lblTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblTelefone);
		
		panelTelefone = new JPanel(null);
		panelTelefone.setBounds(30, 242, 125, 33);
		panelTelefone.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelForm.add(panelTelefone);
		
		txtTelefone = new JFormattedTextField();
		txtTelefone.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		txtTelefone.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtTelefone.setBounds(156, 242, 210, 33);
		MaskFormatter phoneMask;
		try {
			phoneMask = new MaskFormatter("(##) ####-####");
			phoneMask.install(txtTelefone);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	
		
		panelForm.add(txtTelefone);
		
		
		/**Birthday Field**/
		
		lblDataNasc = new JLabel("data nasc");
		lblDataNasc.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblDataNasc.setForeground(Color.WHITE);
		lblDataNasc.setBounds(370, 242, 125, 33);
		lblDataNasc.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblDataNasc);
		
		panelDataNasc = new JPanel(null);
		panelDataNasc.setBounds(370, 242, 125, 33);
		panelDataNasc.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelForm.add(panelDataNasc);
		
		txtDataNasc = new JFormattedTextField(dateFormat);
		txtDataNasc.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		txtDataNasc.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtDataNasc.setBounds(496, 242, 268, 33);
		
		MaskFormatter dateMask;
		try {
			dateMask = new MaskFormatter("##/##/####");
			dateMask.install(txtDataNasc);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		panelForm.add(txtDataNasc);
		
		/**Agency Field**/
		lblAgencia = new JLabel("agência");
		lblAgencia.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblAgencia.setForeground(Color.WHITE);
		lblAgencia.setBounds(30, 279, 125, 33);
		lblAgencia.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblAgencia);
		
		panelAgencia = new JPanel(null);
		panelAgencia.setBounds(30, 279, 125, 33);
		panelAgencia.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelForm.add(panelAgencia);
		
		txtAgencia = new JTextField();
		txtAgencia.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		txtAgencia.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtAgencia.setBounds(156, 279, 210, 33);

		panelForm.add(txtAgencia);
		
		/**Account Field**/
		lblConta = new JLabel("conta");
		lblConta.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblConta.setForeground(Color.WHITE);
		lblConta.setBounds(370, 279, 125, 33);
		lblConta.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblConta);
		
		panelConta = new JPanel(null);
		panelConta.setBounds(370, 279, 125, 33);
		panelConta.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelForm.add(panelConta);
		
		txtConta = new JTextField();
		txtConta.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		txtConta.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtConta.setBounds(496, 279, 268, 33);

		panelForm.add(txtConta);
		
		/**CPF Field**/
		lblCPF = new JLabel("CPF");
		lblCPF.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblCPF.setForeground(Color.WHITE);
		lblCPF.setBounds(30, 316, 100, 33);
		lblCPF.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblCPF);
		
		panelCPF = new JPanel(null);
		panelCPF.setBounds(30, 316, 100, 33);
		panelCPF.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelForm.add(panelCPF);
		
		txtCPF = new JFormattedTextField();
		txtCPF.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		txtCPF.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtCPF.setBounds(131, 316, 200, 33);
		MaskFormatter cpfMask;
		try {
			cpfMask = new MaskFormatter("###.###.###-##");
			cpfMask.install(txtCPF);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		panelForm.add(txtCPF);
		
		/**Employee Type Field**/
		lblTipoFunc = new JLabel("tipo func");
		lblTipoFunc.setBounds(335, 316, 140, 33);
		lblTipoFunc.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblTipoFunc.setForeground(Color.WHITE);
		lblTipoFunc.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblTipoFunc);
		
		panelTipoFunc = new JPanel(null);
		panelTipoFunc.setBounds(335, 316, 140, 33);
		panelTipoFunc.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelForm.add(panelTipoFunc);
		
		comboTipoFunc = new JComboBox<>();
		comboTipoFunc.setBounds(476, 316, 288, 33);
		comboTipoFunc.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		comboTipoFunc.setForeground(Color.DARK_GRAY);
		comboTipoFunc.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		comboTipoFunc.addItem("Gerente");
		comboTipoFunc.addItem("Caixa");
		panelForm.add(comboTipoFunc);
		
		/**Street Field**/
		lblLogradouro = new JLabel("logradouro");
		lblLogradouro.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblLogradouro.setForeground(Color.WHITE);
		lblLogradouro.setBounds(30, 353, 125, 33);
		lblLogradouro.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblLogradouro);
		
		panelLogradouro = new JPanel(null);
		panelLogradouro.setBounds(30, 353, 125, 33);
		panelLogradouro.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelForm.add(panelLogradouro);
		
		txtLogradouro = new JTextField();
		txtLogradouro.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		txtLogradouro.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtLogradouro.setBounds(156, 353, 450, 33);

		panelForm.add(txtLogradouro);
		
		/**Number Field**/
		lblNumero = new JLabel("nº");
		lblNumero.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblNumero.setForeground(Color.WHITE);
		lblNumero.setBounds(610, 353, 40, 33);
		lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblNumero);
		
		panelNumero = new JPanel(null);
		panelNumero.setBounds(610, 353, 40, 33);
		panelNumero.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelForm.add(panelNumero);
		
		txtNumero = new JTextField();
		txtNumero.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		txtNumero.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtNumero.setBounds(651, 353, 112, 33);

		panelForm.add(txtNumero);

		
		/**District Field**/
		lblBairro = new JLabel("bairro");
		lblBairro.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblBairro.setForeground(Color.WHITE);
		lblBairro.setBounds(30, 390, 85, 33);
		lblBairro.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblBairro);
		
		panelBairro = new JPanel(null);
		panelBairro.setBounds(30, 390, 85, 33);
		panelBairro.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelForm.add(panelBairro);
		
		txtBairro = new JTextField();
		txtBairro.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		txtBairro.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtBairro.setBounds(116, 390, 210, 33);

		panelForm.add(txtBairro);
		
		/**Complement Field**/
		lblComplemento = new JLabel("complemento");
		lblComplemento.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblComplemento.setForeground(Color.WHITE);
		lblComplemento.setBounds(330, 390, 165, 33);
		lblComplemento.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblComplemento);
		
		panelComplemento = new JPanel(null);
		panelComplemento.setBounds(330, 390, 165, 33);
		panelComplemento.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelForm.add(panelComplemento);
		
		txtComplemento = new JTextField();
		txtComplemento.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		txtComplemento.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtComplemento.setBounds(496, 390, 268, 33);

		panelForm.add(txtComplemento);
		
		/**state Field**/
		lblUF = new JLabel("UF");
		lblUF.setBounds(30, 427, 50, 33);
		lblUF.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblUF.setForeground(Color.WHITE);
		lblUF.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblUF);
		
		panelUF = new JPanel(null);
		panelUF.setBounds(30, 427, 50, 33);
		panelUF.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelForm.add(panelUF);
		
		//this may cause error on windowbuilder design tab but it's a valid constructor
		comboUF = new JComboBox<String>(UFArray.getListOfUfs());
		comboUF.setBounds(81, 427, 100, 33);
		comboUF.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		comboUF.setForeground(Color.DARK_GRAY);
		comboUF.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelForm.add(comboUF);
		
		/**City Field**/
		lblCidade = new JLabel("cidade");
		lblCidade.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblCidade.setForeground(Color.WHITE);
		lblCidade.setBounds(185, 427, 100, 33);
		lblCidade.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblCidade);
		
		panelCidade = new JPanel(null);
		panelCidade.setBounds(185, 427, 100, 33);
		panelCidade.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelForm.add(panelCidade);
		
		txtCidade = new JTextField();
		txtCidade.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		txtCidade.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtCidade.setBounds(286, 427, 478, 33);

		panelForm.add(txtCidade);


		/** Login Field**/
		lblLogin = new JLabel("login");
		lblLogin.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(30, 464, 125, 33);
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblLogin);
		
		panelLogin = new JPanel(null);
		panelLogin.setBounds(30, 464, 125, 33);
		panelLogin.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelForm.add(panelLogin);
		
		txtLogin = new JTextField();
		txtLogin.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		txtLogin.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtLogin.setBounds(156, 464, 210, 33);

		panelForm.add(txtLogin);
		
		/**Password Field**/
		lblSenha = new JLabel("senha");
		lblSenha.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setBounds(370, 464, 125, 33);
		lblSenha.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblSenha);
		
		panelSenha = new JPanel(null);
		panelSenha.setBounds(370, 464, 125, 33);
		panelSenha.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelForm.add(panelSenha);
		
		pwdSenha = new JPasswordField();
		pwdSenha.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		pwdSenha.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		pwdSenha.setBounds(496, 464, 268, 33);

		panelForm.add(pwdSenha);

		
		/**Buttons**/
		btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setBorder(null);
		btnCadastrar.setBackground(new Color(Integer.parseInt("4A90E2", 16)));
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		btnCadastrar.setBounds(150, 520, 245, 45);
		btnCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelForm.add(btnCadastrar);
		
		btnLimpar = new JButton("LIMPAR");
		btnLimpar.setBorder(null);
		btnLimpar.setBackground(new Color(Integer.parseInt("FF4FA4", 16)));
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		btnLimpar.setBounds(400, 520, 245, 45);
		btnLimpar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelForm.add(btnLimpar);
		
		/**GIF**/
		lblImageLoading = new JLabel();
		lblImageLoading.setBounds(389, 520, 50, 50);
		lblImageLoading.setIcon(new ImageIcon(EmployeeRegisterView.class.getResource("/drawable/ajax-loader.gif")));
		lblImageLoading.setVisible(false);
		panelForm.add(lblImageLoading);
		
		/**Error Message**/
		lblMessageError = new JLabel("Todos os campos devem estar preenchidos!", SwingConstants.CENTER);
		lblMessageError.setForeground(new Color(Integer.parseInt("EA9999", 16)));
		lblMessageError.setFont(new Font("DejaVu Sans", Font.PLAIN, 14));
		lblMessageError.setBounds(206, 560, 384, 39);
		lblMessageError.setVisible(false);
		panelForm.add(lblMessageError);

		/**Back Button**/
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
	}

	public JFormattedTextField getTxtDataNasc() {
		return txtDataNasc;
	}

	public JTextField getTxtAgencia() {
		return txtAgencia;
	}

	public JTextField getTxtConta() {
		return txtConta;
	}

	public JFormattedTextField getTxtCPF() {
		return txtCPF;
	}

	public JComboBox<String> getComboTipoFunc() {
		return comboTipoFunc;
	}

	public JTextField getTxtNumero() {
		return txtNumero;
	}

	public JTextField getTxtBairro() {
		return txtBairro;
	}

	public JTextField getTxtComplemento() {
		return txtComplemento;
	}

	public JComboBox<String> getComboUF() {
		return comboUF;
	}

	public JTextField getTxtCidade() {
		return txtCidade;
	}

	public JTextField getTxtLogin() {
		return txtLogin;
	}

	public JPasswordField getPwdSenha() {
		return pwdSenha;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public JButton getBtnLimpar() {
		return btnLimpar;
	}

	public JTextField gettxtLogradouro() {
		return txtLogradouro;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public JFormattedTextField getTxtTelefone() {
		return txtTelefone;
	}

	public JTextField getTxtSaldo() {
		return txtAgencia;
	}

	public JTextField getTxtValorEmCompras() {
		return txtConta;
	}

	public JTextField getTxtLogradouro() {
		return txtLogradouro;
	}

	public JLabel getLblMessageError() {
		return lblMessageError;
	}


	public JTextField getTxtNome() {
		return txtNome;
	}

	public JLabel getLblImageButtonVoltar() {
		return lblImageButtonVoltar;
	}


}
	