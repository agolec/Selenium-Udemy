package org.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxBinary;

public class Main {
    public static void main(String[] args) {
        //final String CHROME_DRIVER = "webdriver.chrome.driver";
        final String GECKO_DRIVER = "webdriver.gecko.driver";
        //chromedriver setup
        //System.setProperty(CHROME_DRIVER, System.getProperty("user.dir") + "/src/main/java/org/example/core/drivers/chromedriver.exe");

       // WebDriver driver = new ChromeDriver();

        //Firefox Launch
        WebDriver driver = new FirefoxDriver();

        driver.get("https://rahulshettyacademy.com");
        System.out.println(driver.getTitle());
        driver.quit();

    }
}