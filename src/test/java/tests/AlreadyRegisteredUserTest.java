package tests;

import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.*;
import utils.DriverFactory;
import utils.WebElementUtils;

import static utils.Config.PASSWORD;
import static utils.Config.USERNAME;
import static utils.Config.URL;

public class AlreadyRegisteredUserTest {

    public HomePage homePage;
    public AuthenticationPage authenticationPage;
    public ForgotPasswordPage forgotPasswordPage;
    public AccountPage accountPage;
    public RegistrationPage registrationPage;

    public WebDriver driver;
    public String invalidEmailAddressFormat = "badformemail";
    public String unRegisteredEmailAddress = "unregistererd@unregistered.com";
    public String invalidPasswordFormat= "nope";
    public String wrongPassword = "wellFormattedWrongPassword";
    public String invalidEmailErrorMessage = "Invalid email address.";
    public String emptyEmailErrorMessage = "An email address required.";
    public String authFailErrorMessage = "Authentication failed.";
    public String invalidPasswordErrorMessage = "Invalid password.";

    @BeforeClass(alwaysRun = true)
    public void setUp(){
        driver = DriverFactory.getDriver();
        driver.get(URL);
        homePage = new HomePage();
        authenticationPage = homePage.clickSignInButton();
        authenticationPage.verifyAuthenticationPage();
    }

    @AfterMethod
    public void navigateToHome() {
        driver.get(URL);
        authenticationPage = homePage.clickSignInButton();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        DriverFactory.closeDriver();
    }

    @Test
    @Description("Registration Test")
    public void registrationTest() {
        String email = WebElementUtils.randomEmailGenerator();
        registrationPage = authenticationPage.submitRegistrationRequest(email);
        registrationPage.verifyEmail(email);
        String salutation = "mr";
        String firstname = "Test";
        String lastname = "Set";
        String password = "test123";
        String date = "1";
        String month = "2";
        String year = "1993";
        String comp = "Hello Company";
        String add1 = "Flat, Street";
        String add2 = "Area";
        String city = "Alaska";
        String zip = "99501";
        String state = "2";
        String phone = "01987651234";
        String mobile = "01987651234";
        String info = "hello check";
        accountPage = registrationPage.RegisterWithData(salutation, firstname, lastname, password, date,
                month, year,  true,  true, comp,
                add1, add2, city, state, zip, info, phone, mobile);
        accountPage.clickSignOut();
    }

    @Test
    @Description("Forgot password link test")
    public void forgotPasswordTest() {
        forgotPasswordPage = authenticationPage.clickForgotPassword();
        forgotPasswordPage.verifyForgotPasswordPage();
    }

    @Test
    @Description("Login with wrong formatted email")
    public void loginUsingInvalidEmailFormat() {
        authenticationPage.enterEmailAddress(invalidEmailAddressFormat);
        authenticationPage.clickLoginButton();
        Assert.assertTrue(authenticationPage.getErrorText().contains(invalidEmailErrorMessage));
    }

    @Test
    @Description("Login without email")
    public void loginWithOutEmail() {
        authenticationPage.enterPassword(wrongPassword);
        authenticationPage.clickLoginButton();
        Assert.assertTrue(authenticationPage.getErrorText().contains(emptyEmailErrorMessage));
    }

    @Test
    @Description("Login without email and password")
    public void loginWithOutEmailAndPassword() {
        authenticationPage.clickLoginButton();
        Assert.assertTrue(authenticationPage.getErrorText().contains(emptyEmailErrorMessage));
    }

    @Test
    @Description("Login with un-registered email")
    public void loginUsingUnregisteredEmail() {
        authenticationPage.enterEmailAddress(unRegisteredEmailAddress);
        authenticationPage.enterPassword(PASSWORD);
        authenticationPage.clickLoginButton();
        Assert.assertTrue(authenticationPage.getErrorText().contains(authFailErrorMessage));
    }

    @Test
    @Description("Login with wrong formatted password")
    public void loginUsingInvalidPasswordFormat() {
        authenticationPage.enterEmailAddress(USERNAME);
        authenticationPage.enterPassword(invalidPasswordFormat);
        authenticationPage.clickLoginButton();
        Assert.assertTrue(authenticationPage.getErrorText().contains(invalidPasswordErrorMessage));
    }

    @Test
    @Description("Login with wrong password")
    public void loginUsingInvalidPassword() {
        authenticationPage.enterEmailAddress(USERNAME);
        authenticationPage.enterPassword(wrongPassword);
        authenticationPage.clickLoginButton();
        Assert.assertTrue(authenticationPage.getErrorText().contains(authFailErrorMessage));
    }

    @Test
    @Description("Login with valid email and password")
    public void loginUsingValidEmailAndPassword() {
        authenticationPage.enterEmailAddress(USERNAME);
        authenticationPage.enterPassword(PASSWORD);
        accountPage = authenticationPage.clickLoginButton();
        accountPage.verifyAccountPage();
        accountPage.clickSignOut();
    }


}
