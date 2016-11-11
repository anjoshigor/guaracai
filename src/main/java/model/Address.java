package model;

public class Address {
	private String complement;
	private String city;
	private String street;
	private String district;
	private int number;
	private String state;
	
	public Address(String complement, String city, String street, String district, int number, String state) {
		this.complement = complement;
		this.city = city;
		this.street = street;
		this.district = district;
		this.number = number;
		this.state = state;
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
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}
