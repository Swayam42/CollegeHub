package Q8;

public class BankingApp {
	
	public static void main(String[] args) {
	SavingsAccount s1=new SavingsAccount(1234,5000,3.5f);
	CurrentAccount c1=new CurrentAccount(4321,10000);
	s1.withdrawal(3400);
	System.out.println(s1.displaySaving());
	}

}
