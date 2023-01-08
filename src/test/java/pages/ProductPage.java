package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.Driver;
import utils.Helper;

public class ProductPage {
    public Helper helper;

    public ProductPage() {
        PageFactory.initElements(Driver.get(), this);
        helper = new Helper();
    }

    @FindBy(xpath = "//span[contains(@class,'caption-subject')]")
    public WebElement productPageTitle;

    @FindBy(css = ".btn.btn-sm.green.btn-circle")
    public WebElement addProductBtn;

    @FindBy(id = "product_images")
    public WebElement imageInput;

    @FindBy(id = "product_name_en")
    public WebElement productNameEN;

    @FindBy(id = "product_name_ar")
    public WebElement productNameAR;

    @FindBy(id = "product_category")
    public WebElement productCategory;

    @FindBy(id = "product_price")
    public WebElement productPrice;

    @FindBy(css = ".btn.blue.submit-form-product")
    public WebElement submitBtn;

    @FindBy(css = ".toast-message")
    public WebElement notification;

    @FindBy(name = "product_name_en")
    public WebElement thumbnail;

    @FindBy(id = "filter")
    public WebElement searchBtn;

    @FindBy(xpath = "//button[text()='Ok' and @class='btn btn-success']")
    public WebElement OkBtn;

    @FindBy(css = ".dataTables_empty")
    public WebElement dataTableNotification;


    public void IShouldSeeProductPageTitle() {
        Assert.assertEquals("PRODUCTS", productPageTitle.getText());
    }

    public void clickAddProductBtn() {
        helper.clickElement(addProductBtn);
    }

    public void uploadImage(String imageLocation) {
        String location = System.getProperty("user.dir") + "\\src\\test\\resources\\images\\" + imageLocation;

        helper.sendKeysElementNotWait(imageInput, location);
    }

    public void fillNameEN(String productEN) {
        helper.sendKeysElement(productNameEN, productEN);
    }

    public void fillNameAR(String productAR) {
        helper.sendKeysElement(productNameAR, productAR);
    }

    public void selectCategory(String category) {
        Select prCategory = new Select(productCategory);
        prCategory.selectByVisibleText(category);
    }

    public void fillPrice(String price) {
        helper.sendKeysElement(productPrice, price);
    }

    public void clickSubmitBtn() {
        helper.clickElement(submitBtn);
    }

    public void IShouldSeeSuccessfullyAdded(String textNotification) {
        Assert.assertEquals(textNotification, notification.getText());
    }

    public void fillThumbnailFeild(String productName) {
        helper.sendKeysElement(thumbnail, productName);
    }

    public void clickSearchBtn() {
        helper.clickElement(searchBtn);
    }

    public void clickProductUpdateBtn(String productName) {
        WebElement updateBtn = Driver.get().findElement(By.xpath("//*[text()='" + productName + "']//ancestor::tr//i[@class='fa fa-edit']"));
        helper.clickElement(updateBtn);
    }

    public void clickProductDeleteBtn(String productName) {
        WebElement deleteBtn = Driver.get().findElement(By.xpath("//*[text()='" + productName + "']//ancestor::tr//i[@class='fa fa-trash']"));
        helper.clickElement(deleteBtn);
    }

    public void clickOkBtn() {
        helper.clickElement(OkBtn);
    }

    public void checkNotExist(String notification) {
        Assert.assertEquals(dataTableNotification.getText(), notification);
    }
}
