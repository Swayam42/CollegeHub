package ClassWorks.MultiThreading;


class BankAccount {
	double balance=1000;
	public synchronized void  deposit(int amt){
		System.out.println(amt+ " deposited");
		balance+=amt;
		System.out.println("Avl Bal : "+(balance));
	}
	public synchronized void withdraw(int amt) {
		if(!(amt>balance)) {
			balance-=amt;
			System.out.println("Amt Withdrawn : "+(amt));
		}else {
			System.out.println("Insufficient Balance");
		}
	}
	public double getBalance() {
		return balance;
	}
}
public class test2 {

	public static void main(String[] args) {
		BankAccount sbi=new BankAccount();
		Thread t1= new Thread(()->{
			for(int i=0;i<3;i++) {
				sbi.deposit(800);
			}
			try {
				Thread.sleep(50); //Stimulating some delay
			}catch(InterruptedException e) {
				System.out.println(e);
			}
		
		});
		
		Thread t2= new Thread(()->{
			for(int i=0;i<3;i++) {
				sbi.withdraw(100);
			}
			try {
				Thread.sleep(100); //Stimulating some delay
			}catch(InterruptedException e) {
				System.out.println(e);
			}
		
		});
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		}
		catch(InterruptedException e) {
			System.out.println(e);
		}
		System.out.println("Balance : "+sbi.getBalance());
	}

}
