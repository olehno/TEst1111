package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ProductPage {
    WebDriver driver;

    // Locators
    By addToCartButton = By.cssSelector("input[class='button-1 add-to-cart-button']");
    By Qty = By.xpath("//*[contains(@class, 'qty-input')]");
    By shoppingCart = By.cssSelector("a[class='ico-cart']");
    By notificationTurnOff = By.cssSelector("span[class='close']");
    By materialSelect = By.id("product_attribute_71_9_15");
    By jewelryLength = By.cssSelector("input[class='textbox']");
    By addToCompareListButton = By.cssSelector("input[class='button-2 add-to-compare-list-button']");

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAddToCart() {
        driver.findElement(addToCartButton).click();
    }

    public void Qty(String amount) {
        driver.findElement(Qty).clear();
        driver.findElement(Qty).sendKeys(amount);
    }

    public void clickShoppingCart() {
        driver.findElement(shoppingCart).click();
    }

    public void turnOffNotification() {
        driver.findElement(notificationTurnOff).click();
    }

    public void clickMaterial(String material) {
        WebElement selectElement = driver.findElement(materialSelect);
        Select select = new Select(selectElement);

        List<WebElement> options = select.getOptions();

        for (WebElement option : options) {
            if (option.getText().equals(material)) {
                option.click();
                break;
            }
        }
    }

    public void clickJewelryLength(String jewelryLength) {
        driver.findElement(this.jewelryLength).clear();
        driver.findElement(this.jewelryLength).sendKeys(jewelryLength);
    }

    public void clickAddToCompareList() {
        driver.findElement(addToCompareListButton).click();
    }

}
