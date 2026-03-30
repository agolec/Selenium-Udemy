package org.example.assignments.synchronization.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductPage {
    private WebDriver driver;
    private By productBy = By.cssSelector("div.card-footer button");
    private By checkoutButton = By.xpath("//a[contains(text(),'Checkout')]");
    private WebDriverWait wait;
    public ProductPage(WebDriver driver){

        this.driver = driver;
        this.driver.manage().window().maximize();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(5));

        wait.until(ExpectedConditions.titleIs("ProtoCommerce"));
    }
    public List<WebElement> getCartButtons(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productBy));
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(productBy));
    }
    public void clickAllAddToCartButtons(){
        List<WebElement> addButtons = getCartButtons();

        for(int i = 0; i < addButtons.size();i++){
            addButtons.get(i).click();
        }
    }
    public void clickCheckoutButton(){
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }
    public CheckoutPage goToCart(){
        this.clickCheckoutButton();
        return new CheckoutPage(this.driver);
    }
}
