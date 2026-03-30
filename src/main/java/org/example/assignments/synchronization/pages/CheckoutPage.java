package org.example.assignments.synchronization.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckoutPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By productName = By.cssSelector("div.media-body h4");
    CheckoutPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    }
    public ArrayList<String> getProductTitles(){
        List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productName));
        List<String> result = new ArrayList<>();
        for(WebElement product:products){
            result.add(product.getText());
        }
        return (ArrayList)result;
    }
}
