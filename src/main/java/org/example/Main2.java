package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.List;

public class Main2 {

    public static void main (String args[]){
        HashMap<Integer,Long> population=new HashMap<>();

        WebDriver driver = new ChromeDriver();

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


        driver.get("https://worldathletics.org/records/toplists/middle-long/1500-metres/outdoor/men/senior/2023?regionType=world&page=1&bestResultsOnly=true");
        List<WebElement> performanceRecords = driver.findElements(By.xpath("//table/tbody/tr"));

        System.out.println(performanceRecords.size());



    }
}
