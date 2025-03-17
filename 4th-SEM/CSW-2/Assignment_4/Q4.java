package Assignment_4;
/*Create a Java program to demonstrate anonymous objects and garbage collection using 
the AnonymousObject class. The class should have a constructor to initialize an object 
with a name. In the main() method, create an anonymous object and explicitly invoke 
the garbage collector. Override the finalize() method to print the object's name upon 
successful garbage collection. */
class AnonymousObject{
	String name;
	public AnonymousObject(String name) {
		this.name=name;
	}
	protected void finalize() throws Throwable{
		System.out.println("Object "+name+" is Garbage Collected");
	}
	
}

public class Q4 {
	
	public static void main(String[] args) {
	new AnonymousObject("fd");
	System.gc();
	
	}
}
