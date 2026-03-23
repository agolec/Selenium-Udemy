package org.example.assignments;

import org.example.config.Config;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AngularPracticePage extends Config {
    ChromeDriver driver;
    private final String name = "input.form-control[name='name']";
    private String email = ".form-control[name='email']";
    private String password = ".form-control[placeholder='Password']";
    private String loveIceCream = ".form-check #exampleCheck1";
    private String gender = "#exampleFormControlSelect1";
    private String employmentStatusRadioButtons = ".form-check-input";
    private String bday = ".form-control[name='bday']";
    private String submit = ".btn-success";
    private String successMessage = "div.alert-success";
    enum Gender {MALE, FEMALE}

    @Test
    void angularPracticeTest(){
        driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        type(driver,this.name,"Sigourney Weaver");
        type(driver,this.email,"someEmail@mail.com");
        type(driver,this.password,"password123");
        click(driver,this.loveIceCream);
        selectGender(driver,this.gender,Gender.FEMALE);
        selectEmploymentStatus(driver,this.employmentStatusRadioButtons,"Student");
        type(driver,this.bday,"10/08/1949");
        click(driver,this.submit);

        Assert.assertTrue(isVisible(driver,successMessage));

    }

    private void click(ChromeDriver driver, String locator) {
        driver.findElement(By.cssSelector(locator)).click();
    }

    void type(WebDriver driver,String locatorString, String text){
        driver.findElement(By.cssSelector(locatorString)).sendKeys(text);
    }
    void selectGender(WebDriver driver, String locatorString,Gender gender){
        WebElement selectDropdown = driver.findElement(By.cssSelector(locatorString));
        Select genderDropdown = new Select(selectDropdown);
        switch(gender) {
            case MALE -> genderDropdown.selectByVisibleText("Male");
            case FEMALE -> genderDropdown.selectByVisibleText("Female");
        }
    }
    void selectEmploymentStatus(WebDriver driver, String locator,String target){
        List<WebElement> labels = driver.findElements(By.xpath("//input[@type='radio']/following-sibling::label"));

        for (WebElement label : labels) {
            String text = label.getText().trim();

            if (text.equalsIgnoreCase(target)) {
                WebElement radio = label.findElement(By.xpath("./preceding-sibling::input[@type='radio']"));
                radio.click();
                break;
            }
        }
    }
    boolean isVisible(WebDriver driver,String locator){
        return driver.findElement(By.cssSelector(locator)).isDisplayed();
    }
    @AfterMethod
    void tearDown(){
        driver.quit();
    }


}
