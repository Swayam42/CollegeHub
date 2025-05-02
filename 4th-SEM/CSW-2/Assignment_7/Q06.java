package Assignment_7;
/*Write a Java program that demonstrates the use of a lambda expression with the 
Function functional interface to calculate the factorial of a number. Define a method 
that returns a lambda expression that takes an integer as input and computes its 
factorial using an iterative approach. In the main method, use this lambda expression 
to calculate and display the factorial of a given number. */
import java.util.function.Function;
public class Q06 {
	public static Function<Integer,Integer> factorial(){
		
		return (x)->{
			int res=1;
			for(int i=1;i<=x;i++) {
				res*=i;
			}
			return res;
		};
}

	public static void main(String[] args) {
		Function<Integer,Integer> ref=factorial();
		System.out.println("Factorial : "+ref.apply(5));
	}

}
