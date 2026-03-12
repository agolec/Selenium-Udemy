package alg.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");
    
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }
    public void enterUserName(String username){
        driver.findElement(this.username).sendKeys(username);
    }
    public void enterPassword(String password){
        driver.findElement(this.password).sendKeys(password);
    }
    public void clickLogin(){
        driver.findElement(this.loginButton).click();
    }

    public void loginToApplication(String username, String password){
        enterUserName(username);
        enterPassword(password);
        clickLogin();
    }
}
