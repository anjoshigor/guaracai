package model;

public abstract class Person {
	private int id;
	private String name;
	private String dateOfBirth;
	private String phone;

	public Person(){};
	
	public Person(int id, String name, String dateOfBirth, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}