/**
 * 
 */
package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JLabel;

import dao.CategoryDAO;
import dao.GoodsDAO;
import model.Category;
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
	private CategoryDAO categoryDAO;
	private Goods goods;
	
	public GoodsRegisterControl(GoodsRegisterView goodsRegisterView) {
		this.goodsRegisterView = goodsRegisterView;
		this.events = new Events();
		this.goodsDAO = new GoodsDAO();
		this.categoryDAO = new CategoryDAO();
		this.goods = null;
		initComboxCategory();
		
		//add listeners
		goodsRegisterView.getTxtValor().addFocusListener(events);
		goodsRegisterView.getBtnCadastrar().addActionListener(events);
		goodsRegisterView.getBtnLimpar().addActionListener(events);
		goodsRegisterView.getLblImageButtonVoltar().addMouseListener(events);
		goodsRegisterView.getBtnOK().addActionListener(events);
	}
	
	public GoodsRegisterControl(GoodsRegisterView goodsRegisterView, Goods goods) {
		this.goodsRegisterView = goodsRegisterView;
		this.events = new Events();
		this.goodsDAO = new GoodsDAO();
		this.categoryDAO = new CategoryDAO();
		this.goods = goods;
		initComboxCategory();
		
		if(goodsRegisterView.getWhoCalled() == 0){
			JLabel lblTitleUpdateProduto =  goodsRegisterView.getLblTitleProduto();
			lblTitleUpdateProduto.setText("Atualização de Produtos");
			
			JButton btnAtualizar= goodsRegisterView.getBtnCadastrar();
			btnAtualizar.setText("Atualizar");
			
			JButton btnDeletar = goodsRegisterView.getBtnLimpar();
			btnDeletar.setText("Deletar");
		}
		
		//add listeners
		goodsRegisterView.getTxtValor().addFocusListener(events);
		goodsRegisterView.getBtnCadastrar().addActionListener(events);
		goodsRegisterView.getBtnLimpar().addActionListener(events);
		goodsRegisterView.getLblImageButtonVoltar().addMouseListener(events);
	}
	
	private void cleanFields(){
		goodsRegisterView.getTxtNome().setText("");
		goodsRegisterView.getTxtCod().setText("");
		goodsRegisterView.getComboCategoria().setSelectedIndex(0);
		goodsRegisterView.getTxtValor().setText("R$ 0,00");
		goodsRegisterView.getTxtTamanho().setText("");
		goodsRegisterView.getTxtDescricao().setText("");
	}
	
private boolean checkFields(){
		
		if(goodsRegisterView.getTxtNome().getText().isEmpty() ||
		   goodsRegisterView.getTxtCod().getText().isEmpty() || 
		   goodsRegisterView.getTxtValor().getText().isEmpty() ||
		   goodsRegisterView.getTxtTamanho().getText().isEmpty()){
			
			return false;
		}
		
		return true;
	}
	
	
	private void initComboxCategory(){
		List<Category> categoryList = categoryDAO.getAll();
		
		for(Category c: categoryList)
			goodsRegisterView.getComboCategoria().addItem(c.getName());
	}
	
	private void insert() throws ParseException {
		goods = new Goods();
		Category categoryName = categoryDAO.findByName(String.valueOf(goodsRegisterView.getComboCategoria().getSelectedItem())).get(0);
		
		double price = 0.0;
		    
		NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
		    
		String formattedPrice = goodsRegisterView.getTxtValor().getText().replaceAll("R\\$ ", "");
		    
		if(!formattedPrice.equals("0,00"))
			price = nf.parse(formattedPrice).doubleValue();
		
		goods.setName(goodsRegisterView.getTxtNome().getText());
		goods.setCode(Integer.parseInt(goodsRegisterView.getTxtCod().getText()));
		goods.setCategoryId(categoryDAO.findById(categoryName.getId()).getId());
		goods.setPrice(price);
		goods.setSize(goodsRegisterView.getTxtTamanho().getText());
		goods.setDescription(goodsRegisterView.getTxtDescricao().getText());
		
		if(goodsDAO.add(goods)==1){
			goodsRegisterView.getPanelDialog().setVisible(true);
		}
	}
	
	private void update(Goods goods) throws ParseException {
		Category categoryName = categoryDAO.findByName(String.valueOf(goodsRegisterView.getComboCategoria().getSelectedItem())).get(0);
		
		double price = 0.0;
		    
		NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
		    
		String formattedPrice = goodsRegisterView.getTxtValor().getText().replaceAll("R\\$ ", "");
		    
		if(!formattedPrice.equals("0,00"))
			price = nf.parse(formattedPrice).doubleValue();
		
		goods.setName(goodsRegisterView.getTxtNome().getText());
		goods.setCode(Integer.parseInt(goodsRegisterView.getTxtCod().getText()));
		goods.setCategoryId(categoryDAO.findById(categoryName.getId()).getId());
		goods.setPrice(price);
		goods.setSize(goodsRegisterView.getTxtTamanho().getText());
		goods.setDescription(goodsRegisterView.getTxtDescricao().getText());
		
		if(goodsDAO.update(goods)==1){
			goodsRegisterView.getLblMessageError().setText("<html>Produto atualizad</br>com sucesso!</html>");
			goodsRegisterView.getPanelDialog().setVisible(true);
		}
		
	}
	
	private void delete(Goods goods){
		//TODO
		goodsDAO.delete(goods);
	}

	//inner class
	private class Events implements ActionListener,FocusListener, MouseListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == goodsRegisterView.getBtnCadastrar()) {
					try {
						if(goodsRegisterView.getWhoCalled() == 1){
							insert();
							}
						else{
							update(goods);
						}
					} catch (ParseException pe) {
						pe.printStackTrace();
					}
				
				} else if(e.getSource() == goodsRegisterView.getBtnLimpar()){
					if(goodsRegisterView.getWhoCalled() == 0)
						delete(goods);
					else
						cleanFields();
				} else if(e.getSource() == goodsRegisterView.getBtnOK()){
						goodsRegisterView.getPanelDialog().setVisible(false);
						cleanFields();
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

		@Override
		public void focusGained(FocusEvent e) {
			goodsRegisterView.getTxtValor().setForeground(new Color(51, 51, 51));
			goodsRegisterView.getTxtValor().setText("");
		}

		@Override
		public void focusLost(FocusEvent e) {
			if(goodsRegisterView.getTxtValor().getText().isEmpty()){
				goodsRegisterView.getTxtValor().setForeground(Color.GRAY);
				goodsRegisterView.getTxtValor().setText("R$ 0,00");
			} else {
				goodsRegisterView.getTxtValor().setForeground(new Color(51, 51, 51));
				String previous = goodsRegisterView.getTxtValor().getText();
				goodsRegisterView.getTxtValor().setText("R$ "+previous);
			}
		}	
	}
}
