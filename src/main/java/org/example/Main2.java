package org.example;

import org.example.data.Athlete;
import org.example.data.Performance;
import org.example.utilities.DateConverter;
import org.example.utilities.TimeConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main2 {

    public static void main (String args[]) throws FileNotFoundException {
        HashMap<Integer,Long> population=new HashMap<>();

        TimeConverter timeConverter= new TimeConverter();

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        String filename= "1500results.csv";
        File file = new File(filename);
        try {
            if (file.createNewFile()) {
                System.out.println( filename+" created.");
            } else {
                System.out.println(filename+" already exists.");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        PrintWriter writer = new PrintWriter(filename);
        writer.println("event,name,dob,country,time,score,date");

        driver.get("https://www.worldometers.info/world-population/world-population-by-year/");
        List<WebElement> years = driver.findElements(By.xpath("//table/tbody/tr"));

        int i=0;
        for(WebElement row:years){

            int year =Integer.parseInt(row.findElement(By.xpath("./td[1]")).getText());

            String popstring = row.findElement(By.xpath("./td[2]")).getText();
            Long pop =Long.valueOf(popstring.replace(",",""));
            i++;
            if(i>25){
                break;
            }

            population.put(year,pop);
        }

        System.out.println(population.get(2001));
        System.out.println(population.get(2002));
        System.out.println(population.get(2013));
        System.out.println(population.get(2023));

        for(int a=2001;a<=2023;a++){
            //top percent
            double top=Math.floor(population.get(a)/100000000);
            String year = String.valueOf(a);
            String address = "https://worldathletics.org/records/toplists/middle-long/1500-metres/outdoor/men/senior/"+year+"?regionType=world&page=1&bestResultsOnly=true";
            driver.get(address);
            List<WebElement> performanceRecords = driver.findElements(By.xpath("//table/tbody/tr"));

            double sum=0;

            for(int b=0; b<100;b++){
                WebElement row = performanceRecords.get(b);
                float time_seconds = timeConverter.getSeconds(
                        row.findElement(By.xpath("./td[2]"))
                        .getText());
                String name= row.findElement(By.xpath("./td[3]")).getText();

                LocalDate dob = DateConverter.convertDate(
                        row.findElement(By.xpath("./td[4]")).getText());

                String country = row.findElement(By.xpath("./td[5]")).getText();

                LocalDate date = DateConverter.convertDate(
                        row.findElement(By.xpath("./td[9]")).getText());

                int score = Integer.parseInt(row.findElement(By.xpath("./td[10]")).getText());

                Athlete athlete = new Athlete(name,dob,country);
                Performance p = new Performance(athlete,time_seconds,score,"men's 1500m",date);
                writer.println(p.toCSVnoWind());
                sum=sum+score;

            }
            double avg_top100= sum/100;
            double avg_top = sum/top;
            writer.println("--------"+a+"------------");
            writer.println("--------:avg top 100:"+avg_top100+"--avg top percent:"+avg_top+"-------");

        }
        driver.quit();



       // List<WebElement> performanceRecords = driver.findElements(By.xpath("//table/tbody/tr"));

      //  System.out.println(performanceRecords.size());



    }
}
