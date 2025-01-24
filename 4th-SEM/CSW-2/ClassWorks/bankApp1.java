package csw2;
class balanceAccount{
	
	private int balance;
	
	public void setBalance(int amt) {
		balance=amt;
	}
	public int getBalance() {
		return balance;
	}
	public void deposit(int amt) {
		balance+=amt;
	}
	
	public void withdraw(int amt) {
		balance-=amt;
	}
}
	public class bankApp1 {

	public static void main(String[] args) {
		balanceAccount obj=new balanceAccount();
		obj.setBalance(10000);
		obj.deposit(5000);
		obj.withdraw(500);
		System.out.println(obj.getBalance());
		
	}

}
