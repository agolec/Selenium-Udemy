package org.example.sandbox;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.function.Function;

public class FluentlyWait {
    WebDriver driver;
    @Test
    void fluentWait(){
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.findElement(By.cssSelector("[id='start'] button")).click();

        //for up to the next 30 seconds, poll every 3 seconds for the element.
        //If NoSuchElementException is thrown during the poll, it is ignored to prevent
        //the exception from terminating the test, continuing it until timeout is reached.
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

        WebElement ele = wait.until(new Function<WebDriver, WebElement>(){
            public WebElement apply(WebDriver driver){
                //we need to write some code in here to determine whether the element is displayed, and
                //only return out of this method once it is displayed.
                if(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()){
                    return  driver.findElement(By.cssSelector("[id='finish'] h4"));
                } else {
                    return null;
                }
            }
        });
        System.out.println(driver.findElement(By.cssSelector("[id='finish'] h4")).getText());
    }
}
