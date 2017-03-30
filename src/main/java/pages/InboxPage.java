package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.appendice.CommonConstants;
import pages.appendice.FunctionExtension;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class InboxPage extends FunctionExtension {

    private WebDriver driver;
    public InboxPage(WebDriver driver) {
        this.driver = driver;
    }
    public void init(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "div.ae4.aDM")
    private WebElement inboxMailList;

    @FindBy(xpath = "//div[contains(text(),'COMPOSE')]")
    private WebElement createNewMessageButton;

    @FindBy(css = "div.TK")
    private WebElement menuList;

    @FindBy(css = "textarea.vO")
    private WebElement sendToField;

    @FindBy(css = "input.aoT")
    private WebElement emailTopicField;

    @FindBy(css = "div.Am.Al.editable.LW-avf")
    private WebElement emailTextArea;

    @FindBy(css = "div.a1.aaA.aMZ")
    private WebElement attachFileButton;

    @FindBy(css = "div.T-I.J-J5-Ji.aoO.T-I-atl.L3")
    private WebElement sendLetterButton;

    public void assertContentOnPage(){
        inboxMailList.isDisplayed();
        createNewMessageButton.isDisplayed();
        menuList.isDisplayed();
    }

    public String currentDateAndTime(){
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
        return timeStamp;
    }

    public void sendNewLetter() {
        createNewMessageButton.click();
        waitForJSinactivity(driver);
        sendToField.sendKeys(CommonConstants.EMAIL);
        emailTopicField.sendKeys("TestLetter_" + currentDateAndTime());
        emailTextArea.sendKeys("LetterBody");
        sendLetterButton.click();
        waitForJSinactivity(driver);
    }
}
