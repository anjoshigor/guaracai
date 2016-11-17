package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.PaymentControl;
import controller.RegisterControl;
import util.GraphicsUtil;

public class PaymentView extends JFrame {

	private JPanel contentPane;
	private JPanel panelMenu;
	
	/** Money **/
	private JLabel lblImageButtonDinheiro;
	private JLabel lblImageButtonDinheiroOut;
	private JLabel lblDinheiro;
	private JLabel lblImageDinheiro;
	
	/** Debt **/
	private JLabel lblImageButtonDebito;
	private JLabel lblImageButtonDebitoOut;
	private JLabel lblDebito;
	private JLabel lblImageDebito;
	
	/** Credit **/
	private JLabel lblImageButtonCredito;
	private JLabel lblImageButtonCreditoOut;
	private JLabel lblCredito;
	private JLabel lblImageCredito;
	
	/** Balance **/
	private JLabel lblImageButtonSaldo;
	private JLabel lblImageButtonSaldoOut;
	private JLabel lblSaldo;
	private JLabel lblImageSaldo;
	
	/** Total **/
	private JPanel panTotal;
	private JLabel lblTotal;
	private JTextField txtTotal;
	
	/** Received **/
	private JPanel panRecebido;
	private JLabel lblRecebido;
	private JTextField txtRecebido;
	
	/** Rest **/
	private JPanel panResto;
	private JLabel lblResto;
	private JTextField txtResto;
	
	/** Change **/
	private JPanel panTroco;
	private JLabel lblTroco;
	private JTextField txtTroco;
	
	/** Button pay **/
	private JButton btnPagar;
	
	/** Button Cancel **/
	private JButton btnCancelar;
	
	/** Button Credit **/
	private JButton btnCreditar;
	
	
	
	//TODO controller
	private PaymentControl paymentControl;

	public PaymentView() {
		initPaymentView();
		paymentControl =  new PaymentControl(this);
		
	}
	
	private void initPaymentView(){
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
		

		panelMenu = new JPanel(null);
		panelMenu.setSize(1024, 640);
		panelMenu.setLocation(GraphicsUtil.getLocaleCenter(panelMenu.getSize(), screenSize));
		panelMenu.setBackground(new Color(Integer.parseInt("9013FE", 16)));
		contentPane.add(panelMenu);
		
		/** Dinheiro **/
		lblImageButtonDinheiroOut = new JLabel();
		lblImageButtonDinheiroOut.setBounds(30, 22, 150, 150);
		lblImageButtonDinheiroOut.setIcon(GraphicsUtil.adjustImage("/drawable/background-out.png", lblImageButtonDinheiroOut.getSize()));
		lblImageButtonDinheiroOut.setVisible(false);
		panelMenu.add(lblImageButtonDinheiroOut);
		
		lblDinheiro = new JLabel("Dinheiro (F1)");
		lblDinheiro.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
		lblDinheiro.setForeground(Color.WHITE);
		lblDinheiro.setBounds(30, 127, 150, 27);
		lblDinheiro.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblDinheiro.setHorizontalAlignment(SwingConstants.CENTER);
		panelMenu.add(lblDinheiro);
		
		lblImageDinheiro = new JLabel("");
		lblImageDinheiro.setBounds(53, 32, 100, 100);
		lblImageDinheiro.setIcon(GraphicsUtil.adjustImage("/drawable/dollar-paper-bills.png", lblImageDinheiro.getSize()));
		lblImageDinheiro.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblImageDinheiro);
	
