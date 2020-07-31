package bankaccountapp;

// Make class abstract since objects are going to be
// created in checking and savings classes
public abstract class Account implements IBaseRate {
	// List common properties for savings and checking accounts
	private String name;
	private String sSn;
	protected String accountNumber;
	private static int index = 10000;
	private double balance;
	protected double rate;	
	
	// Constructor to set base common properties and initialize the account
	public Account(String name, String sSn, double initDeposit) {
		this.name = name;
		this.sSn = sSn;
		balance = initDeposit;
		
		// Set account number
		index++;
		this.accountNumber = setAccountNumber();
		setRate();
	}
	
	public abstract void setRate();
	
	private String setAccountNumber() {
		String lastTwoOfSSN = sSn.substring(sSn.length()-2, sSn.length());
		int uniqueID = index;
		int randomNumber = (int)(Math.random() * Math.pow(10, 3));
		return lastTwoOfSSN + uniqueID + randomNumber;
	}
	
	public void compound() {
		double accruedInterest = balance * (rate/100);
		balance = balance + accruedInterest;
		System.out.println("Accrued Interest: €" + accruedInterest);
		printBalance();
	}
	
	// List common methods - transactions
	public void deposit(double amount) {
		balance = balance + amount;
		System.out.println("Depositing €" + amount);
		printBalance();
	}
	
	public void withdraw(double amount) {
		balance = balance - amount;
		System.out.println("Withdrawing €" + amount);
		printBalance();
	}
	
	public void transfer(String toWhere, double amount) {
		balance = balance - amount;
		System.out.println("Transfering €" + amount + " to " + toWhere);
		printBalance();
	}
	
	public void printBalance() {
		System.out.println("Your balance is now: €" + balance);
	}
	
	public void showInfo() {
		System.out.println(
				"NAME: " + name +
				"\nACCOUNT NUMBER: " + accountNumber +
				"\nBALANCE: " + balance + 
				"\nRATE: " + rate
				);
	}
}
