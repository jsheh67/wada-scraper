package org.example;

import org.example.data.Performance;
import org.example.utilities.DateConverter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    static WebDriver driver = new ChromeDriver();

    public static String[] getInput(){
        Scanner in = new Scanner(System.in);

        System.out.println("enter event:");
        String event = in.nextLine();
        //System.out.println("You entered string " + s);

        System.out.println("enter gender:");
        String gender = in.nextLine();

        System.out.println("enter number of pages");
        String pages = in.nextLine();

        System.out.println("enter the year");
        String year = in.nextLine();

        return new String[]{event, gender, pages,year};

    }

    public static void next(){
        WebElement next= driver.findElement(By.xpath("/html/body/div[3]/div/div[2]/div/div[2]/div[1]/div/a[2]"));
        next.click();
    }
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        // System.setProperty("webdriver.chrome.driver", "chromedriver");
       // scrape("200-metres","men",3);

        String[] input= getInput();
        scrape(input[0],input[1],Integer.parseInt(input[2]),input[3]);
        //System.out.println(Thread.activeCount());

    }
    public static void scrape(String distance, String gender, int pages, String year) throws FileNotFoundException {

        String group = "middle-long";
        if(distance.charAt(0)<='4'){
            group="sprints";
        }

        boolean hasWind= false;
        if(distance.startsWith("100")||distance.startsWith("200")){
            hasWind=true;
        }

        String filename= distance+"-"+gender+".csv";
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

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // JavascriptExecutor executor = (JavascriptExecutor)driver;

        PrintWriter writer = new PrintWriter(filename);

        if(hasWind) {
            writer.println("event,athlete,dob,time,wind,score,date");
        }else{
            writer.println("event,athlete,dob,time,score,date");
        }

        for (int i = 1; i <= pages; i++) {

            driver.get("https://worldathletics.org/records/toplists/"+group+"/"+distance+"/outdoor/"+gender+"/senior/"+year+"?regionType=world&timing=electronic&windReading=regular&page=" + i + "&bestResultsOnly=true");


            String event = driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[1]/h1")).getText();
            System.out.println(event);//test
            List<WebElement> performanceRecords = driver.findElements(By.xpath("//table/tbody/tr"));
            System.out.println(performanceRecords.size());

            if (hasWind) {
                for (WebElement record : performanceRecords) {
                    String athlete = record.findElement(
                            By.xpath(".//td[4]")).getText();
                    // System.out.println(athlete);

                    String wind = record.findElement(
                            By.xpath(".//td[3]")).getText();
                    //  System.out.println(wind);

                    float time = Float.parseFloat((record.findElement(
                            By.xpath(".//td[2]")).getText()));
                    System.out.println(time);

                    LocalDate dob = DateConverter.convertDate(record.findElement(
                            By.xpath(".//td[5]")).getText());
                    //  System.out.println(dob.toString());

                    LocalDate date = DateConverter.convertDate(record.findElement(
                            By.xpath(".//td[10]")).getText());
                    //  System.out.println(date.toString());

                    int score = Integer.parseInt(record.findElement(
                            By.xpath(".//td[11]")).getText());
                    //   System.out.println(score);

//                    Performance p = new Performance(event, athlete, wind, date, dob, time, score);
//                    System.out.println(p.toCSV());
//                    writer.println(p.toCSV());
                }
            }else{
                for (WebElement record : performanceRecords) {
                    String athlete = record.findElement(
                            By.xpath(".//td[3]")).getText();
                    // System.out.println(athlete);

                    float time = Float.parseFloat((record.findElement(
                            By.xpath(".//td[2]")).getText()));
                    System.out.println(time);

                    LocalDate dob = DateConverter.convertDate(record.findElement(
                            By.xpath(".//td[4]")).getText());
                    //  System.out.println(dob.toString());

                    LocalDate date = DateConverter.convertDate(record.findElement(
                            By.xpath(".//td[9]")).getText());
                    //  System.out.println(date.toString());

                    int score = Integer.parseInt(record.findElement(
                            By.xpath(".//td[10]")).getText());
                    //   System.out.println(score);
//
//                    Performance p = new Performance(event, athlete, date, dob, time, score);
//                    System.out.println(p.toCSV());
//                    writer.println(p.toCSV());
            }

            }

        }
        writer.close();
    }

}