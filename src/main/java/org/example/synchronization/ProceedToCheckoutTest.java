package org.example.synchronization;
import org.example.config.Config;
import org.example.ecommerce.AddItemsToCartTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProceedToCheckoutTest extends Config {
    WebDriver driver;
    @Test
    public void testCheckout(){
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        String[] vegetablesToFind = {"Brocolli","Cucumber","Beetroot"};

        AddItemsToCartTest hello = new AddItemsToCartTest();
        hello.addItems(driver,vegetablesToFind);

        driver.findElement(By.cssSelector("a.cart-icon")).click();
        driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
    }
}
