package com.base_spring_demo_annotation;

import org.springframework.stereotype.Component;

@Component
public class CrapFortune implements FortuneService {

    @Override
    public String getFortune() {
        return "2day is ur fup d";
    }
    
}
