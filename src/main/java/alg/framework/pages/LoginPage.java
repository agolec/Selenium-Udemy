package alg.framework.pages;

import alg.framework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private WebDriver driver;

    private By username = By.id("user-name");
    private By password = By.id("password");
    private By loginButton = By.id("login-button");
    
    public LoginPage(WebDriver driver){
        super(driver);
    }
    public void enterUserName(String usernameText){
        type(this.username,usernameText);
    }
    public void enterPassword(String passwordText){
        type(this.password,passwordText);
    }
    public void clickLogin(){
        click(this.loginButton);
    }

    public void loginToApplication(String username, String password){
        enterUserName(username);
        enterPassword(password);
        clickLogin();
    }
}
