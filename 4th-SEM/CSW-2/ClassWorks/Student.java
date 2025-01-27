package csw2;

public class Student {
	private String name;
	private int age;
	private double marks;
	//setter method :
	
	public void setName(String name) {
		this.name=name;
	}
	
	public static void main(String[] args) {
		Student s1=new Student();
		s1.setName("jrj");

	}

}
