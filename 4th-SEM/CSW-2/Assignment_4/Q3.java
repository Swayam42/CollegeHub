package Assignment_4;
/*Write a Java program to demonstrate nullification of references and garbage collection 
using the NullifiedReference class. The class should have a constructor to initialize an 
object with a given name. In the main() method, create an instance of 
NullifiedReference, assign it, then nullify the reference, and explicitly invoke the 
garbage collector. Override the finalize() method to print the object's name upon 
successful garbage collection.*/

class NullifiedReference{
    String name;
    public NullifiedReference(String name){
        this.name=name;
        System.out.println("Object "+name+" created");
    }
	@Override
	protected void finalize() throws Throwable {
		System.out.println("Object "+name+" is Garbage Collected");
	}

}
public class Q3 {
    public static void main(String[] args) {
            NullifiedReference ob1=new NullifiedReference("Ankit");
            ob1=null;
            System.gc();
         
    }
}
/*
OUTPUT :
Object Ankit created
Object Ankit is Garbage Collected
*/
