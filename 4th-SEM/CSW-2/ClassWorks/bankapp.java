package csw2;
class balanceAcc{
	int balance=54656;
	public void deposit(int amt) {
		balance+=amt;
	}
	
	public void withdraw(int amt) {
		balance-=amt;
	}
	public void display() {
		System.out.println(balance);
	}
}
public class bankapp {

	public static void main(String[] args) {
		
		balanceAcc ob=new balanceAcc();
		ob.deposit(100);
		ob.display();
	}

}
