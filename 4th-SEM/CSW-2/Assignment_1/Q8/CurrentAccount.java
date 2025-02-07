package Q8;

public class CurrentAccount extends Account{
	private final int overdraftLimit=10000;
	
	public CurrentAccount(int accountNumber,double balance) {
		setAccountNumber(accountNumber);
		setBalance(balance);
		
	}




	@Override
	public double deposit(int d) {
		// TODO Auto-generated method stub
		return 0;
	}



	@Override
	public void withdrawal(int w) {
		if(w<=getBalance()) {
			setBalance(getBalance()-w);
		}else if(w>getBalance() &&w-getBalance()<=overdraftLimit) {
			setBalance(w-getBalance()-overdraftLimit);
		}else {
			System.out.println("Overdraft Limit exceeded");
		}
		
	}
	
	public String displayCurrent() {
		return "CurrentAccount No. : "+getAccountNumber()+"\nBalance: "+getBalance();
	}
}
