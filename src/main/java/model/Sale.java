package model;

public class Sale {
	
	private int id;
	private String date;
	private String observation;
	private double total;
	private double discount;
	private int clientId;
	private int employeeId;
	
	public Sale(int id, String date, String observation, double total, double discount, int clientId, int employeeId) {
		this.id = id;
		this.date = date;
		this.observation = observation;
		this.total = total;
		this.discount = discount;
		this.clientId = clientId;
		this.employeeId = employeeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

}
