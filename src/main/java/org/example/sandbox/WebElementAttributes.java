package org.example.sandbox;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class WebElementAttributes {
    ChromeDriver driver;
    final String LOCATOR_PRACTICE = "https://rahulshettyacademy.com/dropdownsPractise/";
    final String RETURN_DATE_CSS = "div.picker-second button";
    final String ROUND_TRIP_BTN = "div#Div1";
    final String EXPECTED_VALUE_DISABLED = "opacity: 0.5";
    final String EXPECTED_VALUE_ENABLED = "opacity: 1";
    @Test
    void enabledAndDisabledElementsTest(){
        driver = new ChromeDriver();
        driver.get(LOCATOR_PRACTICE);

        System.out.println(getAttributeValue(ROUND_TRIP_BTN,"style"));
        //This element is enabled as far as selenium is concerned. We cannot do a findElement().isEnabled() check on it.
        //however, on this element, we have a style attribute, and the opacity value of this attribute changes with
        //the state of the page. On load, it is 0.5, and when either this element is clicked on, or round trip selected,
        //the opacity value of the style attribute becomes 1.
        Assert.assertTrue(getAttributeValue(ROUND_TRIP_BTN,"style").contains(EXPECTED_VALUE_DISABLED));
        clickElement(ROUND_TRIP_BTN);
        Assert.assertTrue(getAttributeValue(ROUND_TRIP_BTN,"style").contains(EXPECTED_VALUE_ENABLED));

    }

    public void clickElement(String selector){
        this.driver.findElement(By.cssSelector(selector)).click();
    }
    public String getAttributeValue(String selector,String attribute){
        return this.driver.findElement(By.cssSelector(selector)).getDomAttribute(attribute);
    }
    @AfterMethod
    void teardown(){
        this.driver.quit();
    }
}
