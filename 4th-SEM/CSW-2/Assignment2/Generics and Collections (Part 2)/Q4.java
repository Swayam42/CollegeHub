package Assignment2_2;
/*Create a Student class with member variables name, age, and mark, along with the 
necessary getter and setter methods. Implement a LinkedList of Student objects and 
perform the following operations: 
(a) Display the list of students. 
(b) Prompt the user to enter a Student object and check its existence in the list. Specify 
whether the search is based on reference comparison or content comparison using the 
L3, L4 
 
contains method. 
(c) Remove a specified Student object from the list. 
(d) Count the number of Student objects present in the list. 
(e) Override the equals method to compare two Student objects based on their values 
rather than references.*/
import java.util.*;
class Student{
	private String name;
	private int age;
	private int mark;
	
	public Student(String name, int age, int mark) {
		this.name = name;
		this.age = age;
		this.mark = mark;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	public String toString() {
		return "Name : "+getName()+" Age : "+getAge()+" Mark : "+getMark();
	}
	// Override the equals method to compare two Student objects based on their values rather than references.
	public boolean equals(Object o) {
		Student s1=(Student)o;
		return this.name.equals(s1.getName())&&this.age==s1.getAge();	
	}
	

}

public class Q4 {

	public static void main(String[] args) {
		LinkedList<Student> l1=new LinkedList<>();
		l1.add(new Student("Dosa",23,400));
		l1.add(new Student("Idli",18,450));
		l1.add(new Student("Sambar",20,300));
		
		//Displaying the list of students 
		for(Student i:l1) {
			System.out.println(i);
		}
		/* Prompt the user to enter a Student object and check its existence in the list. Specify 
		whether the search is based on reference comparison or content comparison using the 
		contains method.*/ 
		Scanner sc=new Scanner(System.in);
		System.out.print("Input Student Details(Name,Age,Marks) :");
		Student search=new Student(sc.next(),sc.nextInt(),sc.nextInt());
		boolean found=false;
		for(Student i:l1) {
			if(l1.contains(search)) {
				found=true;
			}
		}
		if(found==true) {
			System.out.println("Student found");
		}else {
			System.out.println("Student Not Found");
		}
		
		//Remove a specified Student object from the list
		l1.remove(2);
		//count the no. of Student objects present in the list
		System.out.println(l1.size());
		
	}

}
