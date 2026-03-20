package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;


public class UpdatedDropdown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/org/example/core/drivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.cssSelector("input[id*='IndArm'")).click(); // * is a regular expression to match upon partial text of the id tag's value.

        driver.findElement(By.id("divpaxinfo")).click();
        Thread.sleep(2000);

        int i = 1;
        int totalLoop = 5;
        String expectedTicketAdult = "7";
        while(i < 5){
            driver.findElement(By.cssSelector("#hrefIncAdt")).click();
            i++;
        }

        driver.findElement(By.cssSelector("#hrefIncAdt")).click();
        driver.findElement(By.cssSelector("#hrefIncAdt")).click();
        String actualTest = driver.findElement(By.id("spanAudlt")).getText();
        driver.findElement(By.cssSelector(".buttonN")).click();
        Thread.sleep(2000);

        String expectedText = "3";
        Assert.assertEquals(actualTest,expectedTicketAdult,"Number Expected: " + expectedText + " not equal to actual text: " + actualTest);
        driver.quit();

    }
}
