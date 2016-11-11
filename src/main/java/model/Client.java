package model;

public class Client extends Person {
	private double amountSpent;
	private double balance;

	public Client(){
		super();
		this.amountSpent = 0.0f;
		this.balance = 0.0;
	}
	
	public Client(int id, String name, String dateOfBirth, String phone, double amountSpent, double balance) {
		super(id, name, dateOfBirth, phone);
		this.amountSpent = amountSpent;
		this.balance = balance;
	}

	public double getAmountSpent() {
		return amountSpent;
	}
	
	public void setAmountSpent(double amountSpent) {
		this.amountSpent = amountSpent;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String toString(){return getName() + " " + getDateOfBirth() + " " + getPhone();}
	
}
