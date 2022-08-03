package com.qAnh.springdemo;

public class BasketballCoach implements Coach {

    private HappyFortuneB hB = new HappyFortuneB();
    private final String clname = this.getClass().getSimpleName() ;

    BasketballCoach(HappyFortuneB hBarg){
        this.hB = hBarg;
    }

    @Override
    public String getFortune() {
        return clname + "getFortune";
    }

    @Override
    public String getDailyWorkout() {
        return clname + "getDailyWorkout" + "Implementation";
    }

    @Override
    public String getDailyFortune() {
        return "from " + clname + ": " + hB.getFortune();
    }
    
}
