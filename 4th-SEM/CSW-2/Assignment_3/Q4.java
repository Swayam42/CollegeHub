/*Write a Java program to find the square root of an integer number. Demonstrate the use 
of a try-catch block to handle ArithmeticException. */
package Assignment_3;

public class Q4 {
	public static void checkNum(int n) throws ArithmeticException{
		if(n<1) {
			throw new ArithmeticException("No. is -ve");
		}else {
			System.out.println("Sq Root of "+n+" = "+(float)Math.sqrt(n));
		}
	}

	public static void main(String[] args) {
		try {
			checkNum(-3);
		}catch(ArithmeticException e) {
			System.out.println(e);
		}

	}

}
/*
OUTPUT :
java.lang.ArithmeticException: No. is -ve
*/
