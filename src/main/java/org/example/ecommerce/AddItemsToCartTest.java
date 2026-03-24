package org.example.ecommerce;

import org.example.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class AddItemsToCartTest extends Config {
    WebDriver driver;
    @Test
    void test(){
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        //Add Cucumber into the cart. Generically setup the test so we can chose any item?
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        String text;
        for(int i = 0; i < products.size();i++){
            text = products.get(i).getText();
            if(text.contains("Cucumber")){
                List<WebElement> cartbuttons = driver.findElements(By.xpath("//button[text()='ADD TO CART']"));
                cartbuttons.get(i).click();
                break;
            }
        }
    }


}
