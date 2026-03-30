package org.example.assignments.synchronization;

import org.example.assignments.synchronization.pages.CheckoutPage;
import org.example.assignments.synchronization.pages.LoginPage;
import org.example.assignments.synchronization.pages.ProductPage;
import org.example.config.Config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class SyncronizationWithExplicitWait extends Config {
    WebDriver driver;
    @Test
    void loginTest(){
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().fullscreen();
        LoginPage page = new LoginPage(driver);
        ProductPage productPage = page.loginExpectingSuccess("rahulshettyacademy","Learning@830$3mK2","Consultant","User");
        productPage.clickAllAddToCartButtons();
        CheckoutPage checkout = productPage.goToCart();
        ArrayList<String> test = checkout.getProductTitles();
        ArrayList<String> expectedTitles = new ArrayList<>(Arrays.asList("iphone X","Samsung Note 8","Nokia Edge","Blackberry"));
        Assert.assertEquals(test,expectedTitles,"Error: expected titles '" + expectedTitles.toString() + "' but received '" + test.toString());
        driver.quit();
    }
}
