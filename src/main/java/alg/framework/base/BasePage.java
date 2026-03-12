package alg.framework.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
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
        driver.findElement(locator).sendKeys(text);
    }
    protected String getText(By locator){
        return driver.findElement(locator).getText();
    }
}
