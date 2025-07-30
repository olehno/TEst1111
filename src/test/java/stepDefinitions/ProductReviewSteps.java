package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pageObjects.ProductPage;

import java.util.List;
import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class ProductReviewSteps {
    private WebDriver driver;
    private ProductPage productPage;
    private final String email = "testuser_" + UUID.randomUUID() + "@example.com";
    private final String password = "Test@1234";

    private static final String SITE = "https://demowebshop.tricentis.com";

    public ProductReviewSteps() {
        this.driver = Hooks.driver;
        productPage = new ProductPage(driver);
    }

    @Then("^I click register$")
    public void iClickRegister() {
        driver.findElement(By.cssSelector("a[class = 'ico-register']")).click();
    }

    @And("User registers")
    public void userRegisters() {
        driver.findElement(By.id("gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Test");
        driver.findElement(By.id("LastName")).sendKeys("User");
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
        driver.findElement(By.id("register-button")).click();

        driver.findElement(By.xpath("//input[@value='Continue']")).click();
    }

    @Then("^I click agree to terms$")
    public void iClickAgreeToTerms() {
        driver.findElement(By.id("termsofservice")).click();
    }

    @And("^I click checkout$")
    public void iClickCheckout() {
        driver.findElement(By.id("checkout")).click();
    }

    @Then("^I input billing address fields$")
    public void iInputBillingAddressFields() {
        List<WebElement> addressDropdown = driver.findElements(By.xpath("//select[@id='billing-address-select']"));
        if (!addressDropdown.isEmpty() && addressDropdown.get(0).isDisplayed()) {
            driver.findElement(By.xpath("//input[contains(@class, 'new-address-next-step-button')]")).click();
        } else {
            WebElement countryElem = driver.findElement(By.xpath("//select[@id='BillingNewAddress_CountryId']"));
            new Select(countryElem).selectByVisibleText("Aruba");

            driver.findElement(By.xpath("//input[@id='BillingNewAddress_City']"))
                    .sendKeys("City");
            driver.findElement(By.xpath("//input[@id='BillingNewAddress_Address1']"))
                    .sendKeys("Address");
            driver.findElement(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']"))
                    .sendKeys("Zip");
            driver.findElement(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']"))
                    .sendKeys("55555555555");
        }
    }

    @And("^I click continue for all forms$")
    public void iClickContinueForAllForms() {
        List<WebElement> buttons = driver.findElements(By.xpath("//input[@class ='button-1 new-address-next-step-button']"));
        buttons.get(0).click();
        buttons.get(1).click();
        driver.findElement(By.xpath("//input[@class ='button-1 shipping-method-next-step-button']")).click();
        driver.findElement(By.xpath("//input[@class ='button-1 payment-method-next-step-button']")).click();
        driver.findElement(By.xpath("//input[@class ='button-1 payment-info-next-step-button']")).click();
    }

    @Then("^I click confirm$")
    public void iClickConfirm() {
        driver.findElement(By.xpath("//input[@class ='button-1 confirm-order-next-step-button']")).click();
    }

    @Then("^I click on click here for order details$")
    public void iClickHereForOrderDetails() {
        driver.findElement(By.linkText("Click here for order details.")).click();
    }

    @And("^I click on \"([^\"]*)\"$")
    public void iClickOn(String product) {
        String productLower = product.toLowerCase();
        driver.findElement(By.cssSelector("a[href='/" + productLower + "']")).click();
    }

    @Then("^I click on review$")
    public void iClickOnReview() {
        driver.findElement(By.xpath("//*[contains(text(), 'Add your review')]")).click();
    }

    @And("^I write a review with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void iWriteAReviewWithAnd(String title, String review) {
        driver.findElement(By.id("AddProductReview_Title")).sendKeys(title);
        driver.findElement(By.id("AddProductReview_ReviewText")).sendKeys(review);
        driver.findElement(By.id("addproductrating_4")).click();
    }

    @Then("^I submit a review$")
    public void iSubmitAReview() {
        WebElement addReview = driver.findElement(By.name("add-review"));
        addReview.click();
    }

    @And("^I verify the success message$")
    public void iVerifyTheSuccessMessage() {
        WebElement result = driver.findElement(By.className("result"));
        assertEquals("Product review is successfully added.", result.getText().trim());
    }

    @Then("^I check the review box message$")
    public void iCheckTheReviewBoxMessage() {
        assertEquals("Only registered users can write reviews", driver.findElement(By.className("validation-summary-errors")).getText().trim());
    }

    @And("^I check review title and message input fields are blocked$")
    public void iCheckReviewTitleAndMessageInputFieldsAreBlocked() {
        assertEquals("true", driver.findElement(By.id("AddProductReview_Title")).getAttribute("disabled"));
        assertEquals("true", driver.findElement(By.id("AddProductReview_ReviewText")).getAttribute("disabled"));
    }
}
