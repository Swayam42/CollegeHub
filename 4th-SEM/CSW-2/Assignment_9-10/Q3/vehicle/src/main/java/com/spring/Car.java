package com.spring;

public class Car implements Vehicle{
    private String name;
    private int id;

    public void setName(String name){
        this.name=name;
    }
    public void setId(int id){
        this.id=id;
    }

    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
    @Override
    public void start(){
        System.out.println(toString()+" STARTED ");
    }
    @Override
    public void stop(){
        System.out.println(toString()+" STOPPED ");
    }
    public String toString(){
        return "Name : "+getName()+" Id : "+getId();
    }
}
