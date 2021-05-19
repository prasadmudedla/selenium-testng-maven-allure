package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends BasePage {

    public ForgotPasswordPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(xpath = "//*[@id='form_forgotpassword']/fieldset/p/button")
    private WebElement retrievePasswordButton;

    public void verifyForgotPasswordPage() {
        emailField.isDisplayed();
        retrievePasswordButton.isDisplayed();
    }

}
