package model;

public class Goods {
	private int code;
	private float price;
	private String name; 
	private String description;
	private String size;
	private Category category;
	
	public Goods(int code, float price, String name, String description, String size, Category category) {
		this.code = code;
		this.price = price;
		this.name = name;
		this.description = description;
		this.size = size;
		this.category = category;
	}
	

	public int getCode() {
		return code;
	}
	
	public void setCode(int code) {
		this.code = code;
	}
	
	public float getPrice() {
		return price;
	}
	
	public void setPrice(float price) {
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
}
