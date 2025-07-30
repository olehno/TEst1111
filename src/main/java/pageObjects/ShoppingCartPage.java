package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage {
    WebDriver driver;

    // Locators
    By productName = By.cssSelector("a[class='product-name']");
    By Qty = By.cssSelector("input[class='qty-input']");
    By emptyMessage = By.cssSelector("div[class='order-summary-content']");

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getProductName() {
        return driver.findElement(productName).getText();
    }
    public String getQty() {
        return driver.findElement(Qty).getAttribute("value");
    }

    public String getEmptyMessage() {
        return driver.findElement(emptyMessage).getText();
    }

}
