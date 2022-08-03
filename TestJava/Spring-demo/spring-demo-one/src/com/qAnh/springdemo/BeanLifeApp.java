package com.qAnh.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
        new ClassPathXmlApplicationContext("beanLifeCycle-applicationContext.xml");
    
        Coach coach = context.getBean("myCoach", Coach.class);
        Coach secondcoach = context.getBean("myCoach", Coach.class);
        
        System.out.println(coach);
        System.out.println(secondcoach);
        context.close();
    }
}
