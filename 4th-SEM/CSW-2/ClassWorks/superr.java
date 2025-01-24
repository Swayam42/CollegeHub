package csw2;

class Loka{
 	String name;
	int age;
 
 public Loka(String name,int age){
	
	
	this.name=name;
	
	this.age=age;
	
}
	
	public void display() {
		System.out.println("\nName : "+name+"\nAge :"+age);
	}
	
	
}
class balak extends Loka{
	String school;
	public balak(String name,int age,String school) {
		super(name,age);
		this.school=school;
	}
	public void display() {
		super.display();
		System.out.println("School : "+school);
	}
}

public class superr {

	public static void main(String[] args) {
		balak s1=new balak("mk",9,"j");
		s1.display();

	}

}
