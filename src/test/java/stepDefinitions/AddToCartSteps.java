package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.ProductListPage;
import pageObjects.ProductPage;
import pageObjects.ShoppingCartPage;

import java.util.Map;
import java.util.Objects;

import static org.junit.Assert.assertEquals;

public class AddToCartSteps {
    private WebDriver driver;
    private ProductPage productPage;
    private ShoppingCartPage shoppingCartPage;
    private ProductListPage productListPage;

    private static final String SITE = "https://demowebshop.tricentis.com";

    public AddToCartSteps() {
        this.driver = Hooks.driver;
        productPage = new ProductPage(driver);
        shoppingCartPage = new ShoppingCartPage(driver);
        productListPage = new ProductListPage(driver);
    }

    @When("^User is in the demo shop page$")
    public void openDemoShopPage() {
        driver.get(SITE);
    }

    @Then("^I click \"([^\"]*)\" in the menu$")
    public void clickProductCategory(String product) {
        String productLower = product.toLowerCase();
        driver.findElement(By.cssSelector("a[href='/" + productLower + "']")).click();
    }

    @Then("^I select \"([^\"]*)\" in \"([^\"]*)\" subcategory")
    public void selectProduct(String product, String subcategory) {
        if (Objects.equals(subcategory, "")) {
            productListPage.clickProduct(product);
        } else {
            productListPage.clickSubcategory(subcategory);
            productListPage.clickProduct(product);
        }
    }

    @And("^I input quantity: \"([^\"]*)\"$")
    public void inputQuantity(String quantity) {
        productPage.Qty(quantity);
    }

    @And("^I click add to cart$")
    public void clickAddToCart() {
        productPage.clickAddToCart();
    }

    @Then("^I should see \"([^\"]*)\" \"([^\"]*)\" in the cart$")
    public void verifyProductInCart(String qty, String product) {
        assertEquals(qty, shoppingCartPage.getQty());
        assertEquals(product, shoppingCartPage.getProductName());
    }

    @Then("^I click shopping cart$")
    public void clickShoppingCart() {
        productPage.clickShoppingCart();
    }

    @And("^I turn off the notification$")
    public void turnOffNotification() {
        productPage.turnOffNotification();
    }

    @Then("^I select product options:$")
    public void iSelectProductOptions(Map<String, String> productOptions) {
        productPage.clickMaterial(productOptions.get("material"));
        productPage.clickJewelryLength(productOptions.get("length"));
    }

    @And("^I should see empty shopping cart$")
    public void iShouldSeeEmptyShoppingCart() {
        assertEquals("Your Shopping Cart is empty!", shoppingCartPage.getEmptyMessage());
    }

}
