package org.example.exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.time.LocalDate;

public class TwoWeekTrip {
    public static void main(String[] args){
        final String CHROME_DRIVER = "webdriver.chrome.driver";
        System.setProperty(CHROME_DRIVER, System.getProperty("user.dir") + "/src/main/java/org/example/core/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        WebElement roundTripRadio = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1"));
        WebElement departDate = driver.findElement(By.id("ctl00_mainContent_view_date1"));

        roundTripRadio.click();
        departDate.click();

        WebElement curentDate = driver.findElement(By.cssSelector("td.ui-datepicker-week-end.ui-datepicker-current-day > a"));
        String actualDayOfMonth = "5";
        String twoWeekReturnDayOfMonth = "19";
        WebElement returnDate = driver.findElement(By.cssSelector(".ui-state-default.ui-state-hover"));
        Assert.assertTrue(curentDate.getText().equals(actualDayOfMonth),"Error. Day of week expected: [" + actualDayOfMonth + "]. Actual Day of week: [" + curentDate.getText() + "]");


    }
}
