package model;

public class Address {
	private String complement;
	private String city;
	private String street;
	private String neighborhood;
	private int number;
	private String fs;
	
	public Address(String complement, String city, String street, String neighborhood, int number, String fs) {
		super();
		this.complement = complement;
		this.city = city;
		this.street = street;
		this.neighborhood = neighborhood;
		this.number = number;
		this.fs = fs;
	}
	
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNeighborhood() {
		return neighborhood;
	}
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getFs() {
		return fs;
	}
	public void setFs(String fs) {
		this.fs = fs;
	}
	
	
}
