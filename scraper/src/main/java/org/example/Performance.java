package org.example;


import java.time.LocalDate;
import java.time.LocalTime;

public class Performance {
    private String athlete;
    private LocalDate date;
    private LocalDate dob;
    private float time;
    private int score;
    private String event;

    private String wind;

    public Performance(String event, String athlete, LocalDate date, LocalDate dob, float time, int score){
        this.event=event;
        this.athlete=  athlete;
        this.date= date;
        this.dob=dob;
        this.time=time;
        this.score=score;
    }
    public Performance(String event, String athlete, String wind, LocalDate date, LocalDate dob,float time, int score){
        this.event= event;
        this.athlete=  athlete;
        this.wind=wind;
        this.date= date;
        this.dob=dob;
        this.time=time;
        this.score=score;
    }

    public String getAthlete() {
        return athlete;
    }

    public void setAthlete(String athlete) {
        this.athlete = athlete;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getWind() {
        return wind;
    }

    public void setWind(String wind) {
        this.wind = wind;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Performance{" +
                "athlete='" + athlete + '\'' +
                ", date=" + date +
                ", dob=" + dob +
                ", time=" + time +
                ", score=" + score +
                ", event='" + event + '\'' +
                ", wind=" + wind +
                '}';
    }

    public  String toCSV(){
        return event+","+athlete+","+dob+","+time+","+wind+","+score+","+date;
    }
}