		lblImageButtonDinheiro = new JLabel();
		lblImageButtonDinheiro.setBounds(30, 22, 150, 150);
		lblImageButtonDinheiro.setIcon(GraphicsUtil.adjustImage("/drawable/background-button.png", lblImageButtonDinheiro.getSize()));
		lblImageButtonDinheiro.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblImageButtonDinheiro);
		
		/** Debito **/
		lblImageButtonDebitoOut = new JLabel();
		lblImageButtonDebitoOut.setBounds(30, 177, 150, 150);
		lblImageButtonDebitoOut.setIcon(GraphicsUtil.adjustImage("/drawable/background-out.png", lblImageButtonDebitoOut.getSize()));
		lblImageButtonDebitoOut.setVisible(false);
		panelMenu.add(lblImageButtonDebitoOut);
		
		lblDebito = new JLabel("Debito (F2)");
		lblDebito.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
		lblDebito.setForeground(Color.WHITE);
		lblDebito.setBounds(30, 287, 150, 27);
		lblDebito.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblDebito.setHorizontalAlignment(SwingConstants.CENTER);
		panelMenu.add(lblDebito);
		
		lblImageDebito = new JLabel("");
		lblImageDebito.setBounds(53, 187, 100, 100);
		lblImageDebito.setIcon(GraphicsUtil.adjustImage("/drawable/credit-card.png", lblImageDebito.getSize()));
		lblImageDebito.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblImageDebito);
	
		lblImageButtonDebito = new JLabel();
		lblImageButtonDebito.setBounds(30, 177, 150, 150);
		lblImageButtonDebito.setIcon(GraphicsUtil.adjustImage("/drawable/background-button.png", lblImageButtonDebito.getSize()));
		lblImageButtonDebito.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblImageButtonDebito);
		
		/** Credito **/
		lblImageButtonCreditoOut = new JLabel();
		lblImageButtonCreditoOut.setBounds(30, 332, 150, 150);
		lblImageButtonCreditoOut.setIcon(GraphicsUtil.adjustImage("/drawable/background-out.png", lblImageButtonCreditoOut.getSize()));
		lblImageButtonCreditoOut.setVisible(false);
		panelMenu.add(lblImageButtonCreditoOut);
		
		lblCredito = new JLabel("Credito (F3)");
		lblCredito.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
		lblCredito.setForeground(Color.WHITE);
		lblCredito.setBounds(30, 442, 150, 27);
		lblCredito.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblCredito.setHorizontalAlignment(SwingConstants.CENTER);
		panelMenu.add(lblCredito);
		
		lblImageCredito = new JLabel("");
		lblImageCredito.setBounds(53, 342, 100, 100);
		lblImageCredito.setIcon(GraphicsUtil.adjustImage("/drawable/credit-cards-payment.png", lblImageCredito.getSize()));
		lblImageCredito.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblImageCredito);
	
		lblImageButtonCredito = new JLabel();
		lblImageButtonCredito.setBounds(30, 332, 150, 150);
		lblImageButtonCredito.setIcon(GraphicsUtil.adjustImage("/drawable/background-button.png", lblImageButtonCredito.getSize()));
		lblImageButtonCredito.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblImageButtonCredito);
		
		/** Saldo **/
		lblImageButtonSaldoOut = new JLabel();
		lblImageButtonSaldoOut.setBounds(30, 485, 150, 150);
		lblImageButtonSaldoOut.setIcon(GraphicsUtil.adjustImage("/drawable/background-out.png", lblImageButtonSaldoOut.getSize()));
		lblImageButtonSaldoOut.setVisible(false);
		panelMenu.add(lblImageButtonSaldoOut);
		
		lblSaldo = new JLabel("Saldo (F4)");
		lblSaldo.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
		lblSaldo.setForeground(Color.WHITE);
		lblSaldo.setBounds(30, 595, 150, 27);
		lblSaldo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		lblSaldo.setHorizontalAlignment(SwingConstants.CENTER);
		panelMenu.add(lblSaldo);
		
		lblImageSaldo = new JLabel("");
		lblImageSaldo.setBounds(53, 495, 100, 100);
		lblImageSaldo.setIcon(GraphicsUtil.adjustImage("/drawable/leather-wallet.png", lblImageSaldo.getSize()));
		lblImageSaldo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblImageSaldo);
	
		lblImageButtonSaldo = new JLabel();
		lblImageButtonSaldo.setBounds(30, 485, 150, 150);
		lblImageButtonSaldo.setIcon(GraphicsUtil.adjustImage("/drawable/background-button.png", lblImageButtonSaldo.getSize()));
		lblImageButtonSaldo.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(lblImageButtonSaldo);
		
		/** Total **/
		lblTotal = new JLabel("TOTAL");
		lblTotal.setBounds(350, 50, 180, 70);
		lblTotal.setFont(new Font("DejaVu Sans", Font.BOLD, 24));
		lblTotal.setForeground(Color.WHITE);
		lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
		panelMenu.add(lblTotal);
		
		panTotal = new JPanel(null);
		panTotal.setBounds(350, 50, 180, 70);
		panTotal.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelMenu.add(panTotal);
		
		txtTotal = new JTextField();
		txtTotal.setFont(new Font("DejaVu Sans", Font.BOLD, 22));
		txtTotal.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtTotal.setBounds(530, 50, 320, 70);
		txtTotal.setEditable(false);
		panelMenu.add(txtTotal);
		
		/** Recebido **/
		lblRecebido = new JLabel("Recebido");
		lblRecebido.setBounds(350, 130, 180, 70);
		lblRecebido.setFont(new Font("DejaVu Sans", Font.PLAIN, 24));
		lblRecebido.setForeground(Color.WHITE);
		lblRecebido.setHorizontalAlignment(SwingConstants.CENTER);
		panelMenu.add(lblRecebido);
		
		panRecebido = new JPanel(null);
		panRecebido.setBounds(350, 130, 180, 70);
		panRecebido.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelMenu.add(panRecebido);
		
		txtRecebido = new JTextField();
		txtRecebido.setFont(new Font("DejaVu Sans", Font.PLAIN, 22));
		txtRecebido.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtRecebido.setBounds(530, 130, 320, 70);
		panelMenu.add(txtRecebido);
		
		/** Resta **/
		lblResto = new JLabel("Resto");
		lblResto.setBounds(350, 210, 180, 70);
		lblResto.setFont(new Font("DejaVu Sans", Font.PLAIN, 24));
		lblResto.setForeground(Color.WHITE);
		lblResto.setHorizontalAlignment(SwingConstants.CENTER);
		panelMenu.add(lblResto);
		
		panResto = new JPanel(null);
		panResto.setBounds(350, 210, 180, 70);
		panResto.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelMenu.add(panResto);
		
		txtResto = new JTextField();
		txtResto.setFont(new Font("DejaVu Sans", Font.PLAIN, 22));
		txtResto.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtResto.setBounds(530, 210, 320, 70);
		txtResto.setEditable(false);
		panelMenu.add(txtResto);
		
		/** Troco **/
		lblTroco = new JLabel("Troco");
		lblTroco.setBounds(350, 290, 180, 70);
		lblTroco.setFont(new Font("DejaVu Sans", Font.BOLD, 24));
		lblTroco.setForeground(Color.WHITE);
		lblTroco.setHorizontalAlignment(SwingConstants.CENTER);
		panelMenu.add(lblTroco);
		
		panTroco = new JPanel(null);
		panTroco.setBounds(350, 290, 180, 70);
		panTroco.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		panelMenu.add(panTroco);
		
		txtTroco = new JTextField();
		txtTroco.setFont(new Font("DejaVu Sans", Font.BOLD, 22));
		txtTroco.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		txtTroco.setBounds(530, 290, 320, 70);
		txtTroco.setEditable(false);
		panelMenu.add(txtTroco);
		
		/** Button Pay **/
		btnPagar = new JButton("PAGAR (F11)");
		btnPagar.setBorder(null);
		btnPagar.setBackground(new Color(Integer.parseInt("4A90E2", 16)));
		btnPagar.setForeground(Color.WHITE);
		btnPagar.setFont(new Font("DejaVu Sans", Font.BOLD, 18));
		btnPagar.setBounds(400, 400, 200, 60);
		btnPagar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(btnPagar);
		
		/** Button Balance **/
		btnCreditar = new JButton("CREDITAR (F10)");
		btnCreditar.setBorder(null);
		btnCreditar.setBackground(new Color(Integer.parseInt("BD7DF5", 16)));
		btnCreditar.setForeground(Color.WHITE);
		btnCreditar.setFont(new Font("DejaVu Sans", Font.BOLD, 18));
		btnCreditar.setBounds(620, 400, 200, 60);
		btnCreditar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(btnCreditar);
		
		/** Button Cancel **/
		btnCancelar = new JButton("CANCELAR (F12)");
		btnCancelar.setBorder(null);
		btnCancelar.setBackground(new Color(Integer.parseInt("FF4FA4", 16)));
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setFont(new Font("DejaVu Sans", Font.BOLD, 18));
		btnCancelar.setBounds(520, 480, 200, 60);
		btnCancelar.setCursor(new Cursor(Cursor.HAND_CURSOR));
		panelMenu.add(btnCancelar);

	}
	

	public JPanel getContentPane() {
		return contentPane;
	}

	public JPanel getPanelMenu() {
		return panelMenu;
	}

	public JLabel getLblImageButtonDinheiro() {
		return lblImageButtonDinheiro;
	}

	public JLabel getLblImageButtonDebito() {
		return lblImageButtonDebito;
	}

	public JLabel getLblImageButtonDebitoOut() {
		return lblImageButtonDebitoOut;
	}

	public JLabel getLblImageButtonCreditoOut() {
		return lblImageButtonCreditoOut;
	}

	public JTextField getTxtTotal() {
		return txtTotal;
	}

	public JTextField getTxtRecebido() {
		return txtRecebido;
	}

	public JTextField getTxtResto() {
		return txtResto;
	}

	public JTextField getTxtTroco() {
		return txtTroco;
	}

	public JButton getBtnPagar() {
		return btnPagar;
	}

	public JButton getBtnCancelar() {
		return btnCancelar;
	}

	public JButton getBtnCreditar() {
		return btnCreditar;
	}
}
