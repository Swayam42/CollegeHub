package Assignment_7;
/*Write a Java program that demonstrates the concept of a function returning another 
function using Java’s Function interface. Define a method that returns a lambda 
function that takes an integer as input and returns its square. In the main method, 
retrieve the returned function and use it to calculate and display the squares of different 
numbers.*/
import java.util.function.Function;

public class Q05 {
	public static Function<Integer,Integer> square(){
		return (x) ->x*x;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Function<Integer,Integer>ref =square();
		System.out.println("Square : "+ref.apply(4));
	}

}
