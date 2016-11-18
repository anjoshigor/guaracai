package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import dao.GoodsDAO;
import model.Goods;
import view.CategoryRegisterView;
import view.ClientRegisterView;
import view.EmployeeRegisterView;
import view.GoodsRegisterView;
import view.PaymentView;
import view.SaleView;
import view.SearchView;

/**
 * 
 * @author alvesmarcos
 *
 */
public class SaleControl {
	
	// attributes
	private SaleView saleView;
	private PaymentView pagamento;
	private GoodsDAO goodsDAO;
	private List<Goods> goodsList;
	private Events events;
	private DefaultTableModel modelTable;
	private int itemCount;
	private double subTotal;
	private static final int IFW = JComponent.WHEN_IN_FOCUSED_WINDOW;
	
	// constructor
	public SaleControl(SaleView saleView){
		this.saleView = saleView;
		this.events = new Events();
		this.goodsDAO = new GoodsDAO();
		this.goodsList = null;
		this.itemCount = 0;
		
		this.subTotal = 0.0;

		pagamento = new PaymentView(this);
		
		modelTable = (DefaultTableModel) saleView.getPedidoTable().getModel();
		modelTable.setRowCount(0);
		
		saleView.getTxtSubtotal().setText("0,00");
		saleView.getTxtDesconto().setText("0,00");
		saleView.getTxtTotal().setText("0,00");
		
		this.saleView.getContentPane().getInputMap(IFW).put(KeyStroke.getKeyStroke("F11"),"finalizar");
		this.saleView.getContentPane().getInputMap(IFW).put(KeyStroke.getKeyStroke("F12"),"cancelar");
		this.saleView.getContentPane().getInputMap(IFW).put(KeyStroke.getKeyStroke("F6"),"consultar");
		this.saleView.getContentPane().getInputMap(IFW).put(KeyStroke.getKeyStroke("DELETE"),"deletar");
		
		this.saleView.getContentPane().getActionMap().put("finalizar", finalizarAction);
		this.saleView.getContentPane().getActionMap().put("cancelar", cancelarAction);
		this.saleView.getContentPane().getActionMap().put("consultar", consultarAction);
		this.saleView.getContentPane().getActionMap().put("deletar", deletarAction);
		
		// add listeners
		saleView.getTxtCod().addActionListener(events);
		saleView.getLblDeletar().addMouseListener(events);
		saleView.getComboTamanho().addActionListener(events);
		saleView.getBtnAdicionar().addActionListener(events);
		saleView.getTxtQtd().addActionListener(events);
		saleView.getBtnCancelar().addActionListener(events);
		saleView.getBtnFinalizar().addActionListener(events);
		saleView.getLblImageButtonPesquisa().addMouseListener(events);
		saleView.getLblPesquisa().addMouseListener(events);
		saleView.getTxtDesconto().addActionListener(events);
	}
	
	/**ACTIONS**/
	
	Action finalizarAction = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
	    	pagamento.getTxtTotal().setText(saleView.getTxtTotal().getText());
			pagamento.setVisible(true);
	    }
	};
	
	Action cancelarAction = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
	    	saleView.dispose();
	    }
	};
	
	Action consultarAction = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
	    	new SearchView().setVisible(true);
	    }
	};
	
	Action deletarAction = new AbstractAction() {
	    public void actionPerformed(ActionEvent e) {
	    	removeItemTable();
	    }
	};
	
	
	private void addItemTable(){

		int index = saleView.getComboTamanho().getSelectedIndex();
		// TODO
		String priceFormatted = String.format("%.2f", goodsList.get(index).getPrice());
		String subTotalFormatted = String.format("%.2f", goodsList.get(index).getPrice() * Integer.parseInt(saleView.getTxtQtd().getText()));
			
		modelTable.addRow(new Object[]{" "+ (++itemCount)," "+ goodsList.get(index).getCode(),
									   " "+ goodsList.get(index).getName(),
									   " "+goodsList.get(index).getSize(),
									   " "+ priceFormatted.replaceAll("\\.",","),
									   " "+saleView.getTxtQtd().getText(),
									   " "+ subTotalFormatted.replaceAll("\\.", ",")});
		
		subTotal += Double.parseDouble(subTotalFormatted);
		
		saleView.getTxtSubtotal().setText(String.format("%.2f", subTotal).replaceAll("\\.", ","));
		//saleView.getTxtTotal().setText(String.format("%.2f", subTotal).replaceAll("\\.", ","));
		subDesconto();
		
		saleView.getTxtCod().setText("");
		saleView.getComboTamanho().removeAllItems();
		saleView.getTxtQtd().setText("");
		saleView.getTxtNomeDoProduto().setText("");
		saleView.getTxtCod().requestFocus();
	}
	
	private void removeItemTable(){
		int row = Integer.parseInt(saleView.getTxtDeletar().getText()) - 1 ;
		
		double sub = Double.parseDouble(String.valueOf(modelTable.getValueAt(row, 6)).replaceAll(",", "\\."));

		subTotal -= sub;
		saleView.getTxtSubtotal().setText(String.format("%.2f", subTotal).replaceAll("\\.", ","));
		saleView.getTxtTotal().setText(String.format("%.2f", subTotal).replaceAll("\\.", ","));
		
		modelTable.removeRow(row);
	}
	
	private void setCodeGoods(){
		goodsList = goodsDAO.findByCode(Integer.parseInt(saleView.getTxtCod().getText()));
		
		saleView.getComboTamanho().removeAll();
		
		if(goodsList.size() > 0){
			saleView.getTxtNomeDoProduto().setText(goodsList.get(0).getName());
			
			for(Goods g: goodsList)
				saleView.getComboTamanho().addItem(g.getSize());
			
			saleView.getComboTamanho().requestFocus();
		}	
	}
	
	private void subDesconto(){
		double sub = Double.parseDouble(saleView.getTxtDesconto().getText().replaceAll(",", "\\."));
		double subTotal = Double.parseDouble(saleView.getTxtSubtotal().getText().replaceAll(",", "\\.")) - sub;
		saleView.getTxtTotal().setText(String.format("%.2f", subTotal).replaceAll("\\.", ","));
	}

	private class Events implements ActionListener, MouseListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == saleView.getTxtCod())
				setCodeGoods();
			
			else if(e.getSource() == saleView.getComboTamanho())
				saleView.getTxtQtd().requestFocus();
			
			else if(e.getSource() == saleView.getTxtQtd())
				saleView.getBtnAdicionar().requestFocus();

			else if(e.getSource() == saleView.getTxtDesconto()){
				saleView.getTxtAreaMotivo().requestFocus();
				subDesconto();
			}
			else if(e.getSource() == saleView.getBtnAdicionar())
				addItemTable();
			
			else if(e.getSource() == saleView.getBtnCancelar())
				saleView.dispose();
			
			else if(e.getSource() == saleView.getBtnFinalizar()){
				pagamento.getTxtTotal().setText(saleView.getTxtTotal().getText());
				pagamento.setVisible(true);
			}
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == saleView.getLblDeletar())
				removeItemTable();
			else if(e.getSource() == saleView.getLblImageButtonPesquisa() || e.getSource() == saleView.getLblPesquisa())
				new SearchView().setVisible(true);
			
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

	public SaleView getSaleView() {
		return saleView;
	}
}
