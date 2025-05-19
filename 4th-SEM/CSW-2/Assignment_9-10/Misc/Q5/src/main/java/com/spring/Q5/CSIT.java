package com.spring.Q5;

public class CSIT implements Branch{
	String name;
	int roll;
	public CSIT(String name, int roll) {
		this.name = name;
		this.roll = roll;
	}
	public void enroll() {
		System.out.println(name+" is enrolled in CSE");
	}
	
}
