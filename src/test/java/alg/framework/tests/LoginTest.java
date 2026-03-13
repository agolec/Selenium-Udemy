package alg.framework.tests;

import alg.framework.config.ConfigReader;
import alg.framework.driver.DriverManager;
import alg.framework.driver.DriverManagerFactory;
import alg.framework.pages.InventoryPage;
import alg.framework.pages.LoginPage;
import alg.framework.utils.LoginTestData;
import alg.framework.utils.TestDataProvider;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class LoginTest  {
    DriverManager driverManager;
    WebDriver driver;
    LoginPage loginPage;
    @BeforeMethod
    public void setup(){
        driverManager = DriverManagerFactory.getDriverManager(ConfigReader.getBrowser());
        driver = driverManager.getWebDriver();
        driver.get(ConfigReader.getProperty("baseUrl"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }



    @Test(dataProvider = "validLogins", dataProviderClass = TestDataProvider.class)
    public void validLoginTest(LoginTestData data){
        loginPage = new LoginPage(driver);
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
        loginPage = new LoginPage(driver);
        loginPage.loginToApplication(data.username, data.password);

        Assert.assertTrue(loginPage.isErrorDisplayed());
    }

    @AfterMethod
    public void tearDown(){
        driverManager.quitWebDriver();
    }
}
