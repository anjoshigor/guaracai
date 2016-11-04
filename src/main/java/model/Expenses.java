package model;

public class Expenses {
	
	private int id;
	private String description;
	private float cost;
	private Employee employee;
	
	public Expenses(int id, String description, float cost, Employee employee) {
		this.id = id;
		this.description = description;
		this.cost = cost;
		this.employee = employee;
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

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
	
	
}
