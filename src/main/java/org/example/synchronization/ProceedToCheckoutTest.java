package org.example.synchronization;
import org.example.ecommerce.AddItemsToCartTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProceedToCheckoutTest {
    WebDriver driver;
    @Test
    public void testCheckout(){
        driver = new ChromeDriver();
        //pros and cons:
        //Pro: The wait is global so it makes the code clean. You only mention it once and it's
        //set across the whole lifecycle of the test.

        //Con: The wait applies to all elements of the page. Implicit wait can hide errors related to performance issues
        // if there are elements that should load in 1-2 seconds, an implicit wait will hide the defect.

        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        String[] vegetablesToFind = {"Brocolli","Cucumber","Beetroot"};

        AddItemsToCartTest hello = new AddItemsToCartTest();
        hello.addItems(driver,vegetablesToFind);

        driver.findElement(By.cssSelector("a.cart-icon")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
        //WebElement != Locator
        // driver.findElement(By.cssSelector(""); in it's entirety, this statement returns some WebElement.
        //By.cssSelector(""); is a Locator. In a WebDriverWait, you will need to enter a locator.
        WebElement promoInfo = driver.findElement(By.cssSelector("span.promoInfo"));
        System.out.println(promoInfo.getText());
    }
}
