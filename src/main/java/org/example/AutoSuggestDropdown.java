package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class AutoSuggestDropdown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/org/example/core/drivers/chromedriver.exe");

        ChromeOptions options = new ChromeOptions();

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        driver.findElement(By.id("autosuggest")).sendKeys("ind");
        Thread.sleep(2000);

        //you must scan selected options. You do not know if the target will match a specific order.
        //you must grab every option in the dropdown
        //scan the options
        //if your option is found, click on it.

        //write a generic xpath or css to grab all of the elements.

        //li[class..... will allow you to find every element that matches this css.
        List<WebElement> dropdownOptions = driver.findElements(By.cssSelector("li[class='ui-menu-item] a"));

        selectFromAutoSuggestDropdown(dropdownOptions);
    }
    public static void selectFromAutoSuggestDropdown(List<WebElement> dropdownoptions){
        for(WebElement option: dropdownoptions){
            if(option.getText().equalsIgnoreCase("india")){
                option.click();
                break;
            }
        }
    }

}
