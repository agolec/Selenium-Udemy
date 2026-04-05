package org.example.assignments;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Checkbox {


    public static void main(String[] args){

        testCheckbox();


    }
    @Test
    private static void testCheckbox() {
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        final String BMW = "bmw";
        clickCheckbox(driver,BMW);

        if(isChecked(driver,BMW)){
            System.out.println("True");
            clickCheckbox(driver,BMW);
        }
        Assert.assertFalse(isChecked(driver,BMW));
        Assert.assertEquals(totalCheckboxCount(driver).size(),3);
    }

    public static void clickCheckbox(WebDriver driver,String forValue){
        driver.findElement(By.cssSelector("label[for='" + forValue + "'] input")).click();
    }
    public static boolean isChecked(WebDriver driver, String forValue){
        return driver.findElement(By.cssSelector("label[for='" + forValue + "'] input")).isSelected();
    }
    public static List<WebElement> totalCheckboxCount(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions
                .numberOfElementsToBeMoreThan(By.cssSelector("input[id*='checkBoxOption']"),2));
    }


}
