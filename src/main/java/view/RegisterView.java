package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.RegisterControl;
import util.GraphicsUtil;

public class RegisterView extends JFrame {

	private JPanel contentPane;
	private JPanel panelMenu;
	private JLabel lblImageButtonProduto;
	private JLabel lblImageButtonCliente;
	private JLabel lblProduto;
	private JLabel lblCliente;
	private JLabel lblImageProduto;
	private JLabel lblImageCliente;
	private JLabel lblImageFuncionario;
	private JLabel lblFuncionario;
	private JLabel lblImageButtonFuncionario;
	private JLabel lblImageCategoria;
	private JLabel lblCategoria;
	private JLabel lblImageButtonCategoria;
	private JLabel lblImageButtonProdutoOut;
	private JLabel lblImageButtonClienteOut;
	private JLabel lblImageButtonFuncionarioOut;
	private JLabel lblImageButtonCategoriaOut;
	private JLabel lblImageButtonVoltar;
	private JLabel lblVoltar;

	private RegisterControl registerControl;

	public RegisterView() {
		initRegisterView();
		registerControl =  new RegisterControl(this);
		
	}
	
	private void initRegisterView(){
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
		
		lblImageButtonProdutoOut = new JLabel();
		lblImageButtonProdutoOut.setBounds(214, 37, 250, 250);
		lblImageButtonProdutoOut.setIcon(GraphicsUtil.adjustImage("/drawable/background-out.png", lblImageButtonProdutoOut.getSize()));
		lblImageButtonProdutoOut.setVisible(false);
		panelMenu.add(lblImageButtonProdutoOut);
		
		lblImageButtonClienteOut = new JLabel();
		lblImageButtonClienteOut.setBounds(572, 37, 250, 250);
		lblImageButtonClienteOut.setIcon(GraphicsUtil.adjustImage("/drawable/background-out.png", lblImageButtonClienteOut.getSize()));
		lblImageButtonClienteOut.setVisible(false);
		panelMenu.add(lblImageButtonClienteOut); 
		
		lblImageButtonFuncionarioOut = new JLabel();
		lblImageButtonFuncionarioOut.setBounds(214, 338, 250, 250);
		lblImageButtonFuncionarioOut.setIcon(GraphicsUtil.adjustImage("/drawable/background-out.png", lblImageButtonFuncionarioOut.getSize()));
		lblImageButtonFuncionarioOut.setVisible(false);
		panelMenu.add(lblImageButtonFuncionarioOut);
		
		lblImageButtonCategoriaOut = new JLabel();
		lblImageButtonCategoriaOut.setBounds(572, 338, 250, 250);
		lblImageButtonCategoriaOut.setIcon(GraphicsUtil.adjustImage("/drawable/background-out.png", lblImageButtonCategoriaOut.getSize()));
		lblImageButtonCategoriaOut.setVisible(false);
		panelMenu.add(lblImageButtonCategoriaOut); 
		
		lblCliente = new JLabel("Cliente (F2)");
		lblCliente.setFont(new Font("DejaVu Sans", Font.PLAIN, 24));
		lblCliente.setForeground(Color.WHITE);
		lblCliente.setBounds(620, 224, 171, 27);
		lblCliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblCliente);
		
