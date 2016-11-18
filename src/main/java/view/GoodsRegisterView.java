package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import util.GraphicsUtil;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import controller.GoodsRegisterControl;
import controller.LoginControl;
import model.Category;
import model.Goods;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
/**
 * 
 * @author anjoshigor
 *
 */
@SuppressWarnings("serial")
public class GoodsRegisterView extends JFrame {
	
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
	private JLabel lblIconProduto;
	private JLabel lblTitleProduto;
	
	/**Form Content**/
	private JPanel panelForm;
	
	/**Name field**/
	private JLabel lblNome;
	private JTextField txtNome;
	private JPanel panelNome;
	
	/**Code field**/
	private JLabel lblCod;
	private JTextField txtCod;
	private JPanel panelCod;
	
	/**Category field**/
	//TODO mudar para Category Class, fazendo override do método toString na classe Category
	private JLabel lblCategoria;
	private JComboBox<String> comboCategoria;
	private JPanel panelCategoria;
	
	/**Value field**/
	private JLabel lblValor;
	private JTextField txtValor;
	private JPanel panelValor;
	
	/**Size field**/
	private JLabel lblTamanho;
	private JTextField txtTamanho;
	private JPanel panelTamanho;
	
	/**Description field**/
	private JLabel lblDescricao;
	private JTextArea txtDescricao;
	private JPanel panelDescricao;
	
	
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
	
	/* DIALOG CONFIRM */
	private JButton btnSim;
	private JButton btnNao;
	
	//controller
	private GoodsRegisterControl goodsRegisterControl;
	
	
	// constructor
	public GoodsRegisterView() {
		initGoodsView();
		goodsRegisterControl = new GoodsRegisterControl(this);
	}

	// constructor
	public GoodsRegisterView(Goods goods) {
		initGoodsView();
		goodsRegisterControl = new GoodsRegisterControl(this, goods);
	}
	
	// methods
	private void initGoodsView() {
		final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setUndecorated(true);
		setExtendedState(JFrame.MAXIMIZED_BOTH); 
		setSize(screenSize);
		setLocationRelativeTo(null);
		
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
		panelDialog.setBounds(186, 163, 416, 225);
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
		lblMessagedialog.setBounds(151, 46, 240, 97);
		panelDialog.add(lblMessagedialog);
		
		btnOK = new JButton("OK");
		btnOK.setBackground(Color.WHITE);
		btnOK.setForeground(Color.DARK_GRAY);
		btnOK.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		btnOK.setBounds(160, 158, 105, 34);
		panelDialog.add(btnOK);

		/** DIALOG MESSAGE CONFIRM **/

		btnNao = new JButton("NÃO");
		btnNao.setBackground(Color.WHITE);
		btnNao.setForeground(Color.DARK_GRAY);
		btnNao.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		btnNao.setBounds(254, 158, 105, 34);
		panelDialog.add(btnNao);
		btnNao.setVisible(false);

		btnSim = new JButton("SIM");
		btnSim.setBackground(Color.WHITE);
		btnSim.setForeground(Color.DARK_GRAY);
		btnSim.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		btnSim.setBounds(134, 158, 105, 34);
		panelDialog.add(btnSim);
		btnSim.setVisible(false);
		
		/**Category Icon**/
		lblIconProduto = new JLabel();
		lblIconProduto.setSize(155, 155);
		lblIconProduto.setLocation(0, 0);
		lblIconProduto.setIcon(GraphicsUtil.adjustImage("/drawable/ice-cream.png", lblIconProduto.getSize()));
		panelForm.add(lblIconProduto);
		
		/**Title text**/
		lblTitleProduto = new JLabel("Cadastro de Produtos");
		lblTitleProduto.setFont(new Font("DejaVu Sans", Font.PLAIN, 48));
		lblTitleProduto.setForeground(Color.WHITE);
		lblTitleProduto.setBounds(165, 60, 620, 60);
		lblTitleProduto.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblTitleProduto);
		
