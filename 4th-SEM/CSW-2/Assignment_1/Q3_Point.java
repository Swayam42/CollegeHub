/*
 Write a Java program that defines a Point class with attributes X and Y, and includes a 
parameterized constructor to initialize these attributes. Implement a copy 
constructor to create a new point object with the same attribute values. Ensure that 
modifications made to one object do not affect the other. Utilize getter and setter 
methods to retrieve and update the attribute values.
 */
package Assignment_1;
import java.util.*;
class Point{
	

	int x;
	int y;
	
	public Point(int x,int y) {
		this.x=x;
		this.y=y;
	}
	
	//copy constructor
	Point(Point p){
		x=p.x;
		y=p.y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x=x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public String toString() {
		return x +","+y;
	}
	
	public int distance(Point p1,Point p2) {
		
		int d= (int)(Math.sqrt(Math.pow((p2.getX()-p1.getX()),2)+Math.pow(p2.getY()-p1.getY(),2)));
		return d;
	}
	
	
	
	
}
public class Q3 {

	public static void main(String[] args) {
		Point p1 =new Point(10,15);
		System.out.println("Point p1 : "+p1.toString());
		Point p2=new Point(p1);
		System.out.println("Point p2 : "+p2.toString());
		
		Point p3=new Point(5,7);
		System.out.println("\nPoint p3 : "+p3.toString());
		Point p4=new Point(8,4);
		System.out.println("Point p4 : "+p4.toString());
		
		int d=p1.distance(p3,p4);
		System.out.println("Distance betn p3 and p4 : "+d);

		
	}
	
}

/*
 OUTPUT 
Point p1 : 10,15
Point p2 : 10,15

Point p3 : 5,7
Point p4 : 8,4
Distance betn p3 and p4 : 4
 */
