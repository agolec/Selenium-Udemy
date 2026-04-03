package alg.framework.tests;

import alg.framework.base.BaseTest;
import alg.framework.pages.ProductPage;
import alg.framework.pages.LoginPage;
import alg.framework.utils.LoginTestData;
import alg.framework.utils.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "validLogins", dataProviderClass = TestDataProvider.class)
    public void validLoginTest(LoginTestData data){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApplication(data.username,data.password);

        if(data.expectedSuccess){
            ProductPage productPage = new ProductPage(driver);
            Assert.assertTrue(productPage.isInventoryPageDisplayed());
        } else {
            Assert.assertTrue(loginPage.isErrorDisplayed());
        }
        ProductPage productPage = new ProductPage(driver);

        Assert.assertTrue(productPage.isInventoryPageDisplayed());
    }
    @Test(dataProvider = "invalidLogins", dataProviderClass = TestDataProvider.class)
    public void invalidLogins(LoginTestData data){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApplication(data.username, data.password);

        Assert.assertTrue(loginPage.isErrorDisplayed());
    }


}
