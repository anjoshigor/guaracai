package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import util.GraphicsUtil;
import util.MostSoldProduct;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import controller.SaleControl;

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
public class SaleView extends JFrame {
	
	// attributes

	/**Outermost content**/
	private JPanel contentPane;
	
	/**usable Content**/
	private JPanel panelForm;
	
	/**Code field**/
	private JLabel lblCod;
	private JTextField txtCod;
	
	/**name field**/
	private JLabel lblNomeDoProduto;
	private JTextField txtNomeDoProduto;
	
	/**size field**/
	private JLabel lblTamanho;
	private JComboBox<String> comboTamanho;
	
	/**qtd field**/
	private JLabel lblQtd;
	private JTextField txtQtd;
	
	/**Add button**/
	private JButton btnAdicionar;
	
	/** most sold products **/
	private JLabel lblProdutosMaisVendidos;
	
	/** first product **/
	private MostSoldProduct primeiroProduto;
	
	/** second product **/
	private MostSoldProduct segundoProduto;

	/** third product **/
	private MostSoldProduct terceiroProduto;
	
	/** fourth product **/
	private MostSoldProduct quartoProduto;
	
	/** fifth product **/
	private MostSoldProduct quintoProduto;
	
	/** Employee **/
	private JLabel lblEmployee;
	private JTextField txtEmployee;
	
	/** Employee **/
	private JLabel lblClient;
	private JTextField txtClient;

	/** Search **/
	private JLabel lblPesquisa;
	private JLabel lblImageButtonPesquisa;
	
	/** Lista de Itens **/
	private JLabel lblListaItens;
	
	/** Table **/
	private JScrollPane scrollTable;
	private JTable pedidoTable;
	
	/** Subtotal **/
	private JLabel lblSubtotal;
	private JTextField txtSubtotal;
	
	/** Discount **/
	private JLabel lblDesconto;
	private JTextField txtDesconto;
	
	/** Observation**/
	private JLabel lblMotivo;
	private JTextArea txtAreaMotivo;
	
	/** Total **/
	private JLabel lblTotal;
	private JTextField txtTotal;
	
	/** Button Pay **/
	private JButton btnFinalizar;
	
	/** Button Cancel **/
	private JButton btnCancelar;
	
	/** Delete item **/
	private JLabel lblDeletar;
	private JPanel panDeletar;
	private JTextField txtDeletar;
	
	
	private SaleControl saleControl;
	
	/**
	 * Construtor da classe SaleView(). 
	 * 
	 * @param none
	 * @return SaleView
	 */
	public SaleView() {
		initSaleView();
		saleControl = new SaleControl(this);
	}
	
