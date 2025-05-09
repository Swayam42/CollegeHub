package Assignment_8;
/*Write a Java program to create a simple calculator that performs arithmetic operations 
(addition, subtraction, multiplication, division) using multiple threads. Each 
arithmetic operation should be handled by a separate thread */
import java.util.Scanner;
class Addition extends Thread{
	
	int a,b;
	public Addition(int a, int b){
		this.a = a;
		this.b = b;
	}
	public void run(){
		try {
			System.out.println(a+b);
		 }
		catch(Exception e){
			System.out.println(e);
		}
		 
	}
	
}

class Subtraction extends Thread{
	int a,b;
	public Subtraction(int a, int b){
		this.a = a;
		this.b = b;
	}
	public void run(){
		try {
			
			for(int i=1;i<=10;i++) {
				System.out.println();
		 }
		 
	}
	catch(Exception e){
		System.out.println(e);
	}
	}
}

class Multiplication extends Thread{
	int a,b;
	public Multiplication(int a, int b){
		this.a = a;
		this.b = b;
	}
	public void run(){
		try {
			System.out.println(a*b);
		 }
		catch(Exception e){
				System.out.println(e);
			}
		 
	}
	
}

class Division extends Thread{
	int a,b;
	public Division(int a, int b){
		this.a = a;
		this.b = b;
	}
	public void run(){
		try {
			System.out.println(a/b);
		 }
		catch(Exception e){
				System.out.println(e);
			}
		 
	}
	
}


public class Q2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("----Calculator----");
			System.out.println("1.Addition");
			System.out.println("2.Subtraction");
			System.out.println("3.Division");
			System.out.println("4.Multiplication");
			System.out.println("5.Exit");
			System.out.print("Input Choice : ");
			int c=sc.nextInt();
			 if (!sc.hasNextInt()) {
	                System.out.println("Invalid input. Please enter a number.");
	                sc.next();
	                continue;
	            }
	            
			System.out.println("Input 2 Numbers : ");
			int a=sc.nextInt();
			int b=sc.nextInt();
			sc.next();
		
		switch(c) {
		case 1:
			Addition add=new Addition(a,b);
			add.start();
		case 2:
			Subtraction sub=new Subtraction(a,b);
			sub.start();
		case 3:
			Multiplication mul=new Multiplication(a,b);
			mul.start();
		case 4:
			Division div=new Division(a,b);
			div.start();
		case 5:
			System.out.println("Exiting....");
			sc.close();
			
		}
		}

	}

}
