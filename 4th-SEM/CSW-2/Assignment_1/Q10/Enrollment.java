package com.iter.Q10;

public class Enrollment implements EnrollmentSystem{
	Course c1[];
	int maxSize;
	int count;
	public Enrollment(int maxSize) {
		this.count=0;
		this.maxSize=maxSize;
		this.c1=new Course[maxSize];
		
	}
	
	public void enroll(Course co1) {
		if (count <= maxSize) {
            c1[count++] = new Course(co1.getName(), co1.getReg(), co1.getBranch());
        } else {
            System.out.println("Enrollment is full");
        }
		System.out.print(co1.displayCourse()+" Enrolled");
	}
	
	 
	    public void drop(Course co2) {
	        for (int i=0;i<c1.length;i++) {
	            if( c1[i].getReg() == co2.getReg()) {
	            	for(int j=i;j<count-1;j++) {
	            		c1[j]=c1[j+1];
	            	}
	            	
	                System.out.println(c1[i].displayCourse() + " Dropped Out");
	                c1[count-1] = null;
	                count--;
	                break;
	            }
	        }
	    }
	
	public void displayDetails() {
	     System.out.println("\nDetails : ");
		if(c1.length==0) {
	    	 System.out.println("Empty");
	     }
		for (int i=0;i<count;i++) {
	         if(c1[i]!=null) {
			System.out.println(c1[i].displayCourse());
	         }
	     }
	 }
}



