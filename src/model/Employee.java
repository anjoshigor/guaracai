package model;

public class Employee extends Person {
	
	private String cpf;
	private String username;
	private String address;
	private String agency;
	private String count;
	private String type;
	
	public Employee(int id, String name, String dateOfBirth, String phone, String cpf, String username, String address,
			String agency, String count, String type) {
		super(id, name, dateOfBirth, phone);
		this.cpf = cpf;
		this.username = username;
		this.address = address;
		this.agency = agency;
		this.count = count;
		this.type = type;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
	
}
