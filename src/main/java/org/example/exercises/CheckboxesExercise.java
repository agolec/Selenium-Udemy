package org.example.exercises;

import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class CheckboxesExercise {
    public static void main(String[] args) throws InterruptedException {
        final String CHROME_DRIVER = "webdriver.chrome.driver";
        System.setProperty(CHROME_DRIVER, System.getProperty("user.dir") + "/src/main/java/org/example/core/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        WebElement firstCheckbox = driver.findElement(By.cssSelector("#checkBoxOption1"));

        Assert.assertFalse(firstCheckbox.isSelected());
        firstCheckbox.click();
        Thread.sleep(2000);
        Assert.assertTrue(firstCheckbox.isSelected());

        System.out.println("END PROGRAM");

    }
}
