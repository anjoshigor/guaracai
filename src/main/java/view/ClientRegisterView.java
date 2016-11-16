package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;
import javax.swing.JFrame;
import javax.swing.JPanel;
import util.GraphicsUtil;
import java.awt.Color;
import java.awt.Cursor;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import controller.ClientRegisterControl;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
/**
 * 
 * @author anjoshigor
 *
 */
@SuppressWarnings("serial")
public class ClientRegisterView extends JFrame {
	
	// attributes

	public JButton getBtnOK() {
		return btnOK;
	}

	public JPanel getPanelDialog() {
		return panelDialog;
	}

	/**Outermost content**/
	private JPanel contentPane;
	
	/**Title of the form**/
	private JLabel lblIconClient;
	private JLabel lblTitleClient;
	
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
	
	/**balance field**/
	private JLabel lblSaldo;
	private JFormattedTextField txtSaldo;
	private JPanel panelSaldo;
	
	/**amount spent field**/
	private JLabel lblValorEmCompras;
	private JFormattedTextField txtValorEmCompras;
	private JPanel panelValorEmCompras;
	
	
	/**Birthday field**/
	private JLabel lblDataNasc;
	private JFormattedTextField txtDataNasc;
	private JPanel panelDataNasc;
	
	
	/**Buttons**/
	private JButton btnCadastrar;
	private JButton btnLimpar;
	
	/**Back Button**/
	private JLabel lblVoltar;
	private JLabel lblImageButtonVoltar;
	
	/**Message**/
	private JLabel lblImageLoading;
	private JLabel lblMessageError;
	
	/** DIALOG **/
	private JLabel lblIconMessage;
	private JLabel lblMessagedialog;
	private JButton btnOK;
	private JPanel panelDialog;

	private ClientRegisterControl clientRegisterControl;
	
	// constructor
	public ClientRegisterView() {
		initClientRegisterView();
		clientRegisterControl = new ClientRegisterControl(this);
	}
	
	// methods
	private void initClientRegisterView() {
		final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setSize(screenSize);
		setLocationRelativeTo(null);
		
		/**Formats**/
	//	DateFormat dateFormat = new SimpleDateFormat("dd/mm/yyyy");
		/*
		NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
		format.setMaximumFractionDigits(2);

		NumberFormatter formatter = new NumberFormatter(format);
		formatter.setMinimum(-100000000.0);
		formatter.setMaximum(10000000.0);
		formatter.setAllowsInvalid(false);
		formatter.setOverwriteMode(true);
		*/
		
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
		
		/** DIALOG MESSAGE **/
		panelDialog = new JPanel();
		panelDialog.setBackground(new Color(Integer.parseInt("827C7B", 16)));
		panelDialog.setBorder(new LineBorder(Color.WHITE, 2));
		panelDialog.setBounds(300, 190, 416, 225);
		panelDialog.setLayout(null);
		panelDialog.setVisible(false);
		panelForm.add(panelDialog);
		
		lblIconMessage = new JLabel("");
		lblIconMessage.setBounds(25, 46, 100, 100);
		lblIconMessage.setIcon(GraphicsUtil.adjustImage("/drawable/like.png", lblIconMessage.getSize()));
		panelDialog.add(lblIconMessage);
		
		lblMessagedialog = new JLabel("<html>Cadastro realizado<br>com sucesso!<html>");
		lblMessagedialog.setForeground(Color.WHITE);
		lblMessagedialog.setFont(new Font("DejaVu Sans", Font.PLAIN, 26));
		lblMessagedialog.setBounds(151, 46, 208, 97);
		panelDialog.add(lblMessagedialog);
		
		btnOK = new JButton("OK");
		btnOK.setBackground(Color.WHITE);
		btnOK.setForeground(Color.DARK_GRAY);
		btnOK.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		btnOK.setBounds(160, 158, 105, 34);
		panelDialog.add(btnOK);
		
		/**Client Icon**/
		lblIconClient = new JLabel();
		lblIconClient.setSize(155, 155);
		lblIconClient.setLocation(0, 0);
		lblIconClient.setIcon(GraphicsUtil.adjustImage("/drawable/users.png", lblIconClient.getSize()));
		panelForm.add(lblIconClient);
		
		/**Title text**/
		lblTitleClient = new JLabel("Cadastro de Clientes");
		lblTitleClient.setFont(new Font("DejaVu Sans", Font.PLAIN, 56));
		lblTitleClient.setForeground(Color.WHITE);
		lblTitleClient.setBounds(165, 60, 620, 60);
		lblTitleClient.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblTitleClient);
		
