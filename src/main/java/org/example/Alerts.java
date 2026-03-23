package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.example.config.Config;

public class Alerts extends Config {
    ChromeDriver driver;
    @Test
    void alertsTest(){
        String text = "rahul";
        driver = new ChromeDriver();
        driver.get("http://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.id("name")).sendKeys(text);
        driver.findElement(By.cssSelector("[id='name']")).click();
        driver.findElement(By.cssSelector("[id='alertbtn']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.findElement(By.id("confirmbtn")).click();
        driver.switchTo().alert().dismiss();
    }
    @AfterMethod
    void tearDown(){
        driver.quit();
    }
}
