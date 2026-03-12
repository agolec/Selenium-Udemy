package alg.framework.tests;

import alg.framework.base.BaseTest;
import alg.framework.pages.InventoryPage;
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
            InventoryPage inventoryPage = new InventoryPage(driver);
            Assert.assertTrue(inventoryPage.isInventoryPageDisplayed());
        } else {
            Assert.assertTrue(loginPage.isErrorDisplayed());
        }
        InventoryPage inventoryPage = new InventoryPage(driver);

        Assert.assertTrue(inventoryPage.isInventoryPageDisplayed());
    }
    @Test(dataProvider = "invalidLogins", dataProviderClass = TestDataProvider.class)
    public void invalidLogins(LoginTestData data){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginToApplication(data.username, data.password);

        Assert.assertTrue(loginPage.isErrorDisplayed());
    }


}
