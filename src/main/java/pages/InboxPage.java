package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.appendice.CommonConstants;
import pages.appendice.FunctionExtension;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;


public class InboxPage extends FunctionExtension {

    public InboxPage(WebDriver driver) {
        super(driver);
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

    @FindBy(css = CommonConstants.NEW_MESSAGE_PANEL_LOCATOR)
    private WebElement newMessagePanel;

    @FindBy(xpath = "//table[@class='F cf zt']//tbody/tr[1]")
    private WebElement lastMessage;

    @FindBy(css = "h2.hP")
    private WebElement letterTopic;

    @FindBy(xpath = "//div[@class='gs']/div/div/div[1]")
    private WebElement letterBody;

    @FindBy(css = "img.Ha")
    private WebElement closePanelButton;

    @FindBy(xpath = "//div[@class='aim'][3]")
    private WebElement draftLink;

    @FindBy(xpath = "(//table[@class='F cf zt']//tbody/tr[1])[2]")
    private WebElement lastDraft;

    public boolean isContentOnPageCorrect(){
        boolean elementsDisplayed = false;
        if(inboxMailList.isDisplayed() &&
        createNewMessageButton.isDisplayed() &&
        menuList.isDisplayed()){
            elementsDisplayed = true;
        }
        return elementsDisplayed;
    }

    public void sendNewLetter(String sendTo, String topic, String letterBody) {
        createNewMessageButton.click();
        waitForJSinactivity(driver);
        sendToField.sendKeys(sendTo);
        emailTopicField.sendKeys(topic + currentDateAndTime());
        emailTextArea.sendKeys(letterBody);
        //attachFile("D:\\GmailAutotests\\pom.xml", "div.a1.aaA.aMZ");
        waitForJSinactivity(driver);
        sendLetterButton.click();
        waitForJSinactivity(driver);
        elementIsNotDisplayed(driver, CommonConstants.NEW_MESSAGE_PANEL_LOCATOR);
    }

    public boolean isLetterReceived(String topic, String letterBodyText) {
        lastMessage.click();
        return isLetterContentCorrect(topic, letterBodyText);
    }

    private boolean isLetterContentCorrect(String topic, String letterBodyText) {
        if (letterTopic.getText().contains(topic) &&
        letterBody.getText().contains(letterBodyText)){
            return true;
        }
        return false;
    }

    private void attachFile(String filePath, String elementCssLocator){
        StringSelection ss = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }

        driver.findElement(By.cssSelector(elementCssLocator)).click();

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

    }

    public void createNewDraft(String draftTopic, String draftBody) {
        createNewMessageButton.click();
        waitForJSinactivity(driver);
        emailTopicField.sendKeys(draftTopic + currentDateAndTime());
        emailTextArea.sendKeys(draftBody);
        waitForJSinactivity(driver);
        closePanelButton.click();
        waitForJSinactivity(driver);
        elementIsNotDisplayed(driver, CommonConstants.NEW_MESSAGE_PANEL_LOCATOR);
}

    public boolean isDraftCreated(String draftTopic, String draftBody) {
        draftLink.click();
        waitForJSinactivity(driver);
        lastDraft.click();
        waitForJSinactivity(driver);
        return isDraftContentCorrect(draftTopic, draftBody);
    }

    private boolean isDraftContentCorrect(String draftTopic, String draftBody) {
        //emailTopicField.getText().contentEquals(draftTopic);  // value of subject is saved in other element
        return emailTextArea.getText().contentEquals(draftBody);
    }
}
