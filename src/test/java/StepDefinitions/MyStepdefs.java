package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import utils.Helper;

public class MyStepdefs {
    LoginPage loginPage;
    HomePage homePage;
    ProductPage productPage;
    Helper helper;

    public MyStepdefs() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        productPage = new ProductPage();
        helper = new Helper();
    }

    @Given("I go to upayment login page")
    public void IGoToUpaymentLoginPage() {
        helper.navigateToUrl("https://upay.upayments.com/merchant/logout");
    }

    @When("I fill in the username field {string}")
    public void IFillInTheUsernameField(String email) {
        loginPage.fillEmailField(email);
    }

    @And("I fill in the password field {string}")
    public void IFillInThePasswordField(String password) {
        loginPage.fillPasswordField(password);
    }

    @And("I click the login button")
    public void IClickTheLoginButton() {
        loginPage.clickSignInBtn();
    }

    @And("I click on the store area from the menu")
    public void IClickOnThStoreAreaFromTheMenu() {
        homePage.ClickMenuStore();
    }

    @And("I click on the product field from the store menu area")
    public void IClickOnTheProductFieldFromTheStoreMenuArea() {
        homePage.ClickMenuProduct();
    }

    @Then("I see the product page open")
    public void ISeeTheProductPageOpen() {
        productPage.IShouldSeeProductPageTitle();
    }

    @Given("I click the Add Product button")
    public void IClickTheAddProductButton() {
        productPage.clickAddProductBtn();
    }

    @When("I am uploading the product image {string}")
    public void IAmUploadingTheProductImage(String imageLocation) {
        productPage.uploadImage(imageLocation);
    }

    @And("I enter the product name {string} EN")
    public void IEnterTheProductNameEN(String productNameEN) {
        productPage.fillNameEN(productNameEN);
    }

    @And("I enter the product name {string} AR")
    public void IEnterTheProductNameAR(String productNameAR) {
        productPage.fillNameAR(productNameAR);
    }

    @And("I select the product category {string}")
    public void ISelectTheProductCategory(String categoryName) {
        productPage.selectCategory(categoryName);
    }

    @And("I enter the product price {string}")
    public void IEnterTheProductPrice(String price) {
        productPage.fillPrice(price);
    }

    @And("I click the Submit button")
    public void IClickTheSubmitButton() {
        productPage.clickSubmitBtn();
    }

    @Then("I see {string} in notification area")
    public void ISeeInNotificationArea(String notification) {
        productPage.IShouldSeeSuccessfullyAdded(notification);
    }

    @Given("I fill {string} in the Thumbnail field")
    public void IFillInTheThumbnailField(String enProduct) {
        productPage.fillThumbnailFeild(enProduct);
    }

    @When("I click the search button")
    public void IClickTheSearchButton() {
        productPage.clickSearchBtn();
    }

    @And("I click the update button of the filtered {string} product")
    public void IClickTheUpdateButtonOfTheFilteredProduct(String productName) {
        productPage.clickProductUpdateBtn(productName);
    }

    @And("I click the delete button of the filtered product {string}")
    public void IClicTheDeleteButtonOfTheFilteredProduct(String productName) {
        productPage.clickProductDeleteBtn(productName);
    }

    @And("Are you sure? I click the OK button on the notification")
    public void AreYouSureIClickTheOKButtonOnTheNotification() {
        productPage.clickOkBtn();
    }

    @Then("I'm verifying that the {string} notification shows no data in the table")
    public void ImverifyingThatTheNotificationShowsNoDataInTheTable(String notification) {
        productPage.checkNotExist(notification);
    }
}
