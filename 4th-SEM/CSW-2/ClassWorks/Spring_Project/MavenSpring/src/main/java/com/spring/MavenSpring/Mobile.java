package com.spring.MavenSpring;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Mobile {

	public static void main(String[] args) {
			ApplicationContext context=new ClassPathXmlApplicationContext("beans.xml");
			Sim s=(Sim) context.getBean("air");
			s.call();
			s.data();
			Sim mukesh=(Sim) context.getBean("jio");
			mukesh.call();
			mukesh.data();
	}

}