		/**Name field**/
		lblNome = new JLabel("nome");
		lblNome.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(30, 200, 112, 33);
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblNome);
		
		panelNome = new JPanel(null);
		panelNome.setBounds(30, 200, 112, 33);
		panelNome.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelForm.add(panelNome);
		
		txtNome = new JTextField();
		txtNome.setForeground(new Color(51, 51, 51));
		txtNome.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		txtNome.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtNome.setBounds(143, 200, 620, 33);
		panelForm.add(txtNome);
		
		/**Email field**/
		lblEmail = new JLabel("e-mail");
		lblEmail.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(30, 238, 112, 33);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblEmail);
		
		panelEmail = new JPanel(null);
		panelEmail.setBounds(30, 238, 112, 33);
		panelEmail.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelForm.add(panelEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		txtEmail.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtEmail.setBounds(143, 238, 620, 33);
		panelForm.add(txtEmail);
		
		/**phone Field**/
		lblTelefone = new JLabel("telefone");
		lblTelefone.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblTelefone.setForeground(Color.WHITE);
		lblTelefone.setBounds(30, 275, 125, 33);
		lblTelefone.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblTelefone);
		
		panelTelefone = new JPanel(null);
		panelTelefone.setBounds(30, 275, 125, 33);
		panelTelefone.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelForm.add(panelTelefone);
		
		txtTelefone = new JFormattedTextField();
		txtTelefone.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		txtTelefone.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtTelefone.setBounds(156, 275, 210, 33);
		MaskFormatter phoneMask;
		try {
			phoneMask = new MaskFormatter("(##) #####-####");
			phoneMask.install(txtTelefone);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
	
		
		panelForm.add(txtTelefone);
		
		
		/**Birthday Field**/
		
		lblDataNasc = new JLabel("data nasc");
		lblDataNasc.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblDataNasc.setForeground(Color.WHITE);
		lblDataNasc.setBounds(370, 275, 125, 33);
		lblDataNasc.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblDataNasc);
		
		panelDataNasc = new JPanel(null);
		panelDataNasc.setBounds(370, 275, 125, 33);
		panelDataNasc.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelForm.add(panelDataNasc);
		
		txtDataNasc = new JFormattedTextField();
		txtDataNasc.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		txtDataNasc.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtDataNasc.setBounds(496, 275, 268, 33);
		
		MaskFormatter dateMask;
		try {
			dateMask = new MaskFormatter("##/##/####");
			dateMask.install(txtDataNasc);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		panelForm.add(txtDataNasc);
		
		/**Balance Field**/
		
		
		lblSaldo = new JLabel("saldo");
		lblSaldo.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblSaldo.setForeground(Color.WHITE);
		lblSaldo.setBounds(30, 312, 125, 33);
		lblSaldo.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblSaldo);
		
		panelSaldo = new JPanel(null);
		panelSaldo.setBounds(30, 312, 125, 33);
		panelSaldo.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelForm.add(panelSaldo);
		
		
		txtSaldo = new JFormattedTextField();
		txtSaldo.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		txtSaldo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtSaldo.setBounds(156, 312, 190, 33);
		txtSaldo.setValue("R$ 0,00");
		txtSaldo.setForeground(Color.GRAY);
		panelForm.add(txtSaldo);
	
		
		/**Amount Spent Field**/
		lblValorEmCompras = new JLabel("valor em compras");
		lblValorEmCompras.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblValorEmCompras.setForeground(Color.WHITE);
		lblValorEmCompras.setBounds(350, 312, 200, 33);
		lblValorEmCompras.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblValorEmCompras);
		
		panelValorEmCompras = new JPanel(null);
		panelValorEmCompras.setBounds(350, 312, 200, 33);
		panelValorEmCompras.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelForm.add(panelValorEmCompras);
		

		txtValorEmCompras = new JFormattedTextField();
		txtValorEmCompras.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		txtValorEmCompras.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtValorEmCompras.setBounds(551, 312, 213, 33);
		txtValorEmCompras.setValue("R$ 0,00");
		txtValorEmCompras.setForeground(Color.GRAY);	
		panelForm.add(txtValorEmCompras);
		
		
		/**Buttons**/
		btnCadastrar = new JButton("CADASTRAR");
		btnCadastrar.setBorder(null);
		btnCadastrar.setBackground(new Color(Integer.parseInt("4A90E2", 16)));
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		btnCadastrar.setBounds(150, 400, 245, 45);
		btnCadastrar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelForm.add(btnCadastrar);
		
		btnLimpar = new JButton("LIMPAR");
		btnLimpar.setBorder(null);
		btnLimpar.setBackground(new Color(Integer.parseInt("FF4FA4", 16)));
		btnLimpar.setForeground(Color.WHITE);
		btnLimpar.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		btnLimpar.setBounds(400, 400, 245, 45);
		btnLimpar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelForm.add(btnLimpar);
		
		/**GIF**/
		lblImageLoading = new JLabel();
		lblImageLoading.setBounds(389, 485, 50, 50);
		lblImageLoading.setIcon(new ImageIcon(ClientRegisterView.class.getResource("/drawable/ajax-loader.gif")));
		lblImageLoading.setVisible(false);
		panelForm.add(lblImageLoading);
		
		/**Error Message**/
		lblMessageError = new JLabel("Todos os campos devem estar preenchidos!", SwingConstants.CENTER);
		lblMessageError.setForeground(new Color(Integer.parseInt("EA9999", 16)));
		lblMessageError.setFont(new Font("DejaVu Sans", Font.PLAIN, 14));
		lblMessageError.setBounds(206, 535, 384, 39);
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

	public JLabel getLblImageButtonVoltar() {
		return lblImageButtonVoltar;
	}

	public JTextField getTxtEmail() {
		return txtEmail;
	}

	public JFormattedTextField getTxtTelefone() {
		return txtTelefone;
	}

	public JFormattedTextField getTxtSaldo() {
		return txtSaldo;
	}

	public JFormattedTextField getTxtValorEmCompras() {
		return txtValorEmCompras;
	}

	public JFormattedTextField getTxtDataNasc() {
		return txtDataNasc;
	}

	public JLabel getLblMessageError() {
		return lblMessageError;
	}


	public JTextField getTxtNome() {
		return txtNome;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public JButton getBtnLimpar() {
		return btnLimpar;
	}

}
	