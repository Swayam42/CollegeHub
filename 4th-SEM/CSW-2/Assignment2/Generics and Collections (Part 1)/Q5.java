/*Write a program to create a Student class with member variables name, rollNumber, 
and totalMark. The program should create an array of Student objects and sort them 
using the Bubble Sort algorithm based on their roll numbers.
Note: Implement the Comparable interface and override the compareTo() method for 
comparison
*/
package Assignment2_1;
class Student2 implements Comparable<Student2>{
	String name;
	int rollNumber;
	int totalMark;
	public Student2(String name, int rollNumber, int totalMark) {
		
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
	public int compareTo(Student2 s) {
		if(this.rollNumber==s.rollNumber) {
			return 0;
		}else if(this.rollNumber>s.rollNumber){
			return 1;
		}else {
			return -1;
		}
	}
	
	public String toString() {
		return "\nName :"+getName()+"\nRoll Number : "+getRollNumber()+"\nTotal Marks : "+getTotalMark();
	}
	
	void bubbleSort(int arr[])
    {
        int n = arr.length;
      
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (arr[j] > arr[j + 1]) {
                  
                    // swap temp and arr[i]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
    }
	
}
public class Q5 {
	
	public static void main(String[] args) {
		Student2 s1=new Student2("Adu",4,99);
		Student2 s2=new Student2("Kadu",2,78);
		Student2 s3=new Student2("Chattu",1,56);
		Student2 s[]={s1,s2,s3};
		Student2 s4=new Student2("Banar",4,56);

		for(int i=0;i<s.length-1;i++) {
			for(int j=0;j<s.length-i-1;j++) {
				if(s[j].compareTo(s[j+1])==1) {
					int temp=s[j].getRollNumber();
					s[j].setRollNumber(s[j+1].getRollNumber());
					s[j+1].setRollNumber(temp);
				}
			}
		}
		
		for(int i=0;i<s.length;i++) {
			System.out.print(s[i].getName()+" ");
		}
	}
}
