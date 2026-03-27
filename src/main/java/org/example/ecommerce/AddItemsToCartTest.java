package org.example.ecommerce;

import org.example.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class AddItemsToCartTest extends Config {
    WebDriver driver;
    @Test
    void test(){
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        String[] vegetablesToFind = {"Brocolli","Cucumber","Beetroot"};

        //Add Cucumber into the cart. Generically setup the test so we can chose any item?
        List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));

        String[] text;
        for(int i = 0; i < products.size();i++){
            text = products.get(i).getText().split("-");
            String formattedName = text[0].trim();


            List<String> veggies = Arrays.asList(vegetablesToFind);

            int veggieCount = 0;
            if(veggies.contains(formattedName)){
                veggieCount++;
                driver.findElements(By.xpath("//div[@class='product-action'] //button")).get(i).click();
                if(veggieCount == veggies.size()){
                    break;
                }
            }
        }
    }
//Check whether the name you extracted is present or not.
    //trim the product name out of the element containing it's text.
    //convert Array of veggies into ArrayList to search it more easily.
    //?? Why are we starting as an array? Arrays use less memory. ArrayList is for more complex operations.

}
