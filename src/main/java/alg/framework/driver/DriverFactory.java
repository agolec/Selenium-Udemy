package alg.framework.driver;

import alg.framework.config.ConfigReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class DriverFactory {
    public static WebDriver createDriver() {
        String browser = ConfigReader.getProperty("browser");

        WebDriver driver;

        switch(browser.toLowerCase()){
            case "chrome":
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")
                        + "/src/main/java/org/example/core/drivers/chromedriver.exe" );
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver",
                        System.getProperty("user.dir")
                                + "/src/main/java/org/example/core/drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            default:
                throw new RuntimeException("unsupported browser");
        }


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.manage().window().maximize();
        return driver;
    }
}
