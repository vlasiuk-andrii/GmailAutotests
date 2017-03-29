package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.appendice.FunctionExtension;

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

    public void assertContentOnPage(){
        inboxMailList.isDisplayed();
        createNewMessageButton.isDisplayed();
        menuList.isDisplayed();
    }

}
