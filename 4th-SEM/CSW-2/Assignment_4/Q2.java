package Assignment_4;
/*Develop a Java program to demonstrate reference reassignment and garbage collection 
using the ReassigningReference class. The class should have a constructor to initialize 
an object with a given name. In the main() method, create two instances of 
ReassigningReference, reassign one reference to another, and then explicitly invoke 
the garbage collector. Override the finalize() method to print the object's name upon 
successful garbage collection.*/
class ReassigningReference {
	String name;
	public ReassigningReference(String name) {
		this.name=name;
		System.out.println("Object "+name+" created");
	}
	public void display() {
		System.out.println("Hello Object "+name);
	}
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Object "+name+" is Garbage Collected");
	}
}

public class Q2 {

	public static void main(String[] args) {
		ReassigningReference ob1=new ReassigningReference("Pinky");
		ReassigningReference ob2=new ReassigningReference("Uttam");
		ob1=ob2;
		System.gc();
		ob1.display();
		ob2.display();

	}

}
/*
OUTPUT :
Object Pinky created
Object Uttam created
Object Pinky is Garbage Collected
Hello Object Uttam
Hello Object Uttam
*/
