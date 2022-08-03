package com.base_spring_demo_annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class GolfCoach implements Coach {
    private String clname = this.getClass().getSimpleName();
    GolfCoach() {
        System.out.println("no arg constructor of: " + clname);
    }

    @Autowired
    @Qualifier("testFortuneService")
    FortuneService fortuneService;

    @Value("${foo.email}")
    private String email;

    @Value("${foo.team}")
    private String team;

    @PostConstruct
    private void DoBefore() {
        System.out.println("Before Construct of "+clname);
    }

    @PreDestroy
    private void DoAfter() {
        System.out.println("After Construct of " +clname);
    }


    @Override
    public String getDailyWorkout() {
        return "getDailyWorkout from " + clname;
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public String getInfo() {
        return email + " " + team;
    }

}
