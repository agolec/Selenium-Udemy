package alg.framework.driver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager {
    @Override
    public void createWebDriver() {
        FirefoxOptions options = new FirefoxOptions();
        System.setProperty("webdriver.gecko.driver",
                System.getProperty("user.dir")
                        + "/src/main/java/org/example/core/drivers/geckodriver.exe");
        this.driver = new FirefoxDriver(options);
    }
}
