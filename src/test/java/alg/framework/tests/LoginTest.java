package alg.framework.tests;

import alg.framework.base.BaseTest;
import alg.framework.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApplication("standard_user","password");
    }

}
