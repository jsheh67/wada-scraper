package org.example.utilities;

public class ScoreConverter {

    public static int fifteenTimeToPoints(Float timeSeconds){
        return (int) Math.round(0.05070779* Math.pow((382.6006422-timeSeconds),1.962415519));
    }

    public static float fifteenPointsToTime(int points){
        return (float) -((Math.pow((points/0.05070779),(1/1.962415519)))-382.6006422);

    }

    public static void main(String[] args) {
        System.out.println(fifteenPointsToTime(1400));
        System.out.println(fifteenPointsToTime(1000));
        System.out.println(fifteenTimeToPoints(199.44F));
    }

}
