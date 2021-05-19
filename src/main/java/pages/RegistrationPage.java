package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class RegistrationPage extends BasePage {

    public RegistrationPage() {
        PageFactory.initElements(driver, this);
    }

    private Select dateSelect, monthSelect, yearSelect, stateSelect;

    @FindBy(id = "customer_firstname")
    private WebElement firstNameField;

    @FindBy(id = "customer_lastname")
    private WebElement lastNameField;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "newsletter")
    private WebElement newsLetterSignUpCheck;

    @FindBy(id = "optin")
    private WebElement specialOffersOptinCheck;

    @FindBy(id = "company")
    private WebElement companyNameField;

    @FindBy(id = "address1")
    private WebElement address1Field;

    @FindBy(id = "address2")
    private WebElement address2Field;

    @FindBy(id = "city")
    private WebElement cityField;

    @FindBy(id = "postcode")
    private WebElement postCodeField;

    @FindBy(id = "other")
    private WebElement additionalInfoField;

    @FindBy(id = "phone")
    private WebElement phoneField;

    @FindBy(id = "phone_mobile")
    private WebElement mobileField;

    @FindBy(id = "submitAccount")
    private WebElement submitButton;

    @FindBy(id = "id_gender1")
    private WebElement mrRadioButton;

    @FindBy(id = "id_gender2")
    private WebElement mrsRadioButton;

    public void verifyEmail(String email) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(mrRadioButton));
        Assert.assertEquals(email, emailField.getAttribute("value"));
    }

    public AccountPage RegisterWithData(String salutation, String firstname, String lastname, String password, String date, String month,
                                        String year, boolean newLetterSignUp, boolean offerOptIn, String comp, String add1, String add2,
                                        String city, String state, String zip, String info, String phone, String mobile) {

        dateSelect = new Select(driver.findElement(By.id("days")));
        monthSelect = new Select(driver.findElement(By.id("months")));
        yearSelect = new Select(driver.findElement(By.id("years")));
        stateSelect = new Select(driver.findElement(By.id("id_state")));

        if(salutation.equalsIgnoreCase("mr")) {
            mrRadioButton.click();
        } else {
            mrsRadioButton.click();
        }
        firstNameField.sendKeys(firstname);
        lastNameField.sendKeys(lastname);
        passwordField.sendKeys(password);
        dateSelect.selectByValue(date);
        monthSelect.selectByValue(month);
        yearSelect.selectByValue(year);
        if(newLetterSignUp)
            newsLetterSignUpCheck.click();
        if(offerOptIn)
            specialOffersOptinCheck.click();
        companyNameField.sendKeys(comp);
        address1Field.sendKeys(add1);
        address2Field.sendKeys(add2);
        cityField.sendKeys(city);
        postCodeField.sendKeys(zip);
        stateSelect.selectByValue(state);
        additionalInfoField.sendKeys(info);
        phoneField.sendKeys(phone);
        mobileField.sendKeys(mobile);
        submitButton.click();
        return new AccountPage();
    }

}
