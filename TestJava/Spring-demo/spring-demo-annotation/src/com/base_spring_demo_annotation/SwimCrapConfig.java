package com.base_spring_demo_annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwimCrapConfig {
    @Bean
    public FortuneService crapFortune() {
        return new CrapFortune();
    }
    @Bean
    public FortuneService happyFortuneService(){
        return new HappyFortuneService();
    }
    @Bean
    public Coach swimCoach(){
        return new SwimCoach(crapFortune());
    }
}
