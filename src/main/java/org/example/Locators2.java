package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.xml.sax.Locator;

import java.time.Duration;



public class Locators2 {

    public static void main(String[] args) throws InterruptedException {

// TODO Auto-generated method stub

//implicit wait - 2 seconds time out


        final String CHROME_DRIVER = "webdriver.chrome.driver";
        System.setProperty(CHROME_DRIVER, System.getProperty("user.dir") + "/src/main/java/org/example/core/drivers/chromedriver.exe");


        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String password = getPassword(driver);

        String name = "rahul";

        driver.findElement(By.id("inputUsername")).sendKeys(name);

        driver.findElement(By.name("inputPassword")).sendKeys(password);

        driver.findElement(By.className("signInBtn")).click();

        System.out.println(driver.findElement(By.xpath("//p[text()='You are successfully logged in.']")).getText());

        String expectedString = "You are successfully logged in.";

        WebElement locator = driver.findElement(By.xpath("//p[text()='"+ expectedString + "']"));
        String actualString = locator.getText();
        Assert.assertEquals(actualString,expectedString);
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello " + name + ",");

        driver.findElement(By.xpath("//button[text()='Log Out']")).click();

        driver.close();

    }

    public static String getPassword(WebDriver driver) throws InterruptedException {
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
        Thread.sleep(1000);
        String passwordText = driver.findElement(By.cssSelector("form p")).getText();

        String[] passwordSplit = passwordText.split("'");
        String password = passwordSplit[1].split("'")[0];
        return password;
    }
}
