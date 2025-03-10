package Error_Handling;
import java.util.Scanner;
public class Examples{
	public static void Arithmetic() {
		Scanner sc=new Scanner(System.in);
		System.out.print("Input X: ");
		int x=sc.nextInt();
		System.out.print("Input Y: ");
		int y=sc.nextInt();
		try{
			int res=x/y;
			System.out.println(res);
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
	
	public static void NullPointer() {
		try {
			String s=null;
			System.out.println(s.length());
		}
		catch(NullPointerException n) {
			System.out.println(n);
		}
		
	}
	
	//NumberFormatException
	public static void NumberFormat() {
		try {
			double d=10.5;
			String s="10.5";
			int x=Integer.parseInt(s);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	//ArrayIndexOutOfBoundException
	
	public static void ArrayIndexOutOfBound() {
		int arr[]= {1,2,3,4,5};
		try {
			System.out.println(arr[5]);
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void InputMismatch() {
		
	}
	public static void main(String[] args) {
		//Arithmetic();
		//NullPointer();
		//NumberFormat();
		ArrayIndexOutOfBound();
	}
}
