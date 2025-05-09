package Assignment_8;
/*Rewrite the multithreading calculator program from Q1 using lambda expressions. 
Each arithmetic operation (addition, subtraction, multiplication, division) should still 
be handled by a separate thread, but this time, define the behavior of each thread using 
Java lambda expressions.*/

@FunctionalInterface
interface Operation {
    void operate(int a, int b);
}


public class Q3{

	public static void main(String[] args) {
		Operation add=(a,b)->System.out.println("Addition : "+(a+b));
		Operation sub=(a,b)->System.out.println("Subtraction : "+(a-b));
		Operation mul=(a,b)->System.out.println("Multiplication : "+(a*b));
		Operation div=(a,b)->System.out.println("Division : "+(double)(a/b));
		int x=23,y=45;
		 Thread addThread = new Thread(() -> add.operate(x,y));
	     Thread subThread = new Thread(() -> sub.operate(x,y));
	     Thread mulThread = new Thread(() -> mul.operate(x,y));
	     Thread divThread = new Thread(() -> div.operate(x,y));
		addThread.start();
		subThread.start();
		mulThread.start();
		divThread.start();
	}

}
