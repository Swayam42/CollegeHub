
/*Demonstrate the use of a nested try-catch block. Write a Java program where the outer 
try-catch block handles a NumberFormatException, while the inner try-catch block 
handles an ArithmeticException. */
package Assignment_3;
public class Q5 {

	public static void main(String[] args) {
		try{
			String s="10.5";
			int x=Integer.parseInt(s);
			System.out.println(x); 
			
			try{
				System.out.println(3/0);
			}
			catch(ArithmeticException e){
				System.out.println(e);
			}
		}
		
		catch(NumberFormatException e) {
			System.out.println(e);
		}

	}

}

/*
OUTPUT :
java.lang.NumberFormatException: For input string: "10.5"
*/
