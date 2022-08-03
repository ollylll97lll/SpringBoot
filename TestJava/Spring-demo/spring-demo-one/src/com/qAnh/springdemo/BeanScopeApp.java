package com.qAnh.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
        new ClassPathXmlApplicationContext("BeanScope-applicationContext.xml");
    
        Coach coach = context.getBean("myCoach", Coach.class);

        Coach BeataCoach = context.getBean("myCoach", Coach.class);


        System.out.println(coach);
        System.out.println(BeataCoach);


        context.close();
    }
}
