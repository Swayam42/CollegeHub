/*Create a method that accepts a string input and converts it into an integer. Use a try
catch block to handle NumberFormatException, and if an exception occurs, prompt 
the user to enter a valid numeric value.*/
package Assignment_3;
import java.util.*;
public class Q3 {
	public static void fun() {
		Scanner sc=new Scanner(System.in);
		System.out.print("Input String :");
		String s=sc.next();
		int x=Integer.parseInt(s);
		System.out.println(x);
	}
	public static void main(String[] args) {
		try {
			fun();
		}
		catch(NumberFormatException e) {
			System.out.println("Enter a valid Numeric Value");
			fun();
		}

	}

}
/*
OUTPUT :
Input String :ghjg76
Enter a valid Numeric Value
Input String :6786
6786
*/
