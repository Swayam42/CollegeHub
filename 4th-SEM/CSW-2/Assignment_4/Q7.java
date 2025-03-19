package Assignment_4;
/*Create a Java program for university student enrollment using a Student class to 
manage course details and student information. Implement efficient garbage collection 
for memory management and use the Runtime class to monitor memory usage. 
Override the finalize() method to print a message upon successful garbage collection.*/
class Student{
	
	String name;
	int redgNo;
	String course;
	
	public Student(String name, int redgNo, String course) {
		this.name = name;
		this.redgNo = redgNo;
		this.course = course;
	}
	
	@Override
	protected void finalize()throws Throwable{
		System.out.println("Object "+name+" Garbage Collected");
	}
}


public class Q7{

	public static void main(String[] args) {
		Student s1=new Student("Rahu",314,"BTech");
		Student s2=new Student("Ketu",576,"MBA");
		
		long x=Runtime.getRuntime().totalMemory();
		long y=Runtime.getRuntime().freeMemory();
		long z=x-y;
		System.out.println("Intial Total Memory : "+x);
		System.out.println("Intial Free Memory : "+y);
		System.out.println("Intial Used Memory : "+z);
		s1=null;
		s2=null;
		System.gc();
		long a=Runtime.getRuntime().totalMemory();
		long b=Runtime.getRuntime().freeMemory();
		long c=a-b;
		System.out.println("\nFinal Total Memory : "+a);
		System.out.println("Final Free Memory : "+b);
		System.out.println("Final Used Memory : "+c);
	}

}
/*
OUTPUT :
Intial Total Memory : 132120576
Intial Free Memory : 126603000
Intial Used Memory : 5517576

Final Total Memory : 10485760
Final Free Memory : 9018288
Final Used Memory : 1467472

*/
