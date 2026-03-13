package alg.framework.driver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {
    @Override
    public void createWebDriver(){
        ChromeOptions options = new ChromeOptions();
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")
                + "/src/main/java/org/example/core/drivers/chromedriver.exe" );
        this.driver = new ChromeDriver(options);
    }
}
