/**
 * 
 */
package controller;

import java.awt.Color;
import java.awt.Font;
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
import dao.CategoryDAO;
import dao.GoodsDAO;
import model.Category;
import model.Goods;
import util.GraphicsUtil;
import util.SystemConstUtil;
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
	private short call;
	
	public GoodsRegisterControl(GoodsRegisterView goodsRegisterView) {
		this.goodsRegisterView = goodsRegisterView;
		this.events = new Events();
		this.goodsDAO = new GoodsDAO();
		this.categoryDAO = new CategoryDAO();
		this.goods = null;
		this.call = SystemConstUtil.INSERT;
		initComboxCategory();
		
		//add listeners
		goodsRegisterView.getTxtValor().addFocusListener(events);
		goodsRegisterView.getBtnCadastrar().addActionListener(events);
		goodsRegisterView.getBtnLimpar().addActionListener(events);
		goodsRegisterView.getLblImageButtonVoltar().addMouseListener(events);
		goodsRegisterView.getBtnOK().addActionListener(events);
		goodsRegisterView.getBtnNao().addActionListener(events);
		goodsRegisterView.getBtnSim().addActionListener(events);
	}
	
	public GoodsRegisterControl(GoodsRegisterView goodsRegisterView, Goods goods) {
		this(goodsRegisterView);
		this.call = SystemConstUtil.UPDATE;
		this.goods = goods;
		goodsRegisterView.getBtnCadastrar().setText("Atualizar");
		goodsRegisterView.getBtnLimpar().setText("Deletar");
		goodsRegisterView.getLblTitleProduto().setText("Atualização de Produtos");
		goodsRegisterView.getLblTitleProduto().setFont(new Font("DejaVu Sans", Font.PLAIN, 50));
		
		goodsRegisterView.getTxtNome().setText(goods.getName());
		goodsRegisterView.getTxtCod().setText(String.valueOf(goods.getCode()));
		goodsRegisterView.getComboCategoria().setSelectedItem(categoryDAO.findById(goods.getCategoryId()).getName());
		
		String mask = String.format("R$ %.2f", goods.getPrice());
		goodsRegisterView.getTxtValor().setText(mask.replaceAll("\\.", ","));
		
		goodsRegisterView.getTxtTamanho().setText(goods.getSize());
		goodsRegisterView.getTxtDescricao().setText(goods.getDescription());
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
	
	private void inflate(){
		Category categoryName = categoryDAO.findByName(String.valueOf(goodsRegisterView.getComboCategoria().getSelectedItem())).get(0);
		double price = 0.0;   
		NumberFormat nf = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
		    
		String formattedPrice = goodsRegisterView.getTxtValor().getText().replaceAll("R\\$ ", "");
		try {
			if (!formattedPrice.equals("0,00"))
				price = nf.parse(formattedPrice).doubleValue();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		goods.setName(goodsRegisterView.getTxtNome().getText());
		goods.setCode(Integer.parseInt(goodsRegisterView.getTxtCod().getText()));
		goods.setCategoryId(categoryDAO.findById(categoryName.getId()).getId());
		goods.setPrice(price);
		goods.setSize(goodsRegisterView.getTxtTamanho().getText());
		goods.setDescription(goodsRegisterView.getTxtDescricao().getText());
	}
	
	private void insert() {
		goods = new Goods();
		inflate();
		
		if(checkFields()) {
			showPanelDialog();
			goodsDAO.add(goods);
		} else {
			goodsRegisterView.getLblMessageError().setVisible(true);
		} 
	}
	
	private void showPanelDialog(){
		goodsRegisterView.getPanelDialog().setVisible(true);
		
		goodsRegisterView.getTxtNome().setEnabled(false);
		goodsRegisterView.getTxtCod().setEnabled(false);
		goodsRegisterView.getComboCategoria().setEnabled(false);
		goodsRegisterView.getTxtValor().setEnabled(false);
		goodsRegisterView.getTxtTamanho().setEnabled(false);
		goodsRegisterView.getTxtDescricao().setEnabled(false);
		
		goodsRegisterView.getBtnCadastrar().setEnabled(false);
		goodsRegisterView.getBtnLimpar().setEnabled(false);
	}
	
	private void disposePanelDialog(){
		goodsRegisterView.getPanelDialog().setVisible(false);
		goodsRegisterView.getTxtNome().requestFocus();
		
		goodsRegisterView.getTxtNome().setEnabled(true);
		goodsRegisterView.getTxtCod().setEnabled(true);
		goodsRegisterView.getComboCategoria().setEnabled(true);
		goodsRegisterView.getTxtValor().setEnabled(true);
		goodsRegisterView.getTxtTamanho().setEnabled(true);
		goodsRegisterView.getTxtDescricao().setEnabled(true);
		
		goodsRegisterView.getBtnCadastrar().setEnabled(true);
		goodsRegisterView.getBtnLimpar().setEnabled(true);
		
		cleanFields();
	}
	
	private void update(){
		inflate();
		
		if(checkFields()){
			showPanelDialog();
			goodsDAO.update(goods);
		} else 
			goodsRegisterView.getLblMessageError().setVisible(true);
	}
	
	//inner class
	private class Events implements ActionListener,FocusListener, MouseListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == goodsRegisterView.getBtnCadastrar()) {
				if(call == SystemConstUtil.INSERT)
					insert();
				else if(call == SystemConstUtil.UPDATE)
					update();
			
			} else if (e.getSource() == goodsRegisterView.getBtnLimpar()) {
				if(call == SystemConstUtil.INSERT)
					cleanFields();
				else if(call == SystemConstUtil.UPDATE){
					goodsRegisterView.getBtnOK().setVisible(false);
					goodsRegisterView.getBtnSim().setVisible(true);
					goodsRegisterView.getBtnNao().setVisible(true);
					
					goodsRegisterView.getLblMessagedialog().setText("<html>Deseja realmente<br>excluir registro ?<html>");
					goodsRegisterView.getLblIconMessage().setIcon(GraphicsUtil.adjustImage("/drawable/warning.png", 
							goodsRegisterView.getLblIconMessage().getSize()));
					showPanelDialog();
				}
				
			} else if (e.getSource() == goodsRegisterView.getBtnOK()) {
				disposePanelDialog();
				if(call == SystemConstUtil.UPDATE)
					goodsRegisterView.dispose();
			
			} else if(e.getSource() == goodsRegisterView.getBtnSim()){
				goodsDAO.delete(goods);
				goodsRegisterView.dispose();
			
			} else if(e.getSource() == goodsRegisterView.getBtnNao()){
				goodsRegisterView.dispose();
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
