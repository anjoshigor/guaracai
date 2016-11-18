package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import view.PaymentView;
import view.SaleView;

/**
 * 
 * @author anjoshigor
 *
 */
public class PaymentControl {
	private PaymentView paymentView;
	private SaleControl saleControl;
	private Events events;
	private double total;
	private JTextField txtTroco, txtResto, txtTotal, txtRecebido;
	private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
	
	public PaymentControl(PaymentView paymentView, SaleControl saleControl){
		this.paymentView = paymentView;
		this.events = new Events();
		this.saleControl = saleControl;
		
		this.paymentView.getContentPane().getInputMap(IFW).put(KeyStroke.getKeyStroke("F1"),"dinheiro");
		this.paymentView.getContentPane().getInputMap(IFW).put(KeyStroke.getKeyStroke("F2"),"debito");
		this.paymentView.getContentPane().getInputMap(IFW).put(KeyStroke.getKeyStroke("F3"),"credito");
		this.paymentView.getContentPane().getInputMap(IFW).put(KeyStroke.getKeyStroke("F4"),"saldo");
		this.paymentView.getContentPane().getInputMap(IFW).put(KeyStroke.getKeyStroke("F11"),"calcularNovoTotal");
		this.paymentView.getContentPane().getInputMap(IFW).put(KeyStroke.getKeyStroke("F12"),"dispose");
		this.paymentView.getContentPane().getInputMap(IFW).put(KeyStroke.getKeyStroke("F10"),"calcularNovoTotal");
		
		this.paymentView.getContentPane().getActionMap().put("dinheiro", dinheiro);
		this.paymentView.getContentPane().getActionMap().put("credito", credito);
		this.paymentView.getContentPane().getActionMap().put("debito", debito);
		this.paymentView.getContentPane().getActionMap().put("saldo", saldo);
		this.paymentView.getContentPane().getActionMap().put("calcularNovoTotal", calcularNovoTotal);
		this.paymentView.getContentPane().getActionMap().put("dispose", dispose);
		
		txtTroco = paymentView.getTxtTroco();
		txtResto = paymentView.getTxtResto();
		txtTotal = paymentView.getTxtTotal();
		txtRecebido = paymentView.getTxtRecebido();
		total = 0.0;
		
		paymentView.getTxtRecebido().addActionListener(events);
		paymentView.getLblImageButtonDebito().addMouseListener(events);
		paymentView.getLblImageButtonCredito().addMouseListener(events);
		paymentView.getLblImageButtonDinheiro().addMouseListener(events);
		paymentView.getLblImageButtonSaldo().addMouseListener(events);
		paymentView.getBtnPagar().addMouseListener(events);
		paymentView.getBtnCancelar().addMouseListener(events);
		paymentView.getBtnCreditar().addMouseListener(events);
		
	}
	
	/**ACTIONS**/
	
	Action dinheiro = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
	        setVisibleButtons(true, false, false, false);
	    }
	};
	
	Action debito = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
	        setVisibleButtons(false, true, false, false);
	    }
	};
	
	Action credito = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
	        setVisibleButtons(false, false, true, false);
	    }
	};
	
	Action saldo = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
	        setVisibleButtons(false, false, false, true);
	    }
	};
	
	Action dispose = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
	        paymentView.dispose();
	    }
	};
	
	Action calcularNovoTotal = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
	    	calcularNovoTotal();
	    }
	};
	
	
	
	
	private void calcularResto(){
		total = Double.parseDouble(txtTotal.getText().replaceAll(",", "\\."));
		double sub = Double.parseDouble(txtRecebido.getText().replaceAll(",", "\\."));
		double troco = total - sub;
		if(troco < 0){	
			txtTroco.setText(String.format("%.2f", Math.abs(troco)).replaceAll("\\.", ","));
			txtResto.setText("0,00");
		} else {
			txtResto.setText(String.format("%.2f", troco).replaceAll("\\.", ","));
			txtTroco.setText("0,00");
		}
	}
	
	private void calcularNovoTotal(){
		String resto = txtResto.getText().replaceAll(",", "\\.");
		if (Double.parseDouble(resto) > 0){
			txtTotal.setText(resto);
			txtResto.setText("0,00");
			txtRecebido.setText("0,00");
		} else {
			paymentView.dispose();
			saleControl.getSaleView().dispose();
			new SaleView().setVisible(true);
		}
	}
	
	private void setVisibleButtons(boolean dinheiro, boolean debito, boolean credito, boolean saldo){
		paymentView.getLblImageButtonDebitoOut().setVisible(debito);
		paymentView.getLblImageButtonDinheiroOut().setVisible(dinheiro);
		paymentView.getLblImageButtonCreditoOut().setVisible(credito);
		paymentView.getLblImageButtonSaldoOut().setVisible(saldo);
	}
	
	private class Events implements ActionListener, MouseListener {	
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == paymentView.getTxtRecebido()){
				calcularResto();
			}
				
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			 if(e.getSource() == paymentView.getBtnPagar()){
				calcularNovoTotal();
			} 
			 else if(e.getSource() == paymentView.getBtnCreditar()){
				calcularNovoTotal();
			} 
			 else if(e.getSource() == paymentView.getBtnCancelar()){
				paymentView.dispose();
			}

			else if(e.getSource() == paymentView.getLblImageButtonDinheiro()){
				setVisibleButtons(true,false,false,false);
			}

			else if(e.getSource() == paymentView.getLblImageButtonDebito()){
				setVisibleButtons(false,true,false,false);
			}
			 
			else if(e.getSource() == paymentView.getLblImageButtonCredito()){
				setVisibleButtons(false,false,true,false);
			}
			 
			else if(e.getSource() == paymentView.getLblImageButtonSaldo()){
				setVisibleButtons(false,false,false,true);
			}
		}

		@Override
		public void mousePressed(MouseEvent e) { }
		@Override
		public void mouseReleased(MouseEvent e) { }
		@Override
		public void mouseEntered(MouseEvent e) { }
		@Override
		public void mouseExited(MouseEvent e) { }

	}
}
