package org.example.utilities;

import java.time.LocalDate;

public class DateConverter {


    //dates that are not full (month day year) will return null
    public static LocalDate convertDate(String date){
        if(date.isBlank()||date.isEmpty()||date==null|| date.length()<6) {
            return null;
        }
        else{

            int day = Integer.parseInt(date.substring(0, 2));
            String month = date.substring(3, 6);
            int month2 = Integer.parseInt(convertMonth(month));
            int year = Integer.parseInt(date.substring(7));
            //System.out.println(day+" "+month2+" "+year);
            LocalDate formDate = LocalDate.of(year, month2, day);
            return formDate;
        }
    }
    public static String convertMonth(String month){
        String monthConv =null;
        switch (month){
            case "JAN":
                monthConv="01";
                break;
            case "FEB":
                monthConv="02";
                break;
            case "MAR":
                monthConv="03";
                break;
            case "APR":
                monthConv="04";
                break;
            case "MAY":
                monthConv="05";
                break;
            case "JUN":
                monthConv="06";
                break;
            case "JUL":
                monthConv="07";
                break;
            case "AUG":
                monthConv="08";
                break;
            case "SEP":
                monthConv="09";
                break;
            case "OCT":
                monthConv="10";
                break;
            case "NOV":
                monthConv="11";
                break;
            case "DEC":
                monthConv="12";
                break;
            default:
        }
        return monthConv;
    }

    public static void main(String[] args) {
       // String test="16 JUL 1994";
       // convertDate(test);
       // System.out.println(convertDate(test));
    }
}
