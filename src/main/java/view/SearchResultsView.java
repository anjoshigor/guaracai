package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import util.GraphicsUtil;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;

import controller.SearchResultsControl;

import java.awt.Font;
/**
 * 
 * @author anjoshigor
 *
 */
@SuppressWarnings("serial")
public class SearchResultsView extends JFrame {
	
	// attributes

	/**Outermost content**/
	private JPanel contentPane;
	
	/**Title of the form**/
	private JLabel lblResultTitle;
	
	/**Form Content**/
	private JPanel panelForm;
	
	/**Table**/
	private JScrollPane scrollTable;
	private JTable resultTable;
	
	/**Back Button**/
	private JLabel lblVoltar;
	private JLabel lblImageButtonVoltar;
	private List<?> objectList;
	
	private SearchResultsControl searchResultsControl;
	
	// constructor
	public SearchResultsView() {
		initSearchResultsView();
		searchResultsControl = new SearchResultsControl(this);
	}
	
	// methods
	private void initSearchResultsView() {
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
		
		
		/**Title text**/
		lblResultTitle = new JLabel("Resultados da pesquisa");
		lblResultTitle.setFont(new Font("DejaVu Sans", Font.PLAIN, 48));
		lblResultTitle.setForeground(Color.WHITE);
		lblResultTitle.setBounds(50, 10, 600, 60);
		lblResultTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panelForm.add(lblResultTitle);
		
		/**Table**/
		Vector<Vector<String>> fakeData = new Vector<>();
		fakeData.add(
				new Vector<String>(Arrays.asList(new String[] {"62","Suco Detox","500ml"}))
				);
		fakeData.add(
				new Vector<String>(Arrays.asList(new String[] {"31","Suco Detox","500ml"}))
				);
		fakeData.add(
				new Vector<String>(Arrays.asList(new String[] {"45","Suco Detox","500ml"}))
				);
		fakeData.add(
				new Vector<String>(Arrays.asList(new String[] {"02","Suco Detox","500ml"}))
				);
		fakeData.add(
				new Vector<String>(Arrays.asList(new String[] {"87","Suco Detox","500ml"}))
				);
		fakeData.add(
				new Vector<String>(Arrays.asList(new String[] {"101","Suco Detox","500ml"}))
				);
		fakeData.add(
				new Vector<String>(Arrays.asList(new String[] {"08","Suco Detox","500ml"}))
				);
		fakeData.add(
				new Vector<String>(Arrays.asList(new String[] {"96","Suco Detox","500ml"}))
				);
		fakeData.add(
				new Vector<String>(Arrays.asList(new String[] {"17","Suco Detox","500ml"}))
				);
		fakeData.add(
				new Vector<String>(Arrays.asList(new String[] {"62","Suco Detox","500ml"}))
				);
		fakeData.add(
				new Vector<String>(Arrays.asList(new String[] {"31","Suco Detox","500ml"}))
				);
		fakeData.add(
				new Vector<String>(Arrays.asList(new String[] {"45","Suco Detox","500ml"}))
				);
		fakeData.add(
				new Vector<String>(Arrays.asList(new String[] {"02","Suco Detox","500ml"}))
				);
		fakeData.add(
				new Vector<String>(Arrays.asList(new String[] {"87","Suco Detox","500ml"}))
				);
		fakeData.add(
				new Vector<String>(Arrays.asList(new String[] {"101","Suco Detox","500ml"}))
				);
		fakeData.add(
				new Vector<String>(Arrays.asList(new String[] {"08","Suco Detox","500ml"}))
				);
		fakeData.add(
				new Vector<String>(Arrays.asList(new String[] {"96","Suco Detox","500ml"}))
				);
		fakeData.add(
				new Vector<String>(Arrays.asList(new String[] {"17","Suco Detox","500ml"})));
		
		Vector<String> rows = new Vector<>();
		rows.add("cod");
		rows.add("nome do produto");
		rows.add("tamanho");
		
		resultTable = new JTable(fakeData,rows);
		resultTable.setCursor(new Cursor(Cursor.HAND_CURSOR));
		JTableHeader tableHeader = resultTable.getTableHeader();
		TableColumn coluna0 = resultTable.getColumnModel().getColumn(0);
		coluna0.setMaxWidth(50);
		coluna0.setPreferredWidth(50);
		DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
		centralizado.setHorizontalAlignment(SwingConstants.CENTER);
	
		coluna0.setCellRenderer(centralizado);
		tableHeader.setBackground(new Color(Integer.parseInt("4A90E2", 16)));
		tableHeader.setForeground(Color.WHITE);
		tableHeader.setFont(new Font("DejaVu Sans", Font.PLAIN, 22));
		
		resultTable.setFont(new Font("DejaVu Sans", Font.PLAIN, 20));
		resultTable.setForeground(Color.DARK_GRAY);
		resultTable.setRowHeight(30);
		resultTable.setRowHeight(1, 40);
		
		scrollTable = new JScrollPane(resultTable);
		scrollTable.setBounds(30, 80, 740, 450);
		panelForm.add(scrollTable);
		
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
	
	public void setObjectList(List<?> l){
		objectList = l;
	}
	
	public Object getObjectList(){
		return objectList;
	}
	
	
	public JTable getResultTable() {
		return resultTable;
	}
	
	public JLabel getLblImageButtonVoltar() {
		return lblImageButtonVoltar;
	}
}