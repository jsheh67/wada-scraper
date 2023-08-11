package org.example.data;


import org.example.data.Athlete;

import java.time.LocalDate;

public class Performance {
    private Athlete athlete;
    private float time;
    private int score;
    private String event;
    private LocalDate date;
    private String wind;

    public Performance(Athlete athlete, float time, int score, String event, LocalDate date, String wind) {
        this.athlete = athlete;
        this.time = time;
        this.score = score;
        this.event = event;
        this.date = date;
        this.wind = wind;
    }

    public Performance(Athlete athlete, float time, int score, String event, LocalDate date) {
        this.athlete = athlete;
        this.time = time;
        this.score = score;
        this.event = event;
        this.date = date;
    }

    public Athlete getAthlete() {
        return athlete;
    }

    public void setAthlete(Athlete athlete) {
        this.athlete = athlete;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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
                "athlete=" + athlete +
                ", time=" + time +
                ", score=" + score +
                ", event='" + event + '\'' +
                ", date=" + date +
                ", wind='" + wind + '\'' +
                '}';
    }

    public  String toCSVWind(){
        return event+","+athlete.toString()+","+","+time+","+wind+","+score+","+date;
    }
    public String toCSVnoWind(){return event+","+athlete.toString()+","+time+","+score+","+date;}
}
