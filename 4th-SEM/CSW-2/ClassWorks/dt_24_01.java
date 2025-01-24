package csw2;
import java.util.Scanner;
 class Person{
	 	String name;
		int age;
		float marks;
		String branch;
	 
	 public Person(){
		Scanner sc=new Scanner(System.in);
		System.out.println("Input Details : ");
		System.out.print("Input Name :");
		this.name=sc.nextLine();
		System.out.print("Input Age :");
		this.age=sc.nextInt();
		System.out.print("Input Branch :");
		this.branch=sc.next();
		sc.close();
	}
		
		public void display() {
			System.out.println("\nName : "+name+"\nAge :"+age+"\nMarks: "+marks);
		}
		
		public void showBranch(){
		 System.out.println("branch : "+branch);
		}
		
}
 
 class Student extends Person{
	 String School;
	 public Student(String name,int age,String school) {
		 super();
		 this.School=school;
	 }
 }
 
 class Bike{
	 String brand;
	 int mileage;
	 String color;
	 int torque;
	 
	 public Bike(String b,int m,String c,int t) {
		 this.brand=b;
		 this.mileage=m;
		 this.color=c; 
		 this.torque=t;
	 }
	 
	 public void displayBike() {
		 System.out.println("Brand : "+brand+"\nColor : "+color+"\nMileage : "+ mileage +"\nTorque : "+torque);
	 }
 }
 


public class dt_24_01 {

	
	public static void main(String[] args) {
	
		
		//p1.display();
		//p1.showBranch();
		Bike c1=new Bike("abc",32,"kalu",300);
		c1.displayBike();

	}

}
