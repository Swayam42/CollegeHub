package com.spring.user;

public class User {
    private String name;
    private String email;

    public String getName(){ 
        return name; 
    }
    public String getEmail(){ 
        return email;
    }

    public void setName(String name){ 
        this.name=name;
    }
    public void setEmail(String email){ 
        this.email=email;
    }
}
