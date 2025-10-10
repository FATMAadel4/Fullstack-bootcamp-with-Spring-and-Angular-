package com.ioc.examples;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext container = new ClassPathXmlApplicationContext("applicationContext.xml");

        Shape circle =  container.getBean("circle",Circle.class);
        System.out.println("the area of the circle = " + circle.getArea());


        Shape rectangle =  container.getBean("rectangle",Rectangle.class);
        System.out.println("the area of the Square = " + rectangle.getArea());
    }

}
