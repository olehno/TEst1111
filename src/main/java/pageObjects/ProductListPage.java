package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductListPage {
    WebDriver driver;

    // Locators

    public ProductListPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickProduct(String product) {
        driver.findElement(By.xpath("//h2[@class='product-title']/a[text() = '" + product + "']")).click();
    }

    public void clickSubcategory(String subcategory) {
        driver.findElement(By.xpath("//h2[@class='title']/a[@href = '/" + subcategory.toLowerCase() + "']")).click();
    }
}
