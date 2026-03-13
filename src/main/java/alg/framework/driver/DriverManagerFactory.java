package alg.framework.driver;

import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManagerFactory {
    public static DriverManager getDriverManager(DriverType type){
        DriverManager driverManager;

        switch(type){
            case FIREFOX:
                driverManager = new FirefoxDriverManager();
                break;
            default:

                driverManager = new ChromeDriverManager();
                break;
        }
        return driverManager;
    }
}
