package org.example.utilities;

import java.text.DecimalFormat;

public class TimeConverter {

    public static float getSeconds(String time){
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

    public static String getString(float seconds){
        String time = null;
        DecimalFormat formatWhole = new DecimalFormat("00");
        DecimalFormat formatPoint = new DecimalFormat("00.00");
        //half marathon and marathon times are rounded to the second
        if(seconds>=(60*60)){
            int secondsRound = Math.round(seconds);
            int hours = (int)Math.floor(secondsRound/(3600));
            int minutes = (int)Math.floor((secondsRound%3600)/60);
            int secondsLeft = secondsRound-(hours*3600)-(minutes*60);
            String hoursS= String.valueOf(hours);

            System.out.println("test");
            System.out.println(hoursS+":"+formatWhole.format(minutes)+":"+formatWhole.format(secondsLeft));
            time=(hoursS+":"+formatWhole.format(minutes)+":"+formatWhole.format(secondsLeft));

        //half-marathon times
        } else if (seconds>50*60) {
            int secondsRound = Math.round(seconds);
            int minutes = (int)Math.floor(secondsRound/60);
            int secondsLeft = secondsRound-(minutes*60);
            String minutesS = String.valueOf(minutes);
            time=minutesS+":"+formatWhole.format(secondsLeft);

        } else if (seconds>=60) {
            int minutes = (int)Math.floor(seconds/60);
            float secondsLeft = seconds%60;

            String Seconds2= formatPoint.format(secondsLeft);
            time= (String.valueOf(minutes)+":"+Seconds2);
        }else{
            time=formatPoint.format(seconds);
        }
        System.out.println(time);
        return time;
    }


    public static void main(String[] args){
//        String sprint = "10.65";
//        String minute="1:55.77";
//        String dMinute="14:00.20";
       String hour="2:16:28";
//
           System.out.println(getSeconds(hour)+"---"+hour);
//        System.out.println(getSeconds(dMinute)+"---"+dMinute);
//        System.out.println(getSeconds(minute)+"---"+minute);
//        System.out.println(getSeconds(sprint)+"---"+sprint);

        getString(8188);
        getString(3670);
        System.out.println(getSeconds("1:01:10"));

        getString(6500);

        getString(3400);
        getString(3662);
        getString(104.51F);
        getString(70.00F);
        getString(60);
        getString(10.766F);


    }
}

