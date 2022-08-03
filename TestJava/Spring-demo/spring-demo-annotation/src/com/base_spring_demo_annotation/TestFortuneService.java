package com.base_spring_demo_annotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TestFortuneService implements FortuneService {

    private String clname = this.getClass().getSimpleName();

    @Value("${foo.fortunes}")
    String[] fortunesStr;

    @Override
    public String getFortune() {
        return "getFortune implements from: " + clname +" "+ fortunesStr[(int)Math.floor(Math.random() * fortunesStr.length)];
    }

}
