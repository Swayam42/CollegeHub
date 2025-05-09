package Assignment_8;
/*Write a Java program to demonstrate performing multiple tasks concurrently using 
multiple threads.  
Create two separate thread classes: 
• The first thread should calculate and print the sum of the first 100 natural 
numbers. 
• The second thread should display the multiplication table of a given number  
Start both threads from the main() method and show that the tasks run 
concurrently.*/

class SumThread extends Thread{
	public void run(){
		try{
			int i=1,res=0;
			 while(i<101) {
				 res+=i;
				 i++;
			 }
			 System.out.println("Sum of first 100 Natural Numbers : "+res);
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}

class MultiplicationThread extends Thread{
	int param;
	public MultiplicationThread (int param) {
		this.param=param;
	}
	
	public void run(){
		try {
			
			for(int i=1;i<=10;i++) {
				System.out.println(param+" x "+i+" = "+param*i);
		 }
		 
	}
	catch(Exception e){
		System.out.println(e);
	}
	}
}
public class Q1 {

	public static void main(String[] args) {
		SumThread sum=new SumThread();
		MultiplicationThread mul=new MultiplicationThread(6);
		sum.start();
		mul.start();
		MultiplicationThread s400=new MultiplicationThread(12);
		s400.start();

	}

}
