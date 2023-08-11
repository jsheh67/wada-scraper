package org.example.utilities;

import java.text.DecimalFormat;

public class TimeConverter {

    DecimalFormat formatWhole = new DecimalFormat("00");
    DecimalFormat formatPoint = new DecimalFormat("00.00");

    public float getSeconds(String time){
        if (time.contains("h")){
            time=time.replace("h","0");
        }

        float seconds;
        if (time.contains(":")&& !time.contains(".")){
            String[] times = time.split(":");
            if(times.length==3){
                seconds = (Float.parseFloat(times[0])*60*60)+ (Float.parseFloat(times[1])*60)+Float.parseFloat(times[2]);
            }else{
                seconds = ((Float.parseFloat(times[1])*60)+Float.parseFloat(times[2]));
            }

        } else if (time.contains(":") && time.contains(".")) {
            String[] times = time.split("[:]");
            seconds = (Float.parseFloat(times[0])*60)+Float.parseFloat(times[1]);
        }else{
            seconds= Float.parseFloat(time);
        }
        return seconds;
    }

    public String getString(float seconds){
        String time = null;

        //half marathon and marathon times are rounded to the second
        if(seconds>=(60*60)){
           time= getStringHour(seconds);
        //half-marathon times
        } else if (seconds>50*60) {
           time= getStringHalf(seconds);

        } else if (seconds>=60) {
           time=getStringMinutes(seconds);
        }else{
            time=formatPoint.format(seconds);
        }
        System.out.println(time);
        return time;
    }

    public String getStringHour(float seconds){
        int secondsRound = Math.round(seconds);
        int hours = (int)Math.floor(secondsRound/(3600));
        int minutes = (int)Math.floor((secondsRound%3600)/60);
        int secondsLeft = secondsRound-(hours*3600)-(minutes*60);
        String hoursS= String.valueOf(hours);

        //System.out.println("test");
       // System.out.println(hoursS+":"+formatWhole.format(minutes)+":"+formatWhole.format(secondsLeft));
        return (hoursS+":"+formatWhole.format(minutes)+":"+formatWhole.format(secondsLeft));
    }

    public String getStringHalf(float seconds){
        int secondsRound = Math.round(seconds);
        int minutes = (int)Math.floor(secondsRound/60);
        int secondsLeft = secondsRound-(minutes*60);
        String minutesS = String.valueOf(minutes);
        return(minutesS+":"+formatWhole.format(secondsLeft));
    }

    public String getStringMinutes(float seconds){
        int minutes = (int)Math.floor(seconds/60);
        float secondsLeft = seconds%60;
        String Seconds2= formatPoint.format(secondsLeft);
        return (String.valueOf(minutes)+":"+Seconds2);
    }


    public static void main(String[] args){

        TimeConverter t = new TimeConverter();
        String hour="2:16:28";
        System.out.println(t.getSeconds(hour)+"---"+hour);

        System.out.println(t.getSeconds("3:36.5h"));


        t.getString(8188);
        t.getString(3670);
        System.out.println(t.getSeconds("1:01:10"));

        t.getString(6500);

        t.getString(3400);
        t.getString(3662);
        t.getString(104.51F);
        t.getString(70.00F);
        t.getString(60);
        t.getString(10.766F);


    }
}