		lblProduto = new JLabel("Produto (F1)");
		lblProduto.setForeground(Color.WHITE);
		lblProduto.setFont(new Font("DejaVu Sans", Font.PLAIN, 24));
		lblProduto.setBounds(264, 224, 151, 27);
		lblProduto.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblProduto);
	
		lblImageProduto = new JLabel("");
		lblImageProduto.setBounds(273, 71, 128, 128);
		lblImageProduto.setIcon(GraphicsUtil.adjustImage("/drawable/ice-cream.png", lblImageProduto.getSize()));
		lblImageProduto.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblImageProduto);
		
		lblImageCliente = new JLabel("");
		lblImageCliente.setBounds(632, 71, 128, 128);
		lblImageCliente.setIcon(GraphicsUtil.adjustImage("/drawable/users.png", lblImageProduto.getSize()));
		lblImageCliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblImageCliente);
	
		lblImageButtonProduto = new JLabel();
		lblImageButtonProduto.setBounds(214, 37, 250, 250);
		lblImageButtonProduto.setIcon(GraphicsUtil.adjustImage("/drawable/background-button.png", lblImageButtonProduto.getSize()));
		lblImageButtonProduto.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblImageButtonProduto);
	
		lblImageButtonCliente = new JLabel();
		lblImageButtonCliente.setBounds(572, 37, 250, 250);
		lblImageButtonCliente.setIcon(GraphicsUtil.adjustImage("/drawable/background-button.png", lblImageButtonCliente.getSize()));
		lblImageButtonCliente.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblImageButtonCliente);
		
		lblImageFuncionario = new JLabel("");
		lblImageFuncionario.setBounds(273, 372, 128, 128);
		lblImageFuncionario.setIcon(GraphicsUtil.adjustImage("/drawable/manager-avatar.png", lblImageFuncionario.getSize()));
		lblImageFuncionario.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblImageFuncionario);
		
		lblFuncionario = new JLabel("Funcionário (F3)");
		lblFuncionario.setForeground(Color.WHITE);
		lblFuncionario.setFont(new Font("DejaVu Sans", Font.PLAIN, 24));
		lblFuncionario.setBounds(237, 525, 201, 27);
		lblFuncionario.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblFuncionario);
		
		lblImageButtonFuncionario = new JLabel();
		lblImageButtonFuncionario.setBounds(214, 338, 250, 250);
		lblImageButtonFuncionario.setIcon(GraphicsUtil.adjustImage("/drawable/background-button.png", lblImageButtonFuncionario.getSize()));
		lblImageButtonFuncionario.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblImageButtonFuncionario);
		
		lblImageCategoria = new JLabel("");
		lblImageCategoria.setBounds(632, 372, 128, 128);
		lblImageCategoria.setIcon(GraphicsUtil.adjustImage("/drawable/category.png", lblImageCategoria.getSize()));
		lblImageCategoria.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblImageCategoria);
		
		lblCategoria = new JLabel("Categoria (F4)");
		lblCategoria.setForeground(Color.WHITE);
		lblCategoria.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblCategoria.setFont(new Font("DejaVu Sans", Font.PLAIN, 24));
		lblCategoria.setBounds(620, 525, 171, 27);
		panelMenu.add(lblCategoria);
		
		lblImageButtonCategoria = new JLabel();
		lblImageButtonCategoria.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblImageButtonCategoria.setBounds(572, 338, 250, 250);
		lblImageButtonCategoria.setIcon(GraphicsUtil.adjustImage("/drawable/background-button.png", lblImageButtonCategoria.getSize()));
		panelMenu.add(lblImageButtonCategoria);
		

	}
	
	public JLabel getLblImageButtonProduto() {
		return lblImageButtonProduto;
	}

	public JLabel getLblImageButtonCliente() {
		return lblImageButtonCliente;
	}

	public JLabel getLblImageButtonFuncionario() {
		return lblImageButtonFuncionario;
	}

	public JLabel getLblImageButtonCategoria() {
		return lblImageButtonCategoria;
	}

	public JLabel getLblImageButtonProdutoOut() {
		return lblImageButtonProdutoOut;
	}

	public JLabel getLblImageButtonClienteOut() {
		return lblImageButtonClienteOut;
	}

	public JLabel getLblImageButtonFuncionarioOut() {
		return lblImageButtonFuncionarioOut;
	}

	public JLabel getLblImageButtonCategoriaOut() {
		return lblImageButtonCategoriaOut;
	}

	public JLabel getLblImageButtonVoltar() {
		return lblImageButtonVoltar;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JPanel getPanelMenu() {
		return panelMenu;
	}
}
