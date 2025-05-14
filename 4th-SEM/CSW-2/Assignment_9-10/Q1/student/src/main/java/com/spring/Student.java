package com.spring;

public class Student {
    private String name;
    private int rollNo;
    private String email;

    public void setName(String name){
        this.name=name;
    }
    public void setRollNo(int rollNo){
        this.rollNo=rollNo;
    }
    public void setEmail(String email){
        this.email=email;
    }

    public String getName(){
        return name;
    }
    public int getRollNo(){
        return rollNo;
    }
    public String getEmail(){
        return email;
    }

    public void display(){
        System.out.println("Name : "+this.name);
        System.out.println("Roll No : "+this.rollNo);
        System.out.println("E-mail : "+this.email);

    }

    
}
