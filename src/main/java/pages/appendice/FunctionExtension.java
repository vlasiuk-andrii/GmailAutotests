package pages.appendice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static junit.framework.TestCase.assertEquals;

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
//        System.out.println("element=" + driver.findElement(By.cssSelector(elementCssSelector)).toString());
//        System.out.println("elements=" + driver.findElements(By.cssSelector(elementCssSelector)).size());
        assertEquals(0, driver.findElements(By.cssSelector(elementCssSelector)).size());
    }
}
