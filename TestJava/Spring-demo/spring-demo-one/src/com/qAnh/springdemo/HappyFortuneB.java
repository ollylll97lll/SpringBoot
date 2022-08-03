package com.qAnh.springdemo;

public class HappyFortuneB implements FortuneService {

    @Override
    public String getFortune() {
        return "Get urself sum fkin 4tune b";
    }

    public String getMisFortune() {
        return "Get unlucky b";
    }
    
}
