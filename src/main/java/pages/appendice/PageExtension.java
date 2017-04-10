package pages.appendice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static java.lang.Thread.sleep;
import static org.junit.Assert.fail;

public class PageExtension extends ServiceWD{

    public PageExtension(){
        PageFactory.initElements(driver, this);
    }

    public void waitForJSinactivity(){
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            sleep(1000);
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            //Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    public String currentDateAndTime(){
        String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(Calendar.getInstance().getTime());
        return timeStamp;
    }

    public void elementIsNotDisplayed(String elementCssLocator) {
        try {
            driver.findElement(By.cssSelector(elementCssLocator));
            fail("Element is present. But shouldn't be present");
        } catch (Exception ex) {
        /* do nothing, object is not present, assert is passed */
        }
    }

}
