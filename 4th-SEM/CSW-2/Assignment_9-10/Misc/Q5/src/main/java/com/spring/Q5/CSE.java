package com.spring.Q5;

public class CSE implements Branch{
	String name;
	int roll;
	public CSE(String name, int roll) {
		this.name = name;
		this.roll = roll;
	}
	public void enroll() {
		System.out.println(name+" is enrolled in CSE");
	}
	
}
