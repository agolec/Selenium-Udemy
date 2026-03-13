package alg.framework.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    private final int TIMEOUT = 10;
    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    protected void click(By locator){
        driver.findElement(locator).click();
    }

    /**
     *
     * @param locator element on the page you intend to type text into.
     * @param text the text you are going to type into this field on the page.
     */
    protected void type(By locator,String text){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        element.clear();
        driver.findElement(locator).sendKeys(text);
    }
    protected String getText(By locator){
        return driver.findElement(locator).getText();
    }
    protected boolean isElementDisplayed(By locator){
        return driver.findElement(locator).isDisplayed();
    }
}