		/**Name field**/
		lblNome = new JLabel("nome *");
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
		txtNome.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		txtNome.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtNome.setBounds(143, 200, 620, 33);
		panelForm.add(txtNome);
		
		
		/**Code field**/
		lblCod = new JLabel("cod *");
		lblCod.setBounds(30, 238, 67, 33);
		lblCod.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblCod.setForeground(Color.WHITE);
		lblCod.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblCod);
		
		panelCod = new JPanel(null);
		panelCod.setBounds(30, 238, 67, 33);
		panelCod.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelForm.add(panelCod);
		
		txtCod = new JTextField();
		txtCod.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		txtCod.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtCod.setBounds(99, 238, 103, 33);
		panelForm.add(txtCod);
		
		/**Category Field**/
		lblCategoria = new JLabel("categoria *");
		lblCategoria.setBounds(206, 238, 140, 33);
		lblCategoria.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblCategoria.setForeground(Color.WHITE);
		lblCategoria.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblCategoria);
		
		panelCategoria = new JPanel(null);
		panelCategoria.setBounds(206, 238, 140, 33);
		panelCategoria.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelForm.add(panelCategoria);
		
		comboCategoria = new JComboBox<>();
		comboCategoria.setBounds(348, 238, 415, 33);
		comboCategoria.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		comboCategoria.setForeground(Color.DARK_GRAY);
		comboCategoria.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		panelForm.add(comboCategoria);
		
		/**Value Field**/
		lblValor = new JLabel("valor *");
		lblValor.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblValor.setForeground(Color.WHITE);
		lblValor.setBounds(30, 275, 112, 33);
		lblValor.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblValor);
		
		panelValor = new JPanel(null);
		panelValor.setBounds(30, 275, 112, 33);
		panelValor.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelForm.add(panelValor);
		
		txtValor = new JTextField("R$ 0,00");
		txtValor.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		txtValor.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtValor.setBounds(143, 275, 205, 33);
		txtValor.setForeground(Color.GRAY);
		panelForm.add(txtValor);
		
		
		/**Size Field**/
		lblTamanho = new JLabel("tamanho *");
		lblTamanho.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblTamanho.setForeground(Color.WHITE);
		lblTamanho.setBounds(352, 275, 125, 33);
		lblTamanho.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblTamanho);
		
		panelTamanho = new JPanel(null);
		panelTamanho.setBounds(352, 275, 125, 33);
		panelTamanho.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelForm.add(panelTamanho);
		
		txtTamanho = new JTextField();
		txtTamanho.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		txtTamanho.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtTamanho.setBounds(480, 275, 283, 33);
		panelForm.add(txtTamanho);
		
		
		/**Description field**/
		lblDescricao = new JLabel("descrição");
		lblDescricao.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblDescricao.setForeground(Color.WHITE);
		lblDescricao.setBounds(30, 312, 112, 66);
		lblDescricao.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblDescricao);
		
		panelDescricao = new JPanel(null);
		panelDescricao.setBounds(30, 312, 112, 66);
		panelDescricao.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelForm.add(panelDescricao);
		
		txtDescricao = new JTextArea();
		txtDescricao.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		txtDescricao.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtDescricao.setBounds(143, 312, 620, 66);
		txtDescricao.setLineWrap(true);
		panelForm.add(txtDescricao);
		
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
		lblImageLoading.setIcon(new ImageIcon(GoodsRegisterView.class.getResource("/drawable/ajax-loader.gif")));
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

	public JTextField getTxtCod() {
		return txtCod;
	}

	public JComboBox<String> getComboCategoria() {
		return comboCategoria;
	}

	public JTextField getTxtValor() {
		return txtValor;
	}

	public JTextField getTxtTamanho() {
		return txtTamanho;
	}

	public JLabel getLblMessageError() {
		return lblMessageError;
	}

	public void setLblMessageError(JLabel lblMessageError) {
		this.lblMessageError = lblMessageError;
	}

	public JTextField getTxtNome() {
		return txtNome;
	}

	public JTextArea getTxtDescricao() {
		return txtDescricao;
	}

	public JButton getBtnCadastrar() {
		return btnCadastrar;
	}

	public JButton getBtnLimpar() {
		return btnLimpar;
	}

	public JLabel getLblImageButtonVoltar() {
		return lblImageButtonVoltar;
	}

	public JLabel getLblTitleProduto() {
		return lblTitleProduto;
	}
	
	public JButton getBtnNao() {
		return btnNao;
	}

	public JButton getBtnSim() {
		return btnSim;
	}

	public JLabel getLblIconMessage() {
		return lblIconMessage;
	}

	public JLabel getLblMessagedialog() {
		return lblMessagedialog;
	}

}
	