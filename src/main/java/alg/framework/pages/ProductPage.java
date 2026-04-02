package alg.framework.pages;

import alg.framework.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage extends BasePage {
    private By inventoryContainer = By.id("inventory_container");

    public ProductPage(WebDriver driver){
        super(driver);
    }
    public boolean isInventoryPageDisplayed(){
        return isDisplayed(inventoryContainer);
    }
}
