package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage extends BasePage{

    public AccountPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Sign out")
    private WebElement signOutButton;

    @FindBy(xpath = "//*[@id='center_column']//*[@title='Orders']")
    private WebElement OrderHistoryButton;

    @FindBy(xpath = "//*[@id='center_column']//*[@title='My wishlists']")
    private WebElement wishListsButton;

    @FindBy(xpath = "//*[@id='center_column']//*[@title='Credit slips']")
    private WebElement creditSlipsButton;

    @FindBy(xpath = "//*[@id='center_column']//*[@title='Addresses']")
    private WebElement addressesButton;

    @FindBy(xpath = "//*[@id='center_column']//*[@title='Information']")
    private WebElement personalInformationButton;

    public void verifyAccountPage() {
        signOutButton.isDisplayed();
        OrderHistoryButton.isDisplayed();
        wishListsButton.isDisplayed();
        creditSlipsButton.isDisplayed();
        addressesButton.isDisplayed();
        personalInformationButton.isDisplayed();
    }

    public void clickSignOut() {
        signOutButton.click();
    }
}
