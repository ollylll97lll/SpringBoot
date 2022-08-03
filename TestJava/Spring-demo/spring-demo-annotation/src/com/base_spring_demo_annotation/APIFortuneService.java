package com.base_spring_demo_annotation;

import org.springframework.stereotype.Component;

@Component
public class APIFortuneService implements FortuneService {
    private String clname = this.getClass().getSimpleName();

    @Override
    public String getFortune() {
        return "getFortune implements from: " + clname + randomStr[(int)Math.floor(Math.random() * randomStr.length)];


    }
    public String getMisFortune(){
        return "Misfortune 4 U";
    }
}
