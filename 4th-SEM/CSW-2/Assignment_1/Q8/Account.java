package Q8;

public abstract class Account {
	private int accountNumber;
	private double balance;
	public abstract double deposit(int d);
	public abstract void withdrawal(int w);
	
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
		
}                                                                                                        
