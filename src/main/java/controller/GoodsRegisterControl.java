/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.CloseAction;

import org.springframework.expression.spel.ast.RealLiteral;

import dao.GoodsDAO;
import model.Goods;
import view.GoodsRegisterView;


/**
 * @author diogodantas
 *
 */
public class GoodsRegisterControl {

	private GoodsRegisterView goodsRegisterView;
	private Events events;
	private GoodsDAO goodsDAO;
	private Goods goods;
	
	public GoodsRegisterControl(GoodsRegisterView goodsRegisterView) {
		// TODO Auto-generated constructor stub
		this.goodsRegisterView = goodsRegisterView;
		this.events = new Events();
		this.goodsDAO = new GoodsDAO();
		this.goods = null;
		
		//add listeners
		goodsRegisterView.getBtnCadastrar().addActionListener(events);
		goodsRegisterView.getBtnLimpar().addActionListener(events);
		goodsRegisterView.getLblImageButtonVoltar().addMouseListener(events);
		
		
	}
	
	private void CleanFields(){
		goodsRegisterView.getTxtNome().setText("");
		goodsRegisterView.getTxtCod().setText("");
		goodsRegisterView.getComboCategoria().setSelectedIndex(0);
		goodsRegisterView.getTxtValor().setText("");
		goodsRegisterView.getTxtTamanho().setText("");
		goodsRegisterView.getTxtDescricao().setText("");
	}
	
	private void insert(){
		goods = new Goods();
		
		goods.setName(goodsRegisterView.getTxtNome().getText());
		goods.setCode(Integer.parseInt(goodsRegisterView.getTxtCod().getText()));
		//goods.setCategoryId(); Depois que alterar a combo box
		goods.setPrice(Double.parseDouble(goodsRegisterView.getTxtValor().getText()));
		goods.setSize(Integer.parseInt(goodsRegisterView.getTxtTamanho().getText()));
		goods.setDescription(goodsRegisterView.getTxtDescricao().getText());
		
		goodsDAO.add(goods);
		
	}
	

	//inner class
	private class Events implements ActionListener, MouseListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == goodsRegisterView.getBtnCadastrar()) {
				insert();
			} 
			else if(e.getSource() == goodsRegisterView.getBtnLimpar()) {
				CleanFields();
			}			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == goodsRegisterView.getLblImageButtonVoltar()){
				goodsRegisterView.dispose();
				goodsDAO.disconnect();
			}
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
}
