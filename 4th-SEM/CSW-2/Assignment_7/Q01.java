package Assignment_7;
/*You are required to create a Java program that uses a functional interface to process 
strings. Define a functional interface named StringProcessor with a method that takes 
a string as input and returns an integer. Within the main method of a class, use a 
lambda expression to implement this method such that it returns the length of the given 
string. */


interface stringProcessor{
	int findLength(String str);
}
public class Q01 {

	public static void main(String[] args) {
		String s="Hello";
		stringProcessor ref=(str)->str.length();
		System.out.println("Length of "+s+" : "+ref.findLength(s));
		
	}

}
 //Length of Hello : 5
