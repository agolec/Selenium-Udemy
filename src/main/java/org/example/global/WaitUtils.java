package org.example.global;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {
    static void waitUntilElementVisible(WebDriver driver, int durationOfSeconds, WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationOfSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
