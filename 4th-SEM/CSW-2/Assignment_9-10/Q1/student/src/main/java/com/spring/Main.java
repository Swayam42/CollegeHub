package com.spring;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
            Student s1 = (Student) context.getBean("student1");
            Student s2 = (Student) context.getBean("student2");
            System.out.println("\nStudent 1 Details : ");
            s1.display();
            System.out.println("\nStudent 2 Details : ");
            s2.display();
        }
    }
}