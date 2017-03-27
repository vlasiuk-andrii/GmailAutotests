import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class LogInPage {
    private WebDriver ldriver;
    public LogInPage(WebDriver driver) {
        this.ldriver = driver;
    }

    @FindBy(css = "input#Email")
    private WebElement emailField;

    @FindBy(id = "Next")
    private WebElement nextButton;

    @FindBy(id = "Passwd")
    private WebElement passwordField;

    @FindBy(id = "signIn")
    private WebElement signInButton;

    @FindBy(css = "a[title*=vlasiukandrii39@gmail.com]")
    private WebElement accountLink;




    public void logIn(){
        System.out.println("driver on page=" + ldriver);
        emailField.sendKeys("vlasiuk.andrii39@gmail.com");
        nextButton.click();
        passwordField.sendKeys("3141592653531415926535");
        signInButton.click();
        ldriver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }

    public void assertIsAuthorised(){
        accountLink.isDisplayed();
    }
}
