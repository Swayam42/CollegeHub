package Assignment_4;
/*Write a Java program to demonstrate garbage collection using an UnreachableObject 
class. It should include a constructor to initialize an object with a given name, a show() 
method creating an instance and invoking display(), and the display() method creating 
another instance. The main() method should call show() and explicitly invoke the 
garbage collector. The program must override the finalize() method to print the object's 
name upon successful garbage collection, illustrating how unreachable objects are 
collected.*/
class UnreachableObject{
	String name;
	public UnreachableObject(String name) {
		this.name=name;
		System.out.println("Object "+name+" is created");
	}
	
	public void display() {
		UnreachableObject ob1=new UnreachableObject("Suresh"); 
	}
	
	public void show() {
		UnreachableObject ob2=new UnreachableObject("Ramesh"); 
		display();
	}
	
	@Override
	protected void finalize()throws Throwable{
		System.out.println("Object "+name+" is Garbage Collected");
	}
	
	
}
public class Q1 {

	public static void main(String[] args) {
		UnreachableObject ob=new UnreachableObject("Main");
		ob.show();
		ob=null; //nullifying the reference Obj 
		System.gc(); //Requesting JVM to run Garbage Collector

	}

}
/*
OUTPUT :
Object Main is created
Object Ramesh is created
Object Suresh is created
Object Main is Garbage Collected
Object Suresh is Garbage Collected
Object Ramesh is Garbage Collected

Note: The exact output of the garbage collection messages may vary depending on when the 
garbage collector runs and which objects it decides to collect first. 
The order of garbage collection messages is not guaranteed.
*/
