package org.example;

import org.example.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CalendarSelections extends Config {
    WebDriver driver;

    @Test
    public void calendarSelectionTest(){
        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        clickCalendar(driver);
        String actualDate = getTextOfCurrentDate(driver);
        int actualDateInt = Integer.parseInt(actualDate);
        final int EXPECTED_DATE = 5;
        Assert.assertEquals(actualDateInt,EXPECTED_DATE,"date expected: " + EXPECTED_DATE + "\nDate received: " + actualDateInt);

    }
    public static void clickCalendar(WebDriver driver){
        driver.findElement(By.cssSelector("button.ui-datepicker-trigger")).click();
    }
    public static String getTextOfCurrentDate(WebDriver driver){
        return driver.findElement(By.cssSelector("a.ui-state-default.ui-state-active")).getText();
    }
    @AfterMethod
    public void tearDown(){
        this.driver.quit();
    }
}
