package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.appendice.CommonConstants;
import pages.appendice.FunctionExtension;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertTrue;

public class LogInPage extends FunctionExtension {

    private WebDriver driver;
    public LogInPage(WebDriver driver) {
        this.driver = driver;
    }
    public void init(WebDriver driver){
        PageFactory.initElements(driver, this);
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

    public void logInSuccess()  {
        emailField.sendKeys(CommonConstants.EMAIL);
        nextButton.click();
        waitForJSinactivity(driver);
        passwordField.sendKeys(CommonConstants.PASSWORD);
        signInButton.click();
        waitForJSinactivity(driver);
    }

    public void assertIsAuthorised(){
        accountLink.isDisplayed();
    }

    public void logOutSuccess() {
        accountIcon.click();
        signOutButton.click();
        waitForJSinactivity(driver);
    }

    public void assertIsNotAuthorized() {
        accountChooserLink.isDisplayed();
    }

    public void assertContentOnPage(){
        tagline.isDisplayed();
        accountPicture.isDisplayed();
        emailField.isDisplayed();
        createAccountLink.isDisplayed();
    }
}
