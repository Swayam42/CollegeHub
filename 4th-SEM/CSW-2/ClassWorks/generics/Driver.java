package generics;

class Student<T>{
	private String name;
	private int age;
	private T rollNo;
	
	Student(String name,int age,T rollNo){
		this.name=name;
		this.age=age;
		this.rollNo=rollNo;
	}
	
	public T getRollNo() {
		return rollNo;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	
	public String displayDetails() {
		return "\nName :"+getName()+"\nRoll No : "+getRollNo()+"\nAge : "+getAge();
	}
	
}

public class Driver {

	public static void main(String[] args) {
		Student<String> s1=new Student<>("Hathi",34,"54");
		System.out.println("Roll No as String");
		System.out.println(s1.displayDetails());
		Student<Integer> s2=new Student<>("Ghoda",67,12);
		System.out.println("\nRoll No as Integer");
		System.out.println(s2.displayDetails());
		

	}

}
