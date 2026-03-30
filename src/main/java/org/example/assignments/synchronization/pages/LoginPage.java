package org.example.assignments.synchronization.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    String actualTitle;
    private By userNameBy = By.cssSelector("input[name='username']");
    private By passwordBy = By.cssSelector("input[name='password']");
    private By roleBy = By.cssSelector("div.form-group select");
    private By roleAdminBy = By.cssSelector("input[value='admin']");
    private By roleUserBy = By.cssSelector("input[value='user']");
    private By loginBtnBy = By.cssSelector("input#signInBtn");
    private By okayModal = By.id("okayBtn");
    WebDriver driver;
    WebDriverWait wait;
    public LoginPage(WebDriver driver){
        //writing this if condition to set getTitle() with one method call and then use the actualTitle String
        //to represent the title to avoid multiple method calls.
        String actualTitle = driver.getTitle();

        if(!actualTitle.contains("LoginPage Practise")){
            throw new IllegalStateException("This is not the login page," +
                    " current page is: " + actualTitle);
        }

        this.driver = driver;
    }
    public ProductPage loginExpectingSuccess(String username, String password, String roleOption,String radioOption){
        enterUsername(username);
        enterPassword(password);
        clickUserRadioOption();
        clickDropdown(roleOption);
        dismissModalOkay();
        clickRadioOption(radioOption);
        //click intercepted during automation run, but does not have modal during normal run.
        clickLogin();
        return new ProductPage(this.driver);
    }

    public void enterUsername(String username){
        driver.findElement(this.userNameBy).sendKeys(username);
    }

    private void enterPassword(String password) {
        driver.findElement(this.passwordBy).sendKeys(password);
    }
    private void clickUserRadioOption(){
        driver.findElement(roleUserBy).click();
    }
    private void clickAdminRadioOption(){
        driver.findElement(roleAdminBy).click();
    }
    public void dismissModalOkay(){
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(okayModal));
        wait.until(ExpectedConditions.elementToBeClickable(okayModal)).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(okayModal));
    }
    public void clickRadioOption(String option){
        switch(option.toLowerCase()){
            case "admin" -> clickAdminRadioOption();
            case "user" -> clickUserRadioOption();
        }
    }
    public void clickDropdown(String option){
        WebElement dropdown = this.driver.findElement(this.roleBy);
        Select select = new Select(dropdown);
        select.selectByVisibleText(option);
    }
    public void clickLogin(){
        driver.findElement(this.loginBtnBy).click();
    }

}
