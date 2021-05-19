package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends BasePage{

    @FindBy(linkText = "Sign in")
    private WebElement signInButton;


    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    public AuthenticationPage clickSignInButton(){
        signInButton.click();
        return new AuthenticationPage();
    }

}
