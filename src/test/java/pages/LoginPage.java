package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.Helper;

public class LoginPage {
    public Helper helper;

    public LoginPage() {
        PageFactory.initElements(Driver.get(), this);
        helper = new Helper();
    }

    @FindBy(name = "email")
    public WebElement emailField;

    @FindBy(name = "password")
    public WebElement passwordField;

    @FindBy(css = ".signin.btn")
    public WebElement signInBtn;

    public void fillEmailField(String email) {
        helper.sendKeysElement(emailField, email);
    }

    public void fillPasswordField(String password) {
        helper.sendKeysElement(passwordField, password);
    }

    public void clickSignInBtn() {
        helper.clickElement(signInBtn);
    }
}
