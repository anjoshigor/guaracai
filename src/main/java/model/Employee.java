package model;

public class Employee extends Person {
	
	private String cpf;
	private String username;
	private String password;
	private Address address;
	private String agency;
	private String count;
	private String type;
	
	public Employee(){
		super();
		this.cpf = "";
		this.username = "";
		this.address = null;
		this.agency = "";
		this.count = "";
		this.type = "";
		this.email = "";
		this.password = "";
	}
	
	public Employee(int id, String name, String dateOfBirth, String phone, String cpf, String username, String password,
			Address address, String agency, String count, String type, String email) {
		super(id, name, dateOfBirth, phone, email);
		this.cpf = cpf;
		this.username = username;
		this.password = password;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
