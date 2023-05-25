package org.example;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxBinary;

import java.time.Duration;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //final String CHROME_DRIVER = "webdriver.chrome.driver";
        //final String GECKO_DRIVER = "webdriver.gecko.driver";
        final String EDGE_DRIVER = "webdriver.edge.driver";
        //chromedriver setup
        //System.setProperty(CHROME_DRIVER, System.getProperty("user.dir") + "/src/main/java/org/example/core/drivers/chromedriver.exe");

        // WebDriver driver = new ChromeDriver();

        //Firefox Launch
        //WebDriver driver = new FirefoxDriver();

        //Edge Launch
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("rahul");
        driver.findElement(By.name("inputPassword")).sendKeys("lol");
        //driver.findElement(By.className("signInBtn")).click();
        driver.findElement(By.cssSelector("button.signInBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        System.out.println(driver.getTitle());
        driver.quit();

    }
}