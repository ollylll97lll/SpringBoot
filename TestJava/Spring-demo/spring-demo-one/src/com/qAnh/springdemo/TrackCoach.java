package com.qAnh.springdemo;

public class TrackCoach implements Coach {

    private FortuneService hB;
    private final String clname = this.getClass().getSimpleName() ;

    TrackCoach(FortuneService hBarg){
        this.hB = hBarg;
    }

    @Override
    public String getDailyWorkout() {
        return "Run bietch";
    }

    @Override
    public String getFortune() {
        return "This is from implementation";
    }

    @Override
    public String getDailyFortune() {
        return "from " + clname + ": " + hB.getFortune();
    }

    /**
     * Init & Destroy Meths
     */

    public void doMyStartUpStuff() {
        System.out.println(clname + " Startin It Up");
    }

    public void doMyShutDownStuff() {
        System.out.println(clname + " Shutin It Down");       
    }
    
}
