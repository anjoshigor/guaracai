package model;

public class Goods {
	private int id;
	private int code;
	private double price;
	private String name; 
	private String description;
	private String size;
	private int categoryId;
	
	public Goods(){
		this.id = 0;
		this.code = 0;
		this.price = 0.0;
		this.name = "";
		this.description = "";
		this.size = "";
		this.categoryId = 0;
	}
	
	public Goods(int id, int code, double price, String name, String description, String size, int categoryId) {
		this.id = id;
		this.code = code;
		this.price = price;
		this.name = name;
		this.description = description;
		this.size = size;
		this.categoryId = categoryId;
	}
	
	public int getId(){
		return id;
	}
	
	public void setId(int id){
		this.id = id;
	}

	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
}
