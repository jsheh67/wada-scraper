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
        //half marathon and marathon times are rounded to the second
        if(seconds>=(60*60)){
            int secondsRound = Math.round(seconds);
            int hours = (int)Math.floor(secondsRound/(3600));
            int minutes = (int)Math.floor((secondsRound%3600)/60);
            int secondsLeft = secondsRound-(hours*3600)-(minutes*60);

            String hoursS= String.valueOf(hours);
            String minutesS = String.valueOf(minutes);
            String secondsLeftS = String.valueOf(secondsLeft);

            if(minutes<10){
                minutesS = "0"+minutesS;
            }
            if (secondsLeft<10){
                secondsLeftS="0"+secondsLeftS;
            }
            time=(hoursS+":"+minutesS+":"+secondsLeftS);

        //half-marathon times
        } else if (seconds>50*60) {
            int secondsRound = Math.round(seconds);
            int minutes = (int)Math.floor(secondsRound/60);
            int secondsLeft = secondsRound-(minutes*60);

            String minutesS = String.valueOf(minutes);
            String secondsS= String.valueOf(secondsLeft);

            if (seconds<10){
                secondsS="0"+secondsS;
            }
            time=minutesS+":"+secondsS;
        } else if (seconds>=60) {

            DecimalFormat format = new DecimalFormat("00.00");
            int minutes = (int)Math.floor(seconds/60);
            float secondsLeft = seconds%60;

            String secondsS= String.valueOf(secondsLeft);

            String Seconds2= format.format(secondsLeft);

           if(secondsLeft<10){
                secondsS="0"+secondsS;
           }
            System.out.println(String.valueOf(minutes)+":"+Seconds2);
           time= String.valueOf(minutes)+":"+secondsS;
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

        getString(3400);
        getString(104.51F);
        getString(70.00F);


    }
}

