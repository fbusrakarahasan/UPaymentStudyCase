package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.Helper;

public class HomePage {
    public Helper helper;

    public HomePage() {
        PageFactory.initElements(Driver.get(), this);
        helper = new Helper();
    }

    @FindBy(xpath = "//span[@class='title' and text()='Store']")
    public WebElement menuStore;

    @FindBy(xpath = "//a[text()='Products']")
    public WebElement menuProduct;

    public void ClickMenuStore() {
        helper.clickElement(menuStore);
    }

    public void ClickMenuProduct() {
        helper.clickElement(menuProduct);
    }


}
