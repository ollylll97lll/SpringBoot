package com.qAnh.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) throws Exception {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        // Coach myTC = context.getBean("myTrackCoach", Coach.class);
        // Coach myBaseC = context.getBean("myBaseCoach", Coach.class);
        // Coach myBasketC = context.getBean("myBasketCoach", Coach.class);
        CricketCoach myCrickC = context.getBean("myCricketCoach",CricketCoach.class);

        // System.out.println(myTC.getDailyWorkout());
        // System.out.println(myTC.getDailyFortune());

        // System.out.println(myBaseC.getDailyWorkout());
        // System.out.println(myBaseC.getDailyFortune());
        
        // System.out.println(myBasketC.getDailyWorkout());
        // System.out.println(myBasketC.getDailyFortune());

        // System.out.println(myCrickC.getDailyFortune());
        // System.out.println(myCrickC.getEmailAddress());
        // System.out.println(myCrickC.getTeam());
        System.out.println(myCrickC.getFortune());

        context.close();
    }
}
