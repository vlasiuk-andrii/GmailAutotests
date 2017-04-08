package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.appendice.CommonConstants;
import pages.appendice.PageExtension;

public class LogInPage extends PageExtension {

    public LogInPage() {
    }

    @FindBy(css = "input#Email")
    private WebElement emailField;

    @FindBy(id = "next")
    private WebElement nextButton;

    @FindBy(id = "Passwd")
    private WebElement passwordField;

    @FindBy(id = "signIn")
    private WebElement signInButton;

    @FindBy(css = "a.gb_b.gb_eb.gb_R")
    private WebElement accountLink;

    @FindBy(css = "span.gb_9a.gbii")
    private WebElement accountIcon;

    @FindBy(id = "gb_71")
    private WebElement signOutButton;

    @FindBy(id = "account-chooser-link")
    private WebElement accountChooserLink;

    @FindBy(xpath = "//h1[contains(text(),'One account. All of Google.')]")
    private WebElement tagline;

    @FindBy(id = "canvas")
    private WebElement accountPicture;

    @FindBy(xpath = "//a[contains(text(),'Create account')]")
    private WebElement createAccountLink;

    public void logIn()  {
        emailField.sendKeys(CommonConstants.EMAIL);
        nextButton.click();
        waitForJSinactivity(driver);
        passwordField.sendKeys(CommonConstants.PASSWORD);
        signInButton.click();
        waitForJSinactivity(driver);
    }

    public boolean isAuthorised(){
        return accountLink.isDisplayed();
    }

    public void logOut() {
        accountIcon.click();
        signOutButton.click();
        waitForJSinactivity(driver);
    }

    public boolean isNotAuthorized() {
        return accountChooserLink.isDisplayed();
    }

    public boolean isContentOnPageCorrect(){
        boolean elementsDisplayed = false;
        if (tagline.isDisplayed() &&
        accountPicture.isDisplayed() &&
        emailField.isDisplayed() &&
        createAccountLink.isDisplayed()){
            elementsDisplayed = true;
        }
        return elementsDisplayed;
    }
}
