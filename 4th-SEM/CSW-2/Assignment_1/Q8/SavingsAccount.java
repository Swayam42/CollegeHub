package Q8;

class SavingsAccount extends Account {
	public float interestRate;
	
	
	public SavingsAccount(int accountNumber,double balance,float interestRate) {
		setAccountNumber(accountNumber);
		setBalance(balance);
		this.interestRate = interestRate;
	}


	@Override
	public double deposit(int d) {
		double i=(getBalance()*interestRate)/100;
		setBalance(getBalance()+i);
		return getBalance();
	}


	@Override
	public void withdrawal(int w) {
		if(w>getBalance()) {
			System.out.print("No Sufficient Funds");
		}else {
			setBalance(getBalance()-w);
		}
		
	}
	
	public String displaySaving() {
		return "SavingAccount No. : "+getAccountNumber()+"\nBalance: "+getBalance();
	}
	
	
	
}
