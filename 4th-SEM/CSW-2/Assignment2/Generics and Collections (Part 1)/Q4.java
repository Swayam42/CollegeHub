/*Write a program to create a Student class with member variables name, rollNumber, 
and totalMark. The program should allow the creation of an array of Student objects 
and implement a linear search to find a specific student in the array. Additionally, the 
Student class should implement the Comparable interface by overriding the 
compareTo() method to facilitate comparisons between student objects.
*/

package Assignment2_1;

class Student1 implements Comparable<Student1>{
	String name;
	int rollNumber;
	int totalMark;
	public Student1(String name, int rollNumber, int totalMark) {
		
		this.name = name;
		this.rollNumber = rollNumber;
		this.totalMark = totalMark;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRollNumber() {
		return rollNumber;
	}
	public void setRollNumber(int rollNumber) {
		this.rollNumber = rollNumber;
	}
	public int getTotalMark() {
		return totalMark;
	}
	public void setTotalMark(int totalMark) {
		this.totalMark = totalMark;
	}
	@Override
	public int compareTo(Student1 s) {
		if(this.rollNumber==s.rollNumber) {
			return 1;
		}else {
			return -1;
		}
	}
	
	public String toString() {
		return "\nName :"+getName()+"\nRoll Number : "+getRollNumber()+"\nTotal Marks : "+getTotalMark();
	}
	
	
	
}
public class Q4 {
	
	public static void main(String[] args) {
		
		Student1 s1=new Student1("Adu",1,99);
		Student1 s2=new Student1("Kadu",2,78);
		Student1 s3=new Student1("Chattu",3,56);
		Student1 s[]={s1,s2,s3};
		Student1 s4=new Student1("Banar",4,56);

		for(int i=0;i<s.length;i++) {
			if(s[i].compareTo(s4)==1){
				System.out.println("Student found : ");
				System.out.println(s[i].toString());
				break;
			}else {
				System.out.println("Student Not Found");
				break;
			}
		}
		

		
	}

	
}
/*Output
Student Not Found
*/
