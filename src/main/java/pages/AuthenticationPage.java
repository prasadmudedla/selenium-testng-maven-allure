package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static utils.WebElementUtils.enterText;

public class AuthenticationPage extends BasePage{

    public AuthenticationPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "email")
    private WebElement emailField;

    @FindBy(name = "passwd")
    private WebElement passwordField;

    @FindBy(id = "SubmitLogin" )
    private WebElement loginButton;

    @FindBy(xpath = "//*[@title='Recover your forgotten password']")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//*[@class='alert alert-danger']/ol/li")
    private WebElement loginErrorAlert;

    @FindBy (id = "email_create")
    private WebElement emailCreateField;

    @FindBy (id = "SubmitCreate")
    private WebElement emailCreateSubmitField;


    public void enterEmailAddress(String userNameValue) {
        enterText(emailField,userNameValue);
    }

    public void enterPassword( String passwordValue) {
        enterText(passwordField,passwordValue);
    }

    public AccountPage clickLoginButton() {
        loginButton.click();
        return new AccountPage();
    }

    public ForgotPasswordPage clickForgotPassword() {
        forgotPasswordLink.click();
        return new ForgotPasswordPage();
    }

    public String getErrorText() { return loginErrorAlert.getText(); }

    public void verifyAuthenticationPage() {
        emailField.isDisplayed();
        passwordField.isDisplayed();
        loginButton.isDisplayed();
    }

    public RegistrationPage submitRegistrationRequest(String email) {
        emailCreateField.sendKeys(email);
        emailCreateSubmitField.click();
        return new RegistrationPage();
    }

}