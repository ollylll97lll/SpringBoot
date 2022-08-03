package com.qAnh.springdemo;

public class CricketCoach implements Coach {
    private FortuneService fService;
    private final String clname = this.getClass().getSimpleName();
    private String emailAddress, team;

    public CricketCoach() {
        System.out.println(clname + ": inside no-args constructor");
    }

    /**
     * Getter Setter
     */
    public void setFService(FortuneService fortuneService) {
        this.fService = fortuneService;
        System.out.println("Setting...");
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getTeam() {
        return team;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Functions
     */
    @Override
    public String getFortune() {
        return arrL[(int)Math.floor(Math.random() * 3)];
    }

    @Override
    public String getDailyWorkout() {
        return clname + "getDailyWorkout";
    }

    @Override
    public String getDailyFortune() {
        return "from " + this.getClass().getSimpleName() + " " + fService.getFortune();
    }

}
