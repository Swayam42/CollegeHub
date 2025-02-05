package com.iter.Q10;

 class Course extends Student{
	
	private String branch;
	
	 Course(String name,int reg,String branch) {
		 super(name,reg);
		this.branch = branch;
	}
	 
	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}
	
	public String displayCourse() {
		return displayStudent()+",Branch : "+branch;
	}
	
	
}
