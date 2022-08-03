package com.base_spring_demo_annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class SwimCoach implements Coach {
    private String clname = this.getClass().getSimpleName();
    @Autowired
    @Qualifier("crapFortune")
    private FortuneService fortuneService;
    

    public SwimCoach() {
        System.out.println("no arg constructor of: " + clname);
    }

    
    @Autowired
    public SwimCoach(@Qualifier("crapFortune") FortuneService crapFortune) {
        this.fortuneService = crapFortune;
    }

    @Override
    public String getDailyWorkout() {
        return "Daily workout from " +clname;
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
    
}
