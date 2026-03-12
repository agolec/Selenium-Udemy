package alg.framework.tests;

import alg.framework.base.BaseTest;
import alg.framework.pages.InventoryPage;
import alg.framework.pages.LoginPage;
import alg.framework.utils.TestDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "validLogins", dataProviderClass = TestDataProvider.class)
    public void validLoginTest(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApplication(username,password);

        InventoryPage inventoryPage = new InventoryPage(driver);

        Assert.assertTrue(inventoryPage.isInventoryPageDisplayed());
    }
    @Test(dataProvider = "invalidLogins", dataProviderClass = TestDataProvider.class)
    public void invalidLogins(String username, String password){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApplication(username,password);

        Assert.assertTrue(loginPage.isErrorDisplayed());
    }


}
