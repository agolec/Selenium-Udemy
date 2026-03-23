package org.example.config;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;

public class Config {
    private static final String CHROME_DRIVER = "webdriver.chrome.driver";
    private static final String USER_DIRECTORY = System.getProperty("user.dir") + "/src/main/java/org/example/core/drivers/chromedriver.exe";

    @BeforeMethod
    public void setChromeDriverProperty(){
        System.setProperty(CHROME_DRIVER, USER_DIRECTORY);

    }
}