	private void initSaleView() {
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
		
		/**Code field**/
		lblCod = new JLabel("cod");
		lblCod.setFont(new Font("DejaVu Sans", Font.PLAIN, 24));
		lblCod.setForeground(Color.WHITE);
		lblCod.setBounds(25, 0, 60, 33);
		lblCod.setHorizontalAlignment(SwingConstants.LEFT);
		panelForm.add(lblCod);
		
		txtCod = new JTextField();
		txtCod.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		txtCod.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtCod.setBounds(25, 35, 60, 35);
		panelForm.add(txtCod);
		
		/**name field**/
		lblNomeDoProduto = new JLabel("nome do produto");
		lblNomeDoProduto.setFont(new Font("DejaVu Sans", Font.PLAIN, 24));
		lblNomeDoProduto.setForeground(Color.WHITE);
		lblNomeDoProduto.setBounds(90, 0, 250, 33);
		lblNomeDoProduto.setHorizontalAlignment(SwingConstants.LEFT);
		panelForm.add(lblNomeDoProduto);
		
		txtNomeDoProduto = new JTextField();
		txtNomeDoProduto.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		txtNomeDoProduto.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtNomeDoProduto.setBounds(90, 35, 350, 35);
		txtNomeDoProduto.setEditable(false);
		panelForm.add(txtNomeDoProduto);
		
		
		/**size field**/
		lblTamanho = new JLabel("tamanho");
		lblTamanho.setFont(new Font("DejaVu Sans", Font.PLAIN, 24));
		lblTamanho.setForeground(Color.WHITE);
		lblTamanho.setBounds(445, 0, 120, 33);
		lblTamanho.setHorizontalAlignment(SwingConstants.LEFT);
		panelForm.add(lblTamanho);
		
		/**qtd field**/
		lblQtd = new JLabel("qtd");
		lblQtd.setFont(new Font("DejaVu Sans", Font.PLAIN, 24));
		lblQtd.setForeground(Color.WHITE);
		lblQtd.setBounds(570, 0, 60, 33);
		lblQtd.setHorizontalAlignment(SwingConstants.LEFT);
		panelForm.add(lblQtd);
		
		txtQtd = new JTextField();
		txtQtd.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		txtQtd.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtQtd.setBounds(570, 35, 60, 35);
		panelForm.add(txtQtd);

		/**add button**/
		btnAdicionar = new JButton("ADICIONAR");
		btnAdicionar.setBorder(null);
		btnAdicionar.setBackground(new Color(Integer.parseInt("4A90E2", 16)));
		btnAdicionar.setForeground(Color.WHITE);
		btnAdicionar.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
		btnAdicionar.setBounds(635, 35, 140, 35);
		btnAdicionar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelForm.add(btnAdicionar);
		
		/**most sold product title**/
		lblProdutosMaisVendidos = new JLabel("produtos mais vendidos");
		lblProdutosMaisVendidos.setFont(new Font("DejaVu Sans", Font.PLAIN, 16));
		lblProdutosMaisVendidos.setForeground(Color.WHITE);
		lblProdutosMaisVendidos.setBounds(25, 80, 250, 25);
		lblProdutosMaisVendidos.setHorizontalAlignment(SwingConstants.LEFT);
		panelForm.add(lblProdutosMaisVendidos);
		

		/**Product1**/
		primeiroProduto = new MostSoldProduct("Suco de Manga", "500ml", "R$8,00", "F1", 25, 110);
		panelForm.add(primeiroProduto.getNome());
		panelForm.add(primeiroProduto.getTamanho());
		panelForm.add(primeiroProduto.getPreco());
		panelForm.add(primeiroProduto.getProductBackground());
		panelForm.add(primeiroProduto.getAtalho());
		panelForm.add(primeiroProduto.getHotkeyBackground());
		
		/**Product2**/
		segundoProduto = new MostSoldProduct("Suco de Cupuaçu", "300ml", "R$7,00", "F2", 25, 170);
		panelForm.add(segundoProduto.getNome());
		panelForm.add(segundoProduto.getTamanho());
		panelForm.add(segundoProduto.getPreco());
		panelForm.add(segundoProduto.getProductBackground());
		panelForm.add(segundoProduto.getAtalho());
		panelForm.add(segundoProduto.getHotkeyBackground());
		
		/**Product3**/
		terceiroProduto = new MostSoldProduct("Tigela de Açaí", "Grande", "R$12,00", "F3", 25, 230);
		panelForm.add(terceiroProduto.getNome());
		panelForm.add(terceiroProduto.getTamanho());
		panelForm.add(terceiroProduto.getPreco());
		panelForm.add(terceiroProduto.getProductBackground());
		panelForm.add(terceiroProduto.getAtalho());
		panelForm.add(terceiroProduto.getHotkeyBackground());
		
		/**Product4**/
		quartoProduto = new MostSoldProduct("Guaratudodoim", "300ml", "R$10,00", "F4", 25, 290);
		panelForm.add(quartoProduto.getNome());
		panelForm.add(quartoProduto.getTamanho());
		panelForm.add(quartoProduto.getPreco());
		panelForm.add(quartoProduto.getProductBackground());
		panelForm.add(quartoProduto.getAtalho());
		panelForm.add(quartoProduto.getHotkeyBackground());
		
		/**Product5**/
		quintoProduto = new MostSoldProduct("Casquinha de Açaí", "Único", "R$3,00", "F5", 25, 350);
		panelForm.add(quintoProduto.getNome());
		panelForm.add(quintoProduto.getTamanho());
		panelForm.add(quintoProduto.getPreco());
		panelForm.add(quintoProduto.getProductBackground());
		panelForm.add(quintoProduto.getAtalho());
		panelForm.add(quintoProduto.getHotkeyBackground());
		
		/**Employee**/
		lblEmployee = new JLabel("atendente");
		lblEmployee.setFont(new Font("DejaVu Sans", Font.PLAIN, 16));
		lblEmployee.setForeground(Color.WHITE);
		lblEmployee.setBounds(25, 405, 200, 25);
		lblEmployee.setHorizontalAlignment(SwingConstants.LEFT);
		panelForm.add(lblEmployee);
		
		txtEmployee = new JTextField("Nome do atendente");
		txtEmployee.setFont(new Font("DejaVu Sans", Font.PLAIN, 16));
		txtEmployee.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtEmployee.setBounds(25, 430, 200, 33);
		txtEmployee.setEditable(false);
		panelForm.add(txtEmployee);
		
		/**Client**/
		lblClient = new JLabel("cliente");
		lblClient.setFont(new Font("DejaVu Sans", Font.PLAIN, 16));
		lblClient.setForeground(Color.WHITE);
		lblClient.setBounds(25, 465, 200, 25);
		lblClient.setHorizontalAlignment(SwingConstants.LEFT);
		panelForm.add(lblClient);
		
		txtClient = new JTextField("Nome do cliente");
		txtClient.setFont(new Font("DejaVu Sans", Font.PLAIN, 16));
		txtClient.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtClient.setBounds(25, 490, 200, 33);
		txtClient.setEditable(false);
		panelForm.add(txtClient);
		
		/**Search**/
		lblPesquisa = new JLabel("CONSULTAR (F6)");
		lblPesquisa.setFont(new Font("DejaVu Sans", Font.PLAIN, 16));
		lblPesquisa.setForeground(Color.WHITE);
		lblPesquisa.setBounds(25, 540, 170, 45);
		lblPesquisa.setHorizontalAlignment(SwingConstants.CENTER);
		lblPesquisa.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelForm.add(lblPesquisa);
		
		lblImageButtonPesquisa =  new JLabel();
		lblImageButtonPesquisa.setSize(200,45);
		lblImageButtonPesquisa.setLocation(25,540);
		lblImageButtonPesquisa.setIcon(GraphicsUtil.adjustImage("/drawable/botao-consultar.png", lblImageButtonPesquisa.getSize()));
		lblImageButtonPesquisa.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelForm.add(lblImageButtonPesquisa);
		
		/** table title **/
		lblListaItens = new JLabel("Lista de Itens");
		lblListaItens.setFont(new Font("DejaVu Sans", Font.PLAIN, 16));
		lblListaItens.setForeground(Color.WHITE);
		lblListaItens.setBounds(290, 80, 250, 25);
		lblListaItens.setHorizontalAlignment(SwingConstants.LEFT);
		panelForm.add(lblListaItens);
		
		/** TABLE **/
		Vector<String> rows = new Vector<>();
		rows.add("item");
		rows.add("cod");
		rows.add("produto");
		rows.add("tamanho");
		rows.add("valor");
		rows.add("qtd");
		rows.add("subtotal");
		
		Vector<Vector<String>> fakeData = new Vector<>();
		fakeData.add(
				new Vector<String>(Arrays.asList(new String[] {"1","62","Suco Detox","500ml","5,00","2","10,00"}))
				);
		fakeData.add(
				new Vector<String>(Arrays.asList(new String[] {"2","31","Suco de Manga","300ml","6,00","1","6,00"}))
				);
		
		pedidoTable = new JTable(fakeData,rows);
		JTableHeader tableHeader = pedidoTable.getTableHeader();
		TableColumn colunaItem = pedidoTable.getColumnModel().getColumn(0);
		TableColumn colunaCod = pedidoTable.getColumnModel().getColumn(1);
		TableColumn colunaTamanho = pedidoTable.getColumnModel().getColumn(3);
		TableColumn colunaValor = pedidoTable.getColumnModel().getColumn(4);
		TableColumn colunaQtd = pedidoTable.getColumnModel().getColumn(5);
		TableColumn colunaSubtotal = pedidoTable.getColumnModel().getColumn(6);
		colunaItem.setMaxWidth(40);
		colunaItem.setPreferredWidth(40);
		colunaQtd.setMaxWidth(40);
		colunaQtd.setPreferredWidth(40);
		colunaCod.setMaxWidth(40);
		colunaCod.setPreferredWidth(40);
		colunaValor.setPreferredWidth(60);
		colunaValor.setMaxWidth(60);
		colunaTamanho.setPreferredWidth(65);
		colunaTamanho.setMaxWidth(65);
		colunaSubtotal.setPreferredWidth(80);
		colunaSubtotal.setMaxWidth(80);
		
		DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
		centralizado.setHorizontalAlignment(SwingConstants.CENTER);
	
		colunaCod.setCellRenderer(centralizado);
		colunaItem.setCellRenderer(centralizado);
		colunaQtd.setCellRenderer(centralizado);
		tableHeader.setBackground(new Color(Integer.parseInt("4A90E2", 16)));
		tableHeader.setForeground(Color.WHITE);
		tableHeader.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		
		pedidoTable.setFont(new Font("DejaVu Sans", Font.PLAIN, 12));
		pedidoTable.setForeground(Color.DARK_GRAY);
		pedidoTable.setRowHeight(25);
		pedidoTable.setRowHeight(1, 25);
		
		scrollTable = new JScrollPane(pedidoTable);
		scrollTable.setBounds(290, 110, 490, 300);
		panelForm.add(scrollTable);
		
		/**SubTotal**/
		lblSubtotal = new JLabel("SUBTOTAL");
		lblSubtotal.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
		lblSubtotal.setForeground(Color.WHITE);
		lblSubtotal.setBounds(245, 420, 100, 33);
		lblSubtotal.setHorizontalAlignment(SwingConstants.LEFT);
		panelForm.add(lblSubtotal);
		
		txtSubtotal = new JTextField("16,00");
		txtSubtotal.setFont(new Font("DejaVu Sans", Font.PLAIN, 22));
		txtSubtotal.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtSubtotal.setBounds(345, 420, 150, 33);
		txtSubtotal.setEditable(false);
		panelForm.add(txtSubtotal);
		
		/** Discount **/
		lblDesconto = new JLabel("DESCONTO");
		lblDesconto.setFont(new Font("DejaVu Sans", Font.PLAIN, 16));
		lblDesconto.setForeground(Color.WHITE);
		lblDesconto.setBounds(245, 460, 100, 33);
		lblDesconto.setHorizontalAlignment(SwingConstants.LEFT);
		panelForm.add(lblDesconto);
		
		txtDesconto = new JTextField("0,00");
		txtDesconto.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		txtDesconto.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtDesconto.setBounds(345, 460, 150, 33);
		txtDesconto.setEditable(false);
		panelForm.add(txtDesconto);
		
		/** Observation **/
		lblMotivo = new JLabel("MOTIVO");
		lblMotivo.setFont(new Font("DejaVu Sans", Font.PLAIN, 16));
		lblMotivo.setForeground(Color.WHITE);
		lblMotivo.setBounds(245, 500, 100, 33);
		lblMotivo.setHorizontalAlignment(SwingConstants.LEFT);
		panelForm.add(lblMotivo);
		
		txtAreaMotivo = new JTextArea();
		txtAreaMotivo.setFont(new Font("DejaVu Sans", Font.PLAIN, 16));
		txtAreaMotivo.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtAreaMotivo.setBounds(345, 500, 150, 90);
		txtAreaMotivo.setLineWrap(true);
		panelForm.add(txtAreaMotivo);
		
		/** Total **/
		lblTotal = new JLabel("TOTAL");
		lblTotal.setFont(new Font("DejaVu Sans", Font.PLAIN, 18));
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setBounds(500, 420, 65, 33);
		lblTotal.setHorizontalAlignment(SwingConstants.LEFT);
		panelForm.add(lblTotal);
		
		txtTotal = new JTextField("16,00");
		txtTotal.setFont(new Font("DejaVu Sans", Font.BOLD, 22));
		txtTotal.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtTotal.setBounds(565, 420, 150, 33);
		txtTotal.setEditable(false);
		panelForm.add(txtTotal);
		
		/** Button Pay **/
		btnFinalizar = new JButton("FINALIZAR (F11)");
		btnFinalizar.setBorder(null);
		btnFinalizar.setBackground(new Color(Integer.parseInt("4A90E2", 16)));
		btnFinalizar.setForeground(Color.WHITE);
		btnFinalizar.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		btnFinalizar.setBounds(530, 460, 200, 40);
		panelForm.add(btnFinalizar);
		
		/** Button Cancel **/
		btnCancelar = new JButton("CANCELAR (F12)");
		btnCancelar.setBorder(null);
		btnCancelar.setBackground(new Color(Integer.parseInt("FF4FA4", 16)));
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		btnCancelar.setBounds(530, 505, 200, 40);
		panelForm.add(btnCancelar);
		
		/** Delete an item **/
		lblDeletar = new JLabel("DELETAR (DEL)");
		lblDeletar.setBounds(530,550,150,40);
		lblDeletar.setForeground(Color.WHITE);
		lblDeletar.setFont(new Font("DejaVu Sans", Font.BOLD, 14));
		lblDeletar.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblDeletar);
		
