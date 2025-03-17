class Error_Propagation{
	public void m() {
		int data=50/0;
	}
	public void n() {
		m();
	}
	public void p() {
		n();
	}
	
}

public class test {
	
	public static void main(String[] args) {
	Error_Propagation ob=new Error_Propagation();
	try {
		ob.p();
	}catch(ArithmeticException e) {
		System.out.println("Handled :"+e);
		e.printStackTrace();
	}
	System.out.println("Rest of code");

		
	}

}

//throws keyword used in method signature to indicate that method can throw any type of exception during execution
//Unchecked Exception :

class Eg1{
	public static void checkNum(int n) throws ArithmeticException{
		if(n<1) {
			throw new ArithmeticException("No. is -ve");
		}else {
			System.out.println("Sq Root of "+n+" = "+Math.sqrt(n));
		}
	}

public static void main(String[] args) {
		checkNum(-3);
	}
}


//Eg2 :

import java.io.*;

class Test123{
	public static void checkFile() throws FileNotFoundException{
		FileReader ob=new FileReader("abc.txt");
		throw new FileNotFoundException();
	}
        public static void main(String[] args) {
		
	try {
		checkFile();
		
	}
	catch(FileNotFoundException e) {
		System.out.println("Exception is Handled"+ e);
	}
 }

}
//Output : Exception is Handledjava.io.FileNotFoundException: abc.txt (The system cannot find the file specified)


//FileNotFoundException :

import java.io.*;

class Test123{
	public static void checkFile() throws FileNotFoundException{
		FileReader ob=new FileReader("C:\\Users\\HP\\OneDrive\\Desktop\\new CSW\\CSW_2\\src\\Error_Handling\\abc.txt");
		BufferedReader bf=new BufferedReader(ob);
	}
	public static void main(String[] args) {
	try {
		checkFile();
		System.out.println("File Found");
		
	}
	catch(FileNotFoundException e) {
		System.out.println("Exception is Handled"+ e);
	}
  }
	
}


/*  throw : checked exc
 *     		defined within the method
 *     		followed by an instance of an exception to be thrown
   		can only propagate unchecked exc
   throws: unchecked exc             
 		   defined with method signature
 		   followed by class name of exception to be thrown 
 		   can declare both checked and unchecked
 		   */

garbage collection is a process of reclaiming the runtime unused memory automatically 
it destroys the unreferenced/unused objects 

Java Memory Structure :
1.Heap : here the actual objects get stored 
	     : can be fixed or dynamic in size
Scanner sc=new Scanner(System.in)
the above statement creates the object of Scanner class which gets allocated in heap area
when we call function it gets into stack and pops after being executed
garbage collection is done in heap area
2.Method Area : allocated  for class Structures,methods,constructor and interfaces 
3.JVM Stacks : whenever a process or thread intermediate methods we use stack memory

HOW ARE JAVA OBJECTS STORED IN MEMORY :

public class Test {

	public static void main(String[] args) {
		Test ob1;   //ob1 is a reference object which is pointing to nothing
		ob1.show();

	}
	public void show() {
		System.out.println("Object Is Created");
	}

}
COMPILE TIME ERROR : 
test.java:7: error: variable ob1 might not have been initialized
                ob1.show();
                ^
1 error


3 WAYS TO MAKE AN OBJECT UNREFERENCED :
//i. By Nullifying an object : ob1=null
Eg :Ass4 Q1
when we call System.gc() method in the main() , it will automatically call the finalize()  ... then finalize() calls the JVM for garbage collection
protected void  finalize () throws Throwable{

}
System.gc() is used to invoke the garbage Collector to perform cleanUp processing\
It is found in System and RunTime classes
public static void gc(){

}
Garbage Collection is performed by a daemon thread called the Garbage Collector(GC) which indirectly calls the finalize() method
//ii. By assigning one object to another 
Eg : Ass Q2

