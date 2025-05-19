package com.spring.Q5;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
  public static void main(String[] args) {
	  ApplicationContext context =new ClassPathXmlApplicationContext("beans.xml");
		CSE s1=(CSE)context.getBean("s1");
		s1.enroll();
		CSIT s2=(CSIT)context.getBean("s2");
		s2.enroll();
  }
}