		txtDeletar = new JTextField();
		txtDeletar.setFont(new Font("DejaVu Sans", Font.PLAIN, 16));
		txtDeletar.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtDeletar.setBounds(682,550,48,40);
		panelForm.add(txtDeletar);
		
		panDeletar = new JPanel(null);
		panDeletar.setBounds(530,550,150,40);
		panDeletar.setBackground(new Color(Integer.parseInt("BD7DF5",16)));
		panelForm.add(panDeletar);
		
		comboTamanho = new JComboBox<>();
		comboTamanho.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		comboTamanho.setBounds(445, 34, 120, 37);
		panelForm.add(comboTamanho);
	}



	public JTextField getTxtCod() {
		return txtCod;
	}
	
	public JComboBox<String> getComboTamanho() {
		return comboTamanho;
	}

	public JTextField getTxtNomeDoProduto() {
		return txtNomeDoProduto;
	}

	public JTextField getTxtQtd() {
		return txtQtd;
	}



	public JButton getBtnAdicionar() {
		return btnAdicionar;
	}



	public MostSoldProduct getPrimeiroProduto() {
		return primeiroProduto;
	}



	public MostSoldProduct getSegundoProduto() {
		return segundoProduto;
	}



	public MostSoldProduct getTerceiroProduto() {
		return terceiroProduto;
	}



	public MostSoldProduct getQuartoProduto() {
		return quartoProduto;
	}



	public MostSoldProduct getQuintoProduto() {
		return quintoProduto;
	}



	public JTextField getTxtEmployee() {
		return txtEmployee;
	}



	public JTextField getTxtClient() {
		return txtClient;
	}



	public JTable getPedidoTable() {
		return pedidoTable;
	}



	public JTextField getTxtSubtotal() {
		return txtSubtotal;
	}



	public JTextField getTxtDesconto() {
		return txtDesconto;
	}



	public JTextArea getTxtAreaMotivo() {
		return txtAreaMotivo;
	}



	public JTextField getTxtTotal() {
		return txtTotal;
	}



	public JButton getBtnFinalizar() {
		return btnFinalizar;
	}



	public JButton getBtnCancelar() {
		return btnCancelar;
	}



	public JTextField getTxtDeletar() {
		return txtDeletar;
	}
}