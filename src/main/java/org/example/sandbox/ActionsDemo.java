package org.example.sandbox;

import org.example.global.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionsDemo {
    //mouseover an element to validate that another element has popped up
    //on the page.
    @Test
    void ActionsTest() throws InterruptedException {

        ChromeOptions optionsChrome = new ChromeOptions();
        optionsChrome.addArguments("--incognito");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://amazon.com/");


        WaitUtils.waitUntilElementVisible(driver,5,By.cssSelector("#nav-link-accountList-nav-line-1"));
        WebElement element = driver.findElement(By.cssSelector("#nav-link-accountList-nav-line-1"));
        Actions a = new Actions(driver);

        a.moveToElement(element).build().perform();
        Thread.sleep(Duration.ofSeconds(5));
        driver.quit();
    }
}
