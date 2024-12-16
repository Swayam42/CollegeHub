package first_lect;
import java.util.Scanner;
public class Test {

	public void swap(int x,int y) {
		System.out.println("Before swap : x: "+x+" y: "+y);
		int temp=x;
		x=y;
		y=temp;
		System.out.println("\nAfter swap : x: "+x+" y: "+y);
	}
	
	public static void swapf(int x,int y) //x & y: formal parameters
	{
		System.out.println("Before swap : x: "+x+" y: "+y);
		int temp=x;
		x=y;
		y=temp;
		System.out.println("\nAfter swap : x: "+x+" y: "+y);
	}
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
	    System.out.print("Input x: ");
	    int x=sc.nextInt();
	    System.out.print("Input y: ");
	    int y=sc.nextInt();
	    System.out.println("Before swap : x: "+x+" y: "+y);
	    //without using function
	    int temp=x;
	    x=y;
	    y=temp;
	    System.out.println("After swap : x: "+x+" y: "+y);
	  
	    //calling static method 
	   swapf(45,76);
	   
	   //creating obj of class:
	   Test obj =new Test();
	   //calling the non-static method for obj s
	   obj.swap(67,7);
	   
	 
	  }

}
