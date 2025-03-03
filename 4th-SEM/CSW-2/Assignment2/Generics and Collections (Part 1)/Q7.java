/*Write a program to create a Student class with member variables name, rollNo, and 
age. The program should allow the creation of an array of Student objects and 
implement sorting based on rollNo and age in the driver class. The sorted student 
arrays should be printed separately. Additionally, the program should utilize the 
Comparator interface by overriding the compare() method to enable custom 
comparisons for sorting. */

package Assignment2_1;
import java.util.Arrays;
import java.util.Comparator;

class Student {
    
    String name;
    int rollNo;
    int age;

    public Student(String name, int rollNo, int age) {
        this.name = name;
        this.rollNo = rollNo;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +"name='" + name + '\'' +", rollNo=" + rollNo +", age=" + age +'}';
    }
}

public class Q7 {

    public static void main(String[] args) {
        Student[] students = {
            new Student("Alice", 3, 20),
            new Student("Bob", 1, 22),
            new Student("Charlie", 2, 19),
  
        };
        Arrays.sort(students, new Comparator<Student3>() {
            @Override
            public int compare(Student3 s1, Student3 s2) {
                return Integer.compare(s1.rollNo, s2.rollNo);
            }
        });
        System.out.println("Sorted by Roll Number:");
        for (Student student : students) {
            System.out.println(student);
        }

        System.out.println();
        Arrays.sort(students, new Comparator<Student>() {
            @Override
            public int compare(Student s1, Student s2) {
                return Integer.compare(s1.age, s2.age);
            }
        });
        System.out.println("Sorted by Age:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}

/*
OUTPUT :
Sorted by Roll Number:
Student{name='Bob', rollNo=1, age=22}
Student{name='Charlie', rollNo=2, age=19}
Student{name='Alice', rollNo=3, age=20}

Sorted by Age:
Student{name='Charlie', rollNo=2, age=19}
Student{name='Alice', rollNo=3, age=20}
Student{name='Bob', rollNo=1, age=22}

*/
