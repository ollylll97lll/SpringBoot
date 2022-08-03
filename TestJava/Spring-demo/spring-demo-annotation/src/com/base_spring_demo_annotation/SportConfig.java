package com.base_spring_demo_annotation;

import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
// @ComponentScan("com.base_spring_demo_annotation")
@PropertySource("classpath:sport.properties")
public class SportConfig {

    @Bean
    public FortuneService happyFortuneService(){
        return new HappyFortuneService();
    }
    @Bean
    public FortuneService APIFortuneService(){
        return new APIFortuneService();
    }
    @Bean
    public FortuneService databaseFortuneService(){
        return new DatabaseFortuneService();
    }
    @Bean
    public FortuneService randomFortuneService(){
        return new RandomFortuneService();
    }
    @Bean
    public FortuneService testFortuneService(){
        return new TestFortuneService();
    }
    @Bean
    public Coach tennisCoach(){
        return new TennisCoach(APIFortuneService());
    }

    @Bean
    public Coach golfCoach(){
        GolfCoach golfCoach = new GolfCoach();
        return golfCoach;
    }
     
}
