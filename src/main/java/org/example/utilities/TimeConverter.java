package org.example.utilities;

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
        //half marathon and marathon times are rounded to the second
        if(seconds>(60*60)){
            int secondsRound = Math.round(seconds);
            int hours = (int)Math.floor(secondsRound/(3600));
            int minutes = (int)Math.floor((secondsRound%3600)/60);
            int secondsLeft = secondsRound-(hours*3600)-(minutes*60);

            System.out.println(hours+":"+minutes+":"+secondsLeft);
        }
        return "test";
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
    }
}

