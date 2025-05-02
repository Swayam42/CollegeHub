package Assignment_7;
/*Create a functional interface Shape with a method double area() and a default method 
void printArea(). Implement the interface using lambda expressions for different 
shapes. Define the Shape functional interface with an area method. Implement the 
interface for shapes like circle, square, and rectangle using lambda expressions. Use the 
default method to print the area of each shape. */

interface Shape{
	double area();
	default void printArea() {
		System.out.println("Area : "+area());
	}
}
public class Q04 {
	public static void main(String[] args) {
		int r=5;
		Shape circle=()->3.14*r*r;
		circle.printArea();
		int l=34,b=12;
		Shape rectangle=()->l*b;
		rectangle.printArea();
	}
}
