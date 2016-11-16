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
import controller.SearchControl;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
/**
 * 
 * @author anjoshigor
 *
 */
@SuppressWarnings("serial")
public class SearchView extends JFrame {

	// attributes

	/**Outermost content**/
	private JPanel contentPane;
	
	/**Title of the form**/
	private JLabel lblConsultaIcon;
	private JLabel lblConsultaTitle;
	
	/**Form Content**/
	private JPanel panelForm;
	
	/**Filter field**/
	private JLabel lblFiltro;
	private JComboBox<String> comboFiltro;
	private JPanel panelFiltro;
	
	/**Field field**/
	private JLabel lblCampo;
	private JComboBox<String> comboCampo;
	private JPanel panelCampo;
	
	
	/**search field**/
	private JLabel lblButtonPesquisar;
	private JTextField txtPesquisar;
	
	/**Back Button**/
	private JLabel lblVoltar;
	private JLabel lblImageButtonVoltar;
	
	/**Message**/
	private JLabel lblImageLoading;
	private JLabel lblMessageError;
	
	private SearchControl searchControl;
	
	// constructor
	public SearchView() {
		initSearchView();
		searchControl = new SearchControl(this);
	}
	
	// methods
	private void initSearchView() {
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
		
		/**Search Icon**/
		lblConsultaIcon = new JLabel();
		lblConsultaIcon.setSize(155, 155);
		lblConsultaIcon.setLocation(322, 0);
		lblConsultaIcon.setIcon(GraphicsUtil.adjustImage("/drawable/search.png", lblConsultaIcon.getSize()));
		panelForm.add(lblConsultaIcon);
		
		/**Title text**/
		lblConsultaTitle = new JLabel("Consulta");
		lblConsultaTitle.setFont(new Font("DejaVu Sans", Font.PLAIN, 48));
		lblConsultaTitle.setForeground(Color.WHITE);
		lblConsultaTitle.setBounds(265, 158, 300, 60);
		lblConsultaTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblConsultaTitle);
		
		/**Filter field**/
		lblFiltro = new JLabel("filtro");
		lblFiltro.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblFiltro.setForeground(Color.WHITE);
		lblFiltro.setBounds(30, 238, 112, 33);
		lblFiltro.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblFiltro);
		
		panelFiltro = new JPanel(null);
		panelFiltro.setBounds(30, 238, 112, 33);
		panelFiltro.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelForm.add(panelFiltro);
		
		comboFiltro = new JComboBox<String>(new String[] {" ", "produto", "cliente", "funcionário", "categoria"});
		comboFiltro.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		comboFiltro.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		comboFiltro.setBounds(143, 238, 200, 33);
		panelForm.add(comboFiltro);
		
		/**Field field**/
		lblCampo = new JLabel("campo");
		lblCampo.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		lblCampo.setForeground(Color.WHITE);
		lblCampo.setBounds(348, 238, 112, 33);
		lblCampo.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblCampo);
		
		panelCampo = new JPanel(null);
		panelCampo.setBounds(348, 238, 112, 33);
		panelCampo.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelForm.add(panelCampo);
		
		comboCampo = new JComboBox<>();
		comboCampo.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		comboCampo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		comboCampo.setBounds(461, 238, 300, 33);
		panelForm.add(comboCampo);
		
		/**Searchbar**/
		txtPesquisar = new JTextField();
		txtPesquisar.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		txtPesquisar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtPesquisar.setBounds(30, 275, 655, 33);
		panelForm.add(txtPesquisar);
		
		lblButtonPesquisar = new JLabel();
		lblButtonPesquisar.setSize(75, 33);
		lblButtonPesquisar.setLocation(686, 275);
		lblButtonPesquisar.setIcon(GraphicsUtil.adjustImage("/drawable/botao-pesquisa.png", lblButtonPesquisar.getSize()));
		lblButtonPesquisar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelForm.add(lblButtonPesquisar);
		
		/**GIF**/
		lblImageLoading = new JLabel();
		lblImageLoading.setBounds(389, 485, 50, 50);
		lblImageLoading.setIcon(new ImageIcon(SearchView.class.getResource("/drawable/ajax-loader.gif")));
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

	public JLabel getLblMessageError() {
		return lblMessageError;
	}

	public JComboBox<String> getComboFiltro() {
		return comboFiltro;
	}

	public JComboBox<String> getComboCampo() {
		return comboCampo;
	}

	public JLabel getLblButtonPesquisar() {
		return lblButtonPesquisar;
	}

	public JLabel getLblImageButtonVoltar() {
		return lblImageButtonVoltar;
	}

	public JTextField getTxtPesquisar() {
		return txtPesquisar;
	}
}
	