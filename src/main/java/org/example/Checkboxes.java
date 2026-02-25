package org.example;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Checkboxes {
    public static void main(String[] args) throws InterruptedException {
        final String CHROME_DRIVER = "webdriver.chrome.driver";
        System.setProperty(CHROME_DRIVER, System.getProperty("user.dir") + "/src/main/java/org/example/core/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        Thread.sleep(2000);
        WebElement seniorCitizen = driver.findElement(By.cssSelector("input[id='ctl00_mainContent_chk_SeniorCitizenDiscount']"));
        seniorCitizen.click();// * for regex

        boolean expectedSelection = true;
        boolean actualSelection = seniorCitizen.isSelected();

        Assert.isTrue(expectedSelection,"Error. Element not selected");
        System.out.println("end program");

        int expectedCheckboxCount = 6;
        List<WebElement> elements = driver.findElements(By.cssSelector("input[type='checkbox']"));
        if(elements.size() == expectedCheckboxCount){
            System.out.println("true");
        } else {
            System.out.println("false");
        }
        System.out.println(elements.size());
    }
}
