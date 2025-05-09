package ClassWorks.MultiThreading;
class AO extends Thread{
	int a,b;
	String op;
	public AO (ThreadGroup group,String name,int a,int b,String op) {
		super(group,name);
		this.a=a;
		this.b=b;
		this.op=op;
	}
	
	@Override
	public void run() {
		try {
			switch(op) {
				case "add":
					System.out.println("Addition : "+(a+b));
					break;
				case "sub":
					System.out.println("Subtraction : "+(a-b));
					break;
				case "mul":
					System.out.println("Multiplication : "+(a*b));
					break;
				case "div":
					System.out.println("Division : "+(a/b));
					break;
				
				default:
					System.out.println("Invalid Input");
					
				
			}
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
public class test1 {

	public static void main(String[] args) {
		int a=10,b=2;
		ThreadGroup ob=new ThreadGroup("calApp");
		Thread t1=new AO(ob, "add", a, b, "add");
		t1.start();
	}

}
