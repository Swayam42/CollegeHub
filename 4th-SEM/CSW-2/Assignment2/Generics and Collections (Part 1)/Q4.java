package Assignment_2.Part_1;
/*Write a program to create a Student class with member variables name, rollNumber, 
and totalMark. The program should allow the creation of an array of Student objects 
and implement a linear search to find a specific student in the array. Additionally, the 
Student class should implement the Comparable interface by overriding the 
compareTo() method to facilitate comparisons between student objects.  */

class Student implements Comparable<Student> {
    private String name;
    private int rollNumber;
    private int totalMark;

    public Student(String name, int rollNumber, int totalMark) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.totalMark = totalMark;
    }

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public int getTotalMark() {
        return totalMark;
    }

    @Override
    public int compareTo(Student1 s) {
        if(this.getRollNumber()==s.rollNumber){
			return 0;
		}else{
			return -1;
		}
    }

    @Override
    public String toString() {
        return "\nName: " + name + "\nRoll Number: " + rollNumber + "\nTotal Marks: " + totalMark;
    }
}

public class Q4 {
    public static void main(String[] args) {
        Student[] s = {
            new Student("Adu", 1, 99),
            new Student("Kadu", 2, 78),
            new Student("Chattu", 3, a56)
        };

        Student targetStudent = new Student("Banar", 4, 56);
        
        boolean found = false;
        
        // Linear Search
        for (Student student : s) {
            if (student.compareTo(targetStudent) == 0) {
                System.out.println("Student found:");
                System.out.println(student);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student Not Found");
        }
    }
}

/*Output
Student Not Found
*/
