package com.base_spring_demo_annotation;

import org.springframework.stereotype.Component;


@Component
public class DatabaseFortuneService implements FortuneService {
    private String clname = this.getClass().getSimpleName();

    @Override
    public String getFortune() {
        return "getFortune implements from: " + clname + randomStr[(int)Math.floor(Math.random() * randomStr.length)];
    }
}
