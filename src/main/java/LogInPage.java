import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class LogInPage extends FunctionExtension{
    private WebDriver driver;
    public LogInPage(WebDriver driver) {
        this.driver = driver;
        System.out.println("driver in constructor=" + driver);

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

    public void logIn() throws InterruptedException {
        System.out.println("driver on page=" + driver);
        emailField.sendKeys("vlasiuk.andrii39@gmail.com");
        nextButton.click();
        //waitForJSinactivity(driver);
        sleep(3000);
        passwordField.sendKeys("3141592653531415926535");
        signInButton.click();
        sleep(5000);
    }
    /* ну вобщем веб элементы я проинициализировал,
    дальше он не находит элемент пассворд,
   как я понял потому что после клацанья на кнопку далее кнопка пассворд появляется не моментально,
   а клацанье на кнопку логин происходит сразу же после нажатия на кнопку далее
    * завтра звони
    * спок
    */

    public void assertIsAuthorised(){
        accountLink.isDisplayed();
    }

    public void init(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
}
