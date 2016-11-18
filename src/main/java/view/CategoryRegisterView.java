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

import controller.CategoryRegisterControl;
import controller.LoginControl;
import model.Category;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
/**
 * 
 * @author anjoshigor
 *
 */
@SuppressWarnings("serial")
public class CategoryRegisterView extends JFrame {
	
	// attributes

	public JPanel getPanelDialog() {
		return panelDialog;
	}

	/**Outermost content**/
	private JPanel contentPane;
	
	/**Title of the form**/
	private JLabel lblCategoryIcon;
	private JLabel lblCategoryTitle;
	
	/**Form Content**/
	private JPanel panelForm;
	
	/**Name field**/
	private JLabel lblNome;
	private JTextField txtNome;
	private JPanel panelNome;
	
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
	
	private CategoryRegisterControl categoryRegisterControl;
	
	// constructor
	public CategoryRegisterView() {
		initCategoryRegisterView();
		categoryRegisterControl = new CategoryRegisterControl(this);
	}
	
	// constructor
	public CategoryRegisterView(Category category) {
		initCategoryRegisterView();
		categoryRegisterControl = new CategoryRegisterControl(this, category);
	}
	
	// methods
	private void initCategoryRegisterView() {
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
		lblCategoryIcon = new JLabel();
		lblCategoryIcon.setSize(155, 155);
		lblCategoryIcon.setLocation(0, 0);
		lblCategoryIcon.setIcon(GraphicsUtil.adjustImage("/drawable/category.png", lblCategoryIcon.getSize()));
		panelForm.add(lblCategoryIcon);
		
		/**Title text**/
		lblCategoryTitle = new JLabel("Cadastro de Categorias");
		lblCategoryTitle.setFont(new Font("DejaVu Sans", Font.PLAIN, 48));
		lblCategoryTitle.setForeground(Color.WHITE);
		lblCategoryTitle.setBounds(165, 60, 620, 60);
		lblCategoryTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblCategoryTitle);
		
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
		
		/**Description field**/
		lblDescricao = new JLabel("descrição");
		lblDescricao.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblDescricao.setForeground(Color.WHITE);
		lblDescricao.setBounds(30, 238, 112, 66);
		lblDescricao.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblDescricao);
		
		panelDescricao = new JPanel(null);
		panelDescricao.setBounds(30, 238, 112, 66);
		panelDescricao.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelForm.add(panelDescricao);
		
		txtDescricao = new JTextArea();
		txtDescricao.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		txtDescricao.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtDescricao.setBounds(143, 238, 620, 66);
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
		lblImageLoading.setIcon(new ImageIcon(CategoryRegisterView.class.getResource("/drawable/ajax-loader.gif")));
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

	public JButton getBtnOK() {
		return btnOK;
	}

	public JLabel getLblMessageError() {
		return lblMessageError;
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

	public JPanel getContentPane() {
		return contentPane;
	}
	
	public JLabel getLblTitleCategory() {
		return lblCategoryTitle;
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
	