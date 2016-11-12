package model;

public class Expenses {
	
	private int id;
	private String description;
	private double cost;
	private int employeeId;
	
	public Expenses(int id, String description, double cost, int employeeId) {
		this.id = id;
		this.description = description;
		this.cost = cost;
		this.employeeId = employeeId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
}
