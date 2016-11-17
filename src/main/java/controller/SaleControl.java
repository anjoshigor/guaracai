package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.GoodsDAO;
import model.Category;
import model.Goods;
import view.SaleView;

/**
 * 
 * @author alvesmarcos
 *
 */
public class SaleControl {
	
	// attributes
	private SaleView saleView;
	private GoodsDAO goodsDAO;
	private Goods goods;
	private List<Goods> goodsList;
	private Events events;
	private DefaultTableModel modelTable;
	private int itemCount;
	
	// constructor
	public SaleControl(SaleView saleView){
		this.saleView = saleView;
		this.events = new Events();
		this.goodsDAO = new GoodsDAO();
		this.goodsList = null;
		this.itemCount = 0;

		modelTable = (DefaultTableModel) saleView.getPedidoTable().getModel();
		modelTable.setRowCount(0);
		
		// add listeners
		saleView.getTxtCod().addActionListener(events);
		saleView.getComboTamanho().addActionListener(events);
		saleView.getBtnAdicionar().addActionListener(events);
		saleView.getTxtQtd().addActionListener(events);
		saleView.getBtnCancelar().addActionListener(events);
		saleView.getBtnFinalizar().addActionListener(events);
	}
	
	private void addItemTable(){

		int index = saleView.getComboTamanho().getSelectedIndex();
		// TODO
		String priceFormatted = String.format("%.2f", goodsList.get(index).getPrice());
		String subTotal = String.format("%.2f", goodsList.get(index).getPrice() * Integer.parseInt(saleView.getTxtQtd().getText()));
			
		modelTable.addRow(new Object[]{" "+ (++itemCount)," "+ goodsList.get(index).getCode(),
									   " "+ goodsList.get(index).getName(),
									   " "+goodsList.get(index).getSize(),
									   " "+ priceFormatted.replaceAll("\\.",","),
									   " "+saleView.getTxtQtd().getText(),
									   " "+ subTotal.replaceAll("\\.", ",")});
		
		saleView.getTxtCod().setText("");
		saleView.getComboTamanho().removeAllItems();
		saleView.getTxtQtd().setText("");
		saleView.getTxtNomeDoProduto().setText("");
		saleView.getTxtCod().requestFocus();
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

	private class Events implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == saleView.getTxtCod())
				setCodeGoods();
			
			else if(e.getSource() == saleView.getComboTamanho())
				saleView.getTxtQtd().requestFocus();
			
			else if(e.getSource() == saleView.getTxtQtd())
				saleView.getBtnAdicionar().requestFocus();
			
			else if(e.getSource() == saleView.getBtnAdicionar())
				addItemTable();
		}
	}
}
