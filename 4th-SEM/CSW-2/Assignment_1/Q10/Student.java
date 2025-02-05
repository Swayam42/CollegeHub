package com.iter.Q10;

public class Student {
	private String name;
	private int reg;
	
	public Student(String name,int reg){
		this.name=name;
		this.reg=reg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getReg() {
		return reg;
	}

	public void setReg(int reg) {
		this.reg = reg;
	}
	
	public String displayStudent() {
		return "\nStudent Name : "+name+",Reg No : "+reg;
	}

}
