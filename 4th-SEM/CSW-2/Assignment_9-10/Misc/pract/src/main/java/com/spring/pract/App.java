package com.spring.pract;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
	ApplicationContext context =new ClassPathXmlApplicationContext("beans.xml");
	Address a1=(Address)context.getBean("add1");
	Student s1=(Student)context.getBean("student1");
	System.out.println("\nStudent Details : ");
	s1.display();
}

}
