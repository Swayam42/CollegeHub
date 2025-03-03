/*Write a program to create an Animal class with member variables name, color, and 
type (indicating whether the animal is a pet or wild). Override the hashCode() method 
to generate a unique identifier for each object. Then, create multiple Animal objects 
and print their hash codes. */

package Assignment2_1;
import java.util.*;
class Animal{
	private String name;
	private String color;
	private String type;
	public Animal(String name, String color, String type) {
		
		this.name = name;
		this.color = color;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int hashCode() {
        Scanner sc=new Scanner(System.in);
        System.out.println("Input Code : ");
		return sc.nextInt()*31;
        
    }
	public String toString() {
		return "Animal Name : "+getName()+" Color : "+getColor()+" Type : "+getType();
	}
	
}
public class Q6 {
public static void main(String[] args) {
	Animal a1 = new Animal("Dog","white","Pet");
    Animal a2 = new Animal("Lion","Yellow","Wild");
    Animal a3 = new Animal("Cat","Black","Pet");
    System.out.println("Hash Code of " + a1.getName() + ": " + a1.hashCode());
    System.out.println("Hash Code of " + a2.getName() + ": " + a2.hashCode());
    System.out.println("Hash Code of " + a3.getName() + ": " + a3.hashCode());	
}
}
/*
OUTPUT :
Input Code : 1
Hash Code of Dog: 31
Input Code : 2
Hash Code of Lion: 62
Input Code : 3
Hash Code of Cat: 93

*/
