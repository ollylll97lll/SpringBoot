package com.base_spring_demo_annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")

public class TennisCoach implements Coach {
    private String clname = this.getClass().getSimpleName();

    // @Autowired
    // @Qualifier("APIFortuneService")
    private FortuneService fortuneService;

    TennisCoach() {
        System.out.println("no arg constructor of: " + clname);
    }

    @Autowired
    public TennisCoach(@Qualifier("APIFortuneService") FortuneService apiFortuneService) {
        this.fortuneService = apiFortuneService;
    }

    @PostConstruct
    private void DoBefore() {
        System.out.println("Before Construct of " + clname);
    }

    @PreDestroy
    private void DoAfter() {
        System.out.println("After Construct of " + clname);
    }

    /**
     * Setter
     * Set injection
     * 
     * @param fortuneService
     */

    // @Autowired
    // public void setFortuneService(FortuneService fortuneService) {
    // System.out.println("Run setter from: " + clname);
    // this.fortuneService = fortuneService;
    // }

    /**
     * Constructor Injection
     */

    // @Autowired
    // TennisCoach(FortuneService fService) {
    // this.fortuneService = fService;
    // }

    @Override
    public String getDailyWorkout() {
        return "getDailyWorkout from " + clname;
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

}
