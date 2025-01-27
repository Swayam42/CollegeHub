package csw2;
import java.util.Scanner;
public class Account {
	private long accountNo;
	private String name;
	private String email;
	private float balance;
	
	//setter method :
	void setData() {
		Scanner sc=new Scanner(System.in);
		System.out.print("Input Account No. :");
		this.accountNo=sc.nextLong();
		System.out.print("Input Name :");
		this.name=sc.nextLine();
		System.out.print("Input E-Mail :");
		this.email=sc.next();
		System.out.print("Input Balance :");
		this.balance=sc.nextFloat();
		sc.close();
	}
	
	
	
	//getter method :
	long getAccno() {
		return accountNo;
	}
	String getName() {
		return name;
	}
	String getEmail() {
		return email;
	}
	float getBalance() {
		return balance;
	}
	public static void main(String[] args) {
		Account a1=new Account();
		a1.setData();
		System.out.println("\nAccount No : "+a1.getAccno());
		System.out.println("Name : "+a1.getName());
		System.out.println("E-mail : "+a1.getEmail());
		System.out.println("Balance : "+a1.getBalance());
		
		}

}
