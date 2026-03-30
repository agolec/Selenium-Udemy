package org.example.sandbox;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserActivities {
    public static void main(String[] args) throws InterruptedException {
        final String CHROME_DRIVER = "webdriver.chrome.driver";
        System.setProperty(CHROME_DRIVER, System.getProperty("user.dir") + "/src/main/java/org/example/core/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get("https://rahulshettyacademy.com");
        Thread.sleep(4000);
        driver.manage().window().minimize();
        driver.navigate().to("http://google.com");
        Thread.sleep(2000);
        driver.navigate().back();
        driver.close();
    }
}
