package util;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MostSoldProduct {
	private JPanel content;
	private JPanel productBackground;
	private JPanel hotkeyBackground;
	private JLabel nome, tamanho, preco, atalho;
	
	public MostSoldProduct(String nome, String tamanho, String preco, String atalho, int x, int y) {
		initAttributes(nome,tamanho,preco,atalho,x,y);	
	}
	
	public void initAttributes(String nome, String tamanho, String preco, String atalho, int x, int y){
		this.content = new JPanel(null);
		this.content.setBounds(x, y, 250, 66);
		this.productBackground = new JPanel(null);
		this.productBackground.setBackground((new Color(Integer.parseInt("BD7DF5", 16))));
		
		this.nome = new JLabel(nome);
		this.nome.setForeground(Color.WHITE);
		this.nome.setFont(new Font("DejaVu Sans", Font.BOLD, 16));
		
		this.tamanho = new JLabel(tamanho);
		this.tamanho.setForeground(Color.WHITE);
		this.tamanho.setFont(new Font("DejaVu Sans", Font.PLAIN, 16));
		
		this.preco = new JLabel(preco);
		this.preco.setForeground(Color.WHITE);
		this.preco.setFont(new Font("DejaVu Sans", Font.PLAIN, 16));
		
		this.hotkeyBackground = new JPanel(null);
		this.hotkeyBackground.setBackground(Color.WHITE);
	
		
		this.atalho = new JLabel(atalho);
		this.atalho.setHorizontalAlignment(SwingConstants.CENTER);
		this.atalho.setForeground(Color.DARK_GRAY);
		this.atalho.setFont(new Font("DejaVu Sans", Font.BOLD, 18));
		
		this.productBackground.setBounds(x, y, 200, 55);
		this.nome.setBounds(x+5, y, 190, 25);
		this.tamanho.setBounds(x+5, y+25, 90, 25);
		this.preco.setBounds(x+97, y+25, 90, 25);
		this.hotkeyBackground.setBounds(x+202, y, 50, 55);
		this.atalho.setBounds(x+202, y, 50, 55);
		
		
		this.content.add(this.nome);
		this.content.add(this.tamanho);
		this.content.add(this.preco);
		this.content.add(this.productBackground);
		
		this.content.add(this.atalho);
		this.content.add(this.hotkeyBackground);

	
	}

	public void setPosition(int x, int y){
//		this.content.remove(productBackground);
//		this.content.remove(nome);
//		this.content.remove(tamanho);
//		this.content.remove(preco);
//		this.content.remove(hotkeyBackground);
//		this.content.remove(atalho);
		this.productBackground.setBounds(x, y, 200, 66);
		this.nome.setBounds(x+5, y, 190, 32);
		this.tamanho.setBounds(x+5, y+34, 90, 32);
		this.preco.setBounds(x+97, y+34, 90, 32);
		this.hotkeyBackground.setBounds(x+202, y, 50, 66);
		this.atalho.setBounds(x+202, y, 50, 66);
//		this.content.add(productBackground);
//		this.content.add(nome);
//		this.content.add(tamanho);
//		this.content.add(preco);
//		this.content.add(hotkeyBackground);
//		this.content.add(atalho);
	}
	
	public JPanel getContent() {
		return content;
	}

	public void setContent(JPanel content) {
		this.content = content;
	}

	public JPanel getProductBackground() {
		return productBackground;
	}

	public void setProductBackground(JPanel productBackground) {
		this.productBackground = productBackground;
	}

	public JPanel getHotkeyBackground() {
		return hotkeyBackground;
	}

	public void setHotkeyBackground(JPanel hotkeyBackground) {
		this.hotkeyBackground = hotkeyBackground;
	}

	public JLabel getNome() {
		return nome;
	}

	public void setNome(JLabel nome) {
		this.nome = nome;
	}

	public JLabel getTamanho() {
		return tamanho;
	}

	public void setTamanho(JLabel tamanho) {
		this.tamanho = tamanho;
	}

	public JLabel getPreco() {
		return preco;
	}

	public void setPreco(JLabel preco) {
		this.preco = preco;
	}

	public JLabel getAtalho() {
		return atalho;
	}

	public void setAtalho(JLabel atalho) {
		this.atalho = atalho;
	}
	
}
