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

    @FindBy(css = "div.nH.Hd")
    private WebElement newMessagePanel;

    @FindBy(xpath = "//table[@class='F cf zt']//tbody/tr[1]")
    private WebElement lastMessage;

    @FindBy(css = "h2.hP")
    private WebElement letterTopic;

    @FindBy(xpath = "//div[@class='gs']/div/div/div[1]")
    private WebElement letterBody;


    public void assertContentOnPage(){
        inboxMailList.isDisplayed();
        createNewMessageButton.isDisplayed();
        menuList.isDisplayed();
    }

    public void sendNewLetter(String sendTo, String topic, String letterBody) {
        createNewMessageButton.click();
        waitForJSinactivity(driver);
        sendToField.sendKeys(sendTo);
        emailTopicField.sendKeys(topic + currentDateAndTime());
        emailTextArea.sendKeys(letterBody);
        //attachFile(driver, "home/qwerty/Programming/GmailAutotests/pom.xml", "div.a1.aaA.aMZ");
        waitForJSinactivity(driver);
        sendLetterButton.click();
        waitForJSinactivity(driver);
        elementIsNotDisplayed(driver, "div.nH.Hd"); //newMessagePanel
    }

    public void verifyLetterCame(String topic, String letterBodyText) {
        lastMessage.click();
        verifyLetterContent(topic, letterBodyText);
    }

    private void verifyLetterContent(String topic, String letterBodyText) {
        letterTopic.getText().contains(topic);
        letterBody.getText().contains(letterBodyText);
    }
}
