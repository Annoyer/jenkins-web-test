package com.jcy.jenkins.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.util.Assert;

import java.util.concurrent.TimeUnit;

public class ClickMoreTest {
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        //Puts a Implicit wait, Will wait for 10 seconds before throwing exception
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Launch website
        driver.get("http://localhost:8080/");

        //Maximize the browser
        driver.manage().window().maximize();


        int beforeSize = driver.findElements(By.className("msg")).size();

        // Click Calculate Button
        driver.findElement(By.id("moreBtn")).click();

        // Get the Result Text based on its xpath
        int afterSize = driver.findElements(By.className("msg")).size();

        Assert.isTrue(beforeSize + 5 == afterSize, "Fail.");

        //Close the Browser.
        driver.close();
    }
}
