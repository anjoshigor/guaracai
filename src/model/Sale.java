package model;

import java.util.Date;

public class Sale {
	
	private int id;
	private Date date;
	private String observation;
	private float total;
	private float discount;
	private Client client;
	private Employee employee;
	
	public Sale(int id, Date date, String observation, float total, float discount, Client client, Employee employee) {
		this.id = id;
		this.date = date;
		this.observation = observation;
		this.total = total;
		this.discount = discount;
		this.client = client;
		this.employee = employee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
	
	

}
