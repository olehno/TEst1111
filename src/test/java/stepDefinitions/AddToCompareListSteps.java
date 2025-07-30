package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.ProductPage;

import static org.junit.Assert.assertEquals;

public class AddToCompareListSteps {
    private WebDriver driver;
    private ProductPage productPage;

    private static final String SITE = "https://demowebshop.tricentis.com";

    public AddToCompareListSteps() {
        this.driver = Hooks.driver;
        productPage = new ProductPage(driver);
    }

    @And("^I click add to compare list$")
    public void iClickAddToCompareList() {
        productPage.clickAddToCompareList();
    }

    @And("^I check if \"([^\"]*)\" is in the compare list$")
    public void iCheckIfIsInTheCompareList(String productName) {
        String temp = String.format("/%s", productName.toLowerCase());
        String temp2 = temp.replace(" ", "-");
        String hrefString = temp2.replace(".", "");
        assertEquals(productName, driver.findElement(By.cssSelector("a[href = '" + hrefString + "']")).getText());
    }
}
