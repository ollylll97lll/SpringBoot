package com.base_spring_demo_annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {
    public static void main(String[] args) {
        // ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
        AnnotationConfigApplicationContext newcontext = new AnnotationConfigApplicationContext(SwimCrapConfig.class);
        
        // Coach tennisCoach = context.getBean("tennisCoach",Coach.class);
        // GolfCoach golfCoach = context.getBean("golfCoach",GolfCoach.class);
        Coach swimCoach = newcontext.getBean("swimCoach",Coach.class);


        // System.out.println(tennisCoach.getDailyWorkout());
        // System.out.println(tennisCoach.getDailyFortune());

        // System.out.println(golfCoach.getInfo());

        System.out.println(swimCoach.getDailyFortune());
        System.out.println(swimCoach.getDailyWorkout());

        context.close();
        newcontext.close();
    }
}
