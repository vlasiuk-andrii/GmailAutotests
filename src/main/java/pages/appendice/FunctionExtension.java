package pages.appendice;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.fail;

public class FunctionExtension {

    public void waitForJSinactivity(WebDriver driver){
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
                    }
                };
        try {
            Thread.sleep(1000);
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

    public void elementIsNotDisplayed(WebDriver driver, String elementCssSelector) {
        try {
            driver.findElement(By.cssSelector(elementCssSelector));
            fail("Element is present. But shouldn't be present");
        } catch (Exception ex) {
        /* do nothing, link is not present, assert is passed */
        }
    }

    public void attachFile(WebDriver driver, String filePath, String elementCssLocator){
        //driver.setFileDetector(new LocalFileDetector());
        driver.findElement(By.cssSelector(elementCssLocator)).sendKeys(filePath);
    }
}
