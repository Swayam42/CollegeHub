/*Write a program to create a Student class with the following attributes: name, 
rollNumber, and age. The rollNumber should be designed to accept both integers and 
strings. Additionally, implement a driver class to create Student objects and invoke 
relevant methods.
*/

package Assignment2_1;
class Student<T>{
	
	String name;
	T rollNumber;
	int age;
	
	Student(String name,T rollNumber,int age){
		this.name=name;
		this.rollNumber=rollNumber;
		this.age=age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public T getRollNumber() {
		return rollNumber;
	}

	public void setRollNumber(T rollNumber) {
		this.rollNumber = rollNumber;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public String toString() {
		return "\nName : "+getName()+"\nRoll No. : "+getRollNumber()+"\nAge : "+getAge();
	}
	
}
public class Q1{
	
	public static void main(String[] args) {
		Student <Integer> s1= new Student<>("Ramu Kaka",34,65);
		Student <String> s2= new Student<>("Shyamu Kaka","23",65);
		System.out.println(s1.toString());
		System.out.println(s2.toString());

	}

}

/*
OUTPUT
Name : Ramu Kaka
Roll No. : 34
Age : 65

Name : Shyamu Kaka
Roll No. : 23
Age : 65

*/
