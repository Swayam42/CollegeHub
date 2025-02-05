package com.iter.Q10;
public class MainEnrollApp {

	public static void main(String[] args) {
		
		Enrollment e1=new Enrollment(4);
		Course c1=new Course("Ramu Kaka",1234,"CSE");
		Course c2=new Course("Ronaldo Chacha",2354,"CIVIL");
		Course c3=new Course("Neymar",7676,"ECE");
		e1.enroll(c1);
		e1.enroll(c2);
		e1.enroll(c3);
		e1.displayDetails();
		e1.drop(c2);
		System.out.println("After Dropping");
		e1.displayDetails();
	}

}

/*
 OUTPUT :
 
Student Name : Ramu Kaka,Reg No : 1234,Branch : CSE Enrolled
Student Name : Ronaldo Chacha,Reg No : 2354,Branch : CIVIL Enrolled
Student Name : Neymar,Reg No : 7676,Branch : ECE Enrolled
Details : 

Student Name : Ramu Kaka,Reg No : 1234,Branch : CSE

Student Name : Ronaldo Chacha,Reg No : 2354,Branch : CIVIL

Student Name : Neymar,Reg No : 7676,Branch : ECE

Student Name : Neymar,Reg No : 7676,Branch : ECE Dropped Out
After Dropping

Details : 

Student Name : Ramu Kaka,Reg No : 1234,Branch : CSE

Student Name : Neymar,Reg No : 7676,Branch : ECE

 */
