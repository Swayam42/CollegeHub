/*Develop a Java-based College Management System to model the relationship between 
colleges and students. Create a College class with attributes collegeName and 
collegeLoc, and a Student class with studentId, studentName, and a reference to a 
College object. Implement a constructor in Student to initialize these attributes and a 
displayStudentInfo() method to print student and college details. In the MainApp class, 
instantiate at least two College and Student objects, enroll each student in one of 
the colleges, and display all details using appropriate methods.*/

class College{
    String collegeName;
    String collegeLoc;
   public College(String collegeName,String collegeLoc){
        this.collegeName=collegeName;
        this.collegeLoc=collegeLoc;
    }

    String getCollegeName(){
        return collegeName;
    }
    String getCollegeLoc(){
        return collegeLoc;
    }

}

class Student{
    int studentId;
    String studentName;
    College college; //Reference to College object

    public Student(int studentId,String studentName,College college){
        this.studentId = studentId;
        this.studentName = studentName;
        this.college = college;
    }

    void displayStudentInfo(){
        System.out.println("\nStudent ID : "+studentId);
        System.out.println("Student Name : "+studentName);
        System.out.println("College : "+college.getCollegeName()+"-"+college.getCollegeLoc());
    }

}

public class Q6_MainApp {
    public static void main(String[] args) {
        College c1=new College("IIT","Jagamara");
        College c2=new College("ITER","Bombay");
        Student s1=new Student(243,"Ramu Kaka",c1);
        Student s2=new Student(532,"Khandu Don",c2);

        s1.displayStudentInfo();
        s2.displayStudentInfo();
    }
}

/* OUTPUT

 Student ID : 243
Student Name : Ramu Kaka
College : IIT-Jagamara

Student ID : 532
Student Name : Khandu Don
College : ITER-Bombay
 */
