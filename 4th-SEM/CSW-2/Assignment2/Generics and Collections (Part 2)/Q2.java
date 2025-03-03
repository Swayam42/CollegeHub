/*Write a Java program that includes a User class and an ArrayListUser class. The User 
class should have private fields for name and age, along with a parameterized 
constructor and getter/setter methods for these attributes. The ArrayListUser class 
should create an ArrayList of User objects. After adding user objects, it should 
retrieve and print their name and age. Additionally, the program should sort the users 
based on age and print the updated list of users using getter methods.*/
import java.util.*;	
class User implements Comparable<User>{
	private String name;
	private int age;
	public User(String name, int age) {
		this.name = name;
		this.age = age;
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
	public String toString() {
		return "Name :"+getName()+", Age: "+getAge();
	}
	
	public int compareTo(User o) {
		if(this.age==o.age) {
			return 0;
		}else if(this.age>o.age) {
			return 1;
		}else {
			return -1;
		}
	}
	
	
	}
	
public class ArrayListUser {

	public static void main(String[] args) {
		ArrayList<User>al=new ArrayList<>();
		al.add(new User("Sahoo Babu",23));
		al.add(new User("Mishra Babu",17));
		al.add(new User("Chuna Baba",56));
		
		for(User i:al) {
			System.out.println(i);
		}
		
		//Sorting users based on age :
		Collections.sort(al);
		System.out.println("\nSorting Users based on Age : \n");
		for(User i:al) {
			System.out.println(i);
		}
		
		
}

}
/*
Output :
Name :Sahoo Babu, Age: 23
Name :Mishra Babu, Age: 17
Name :Chuna Baba, Age: 56

Sorting Users based on Age : 

Name :Mishra Babu, Age: 17
Name :Sahoo Babu, Age: 23
Name :Chuna Baba, Age: 56
*/
