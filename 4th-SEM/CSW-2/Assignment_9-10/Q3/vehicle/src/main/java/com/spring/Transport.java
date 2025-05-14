package com.spring;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Transport {
    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml")) {
            Car c1 = (Car) context.getBean("car1");
            c1.start();
            c1.stop();

            Car c2 = (Car) context.getBean("car2");
            c2.start();
            c2.stop();

            Bike b1 = (Bike) context.getBean("bike1");
            b1.start();
            b1.stop();
        }
    }
}