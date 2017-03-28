import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class FirstTest extends BaseSpec {

    LogInPage logInPage = new LogInPage(driver);

    @Test
    public void logInTest() throws InterruptedException {
        System.out.println("driver in test=" + driver);
        //driver.findElement(By.cssSelector("input#Email")).sendKeys("ljnsofvnorvn");
        logInPage.init(driver);
        logInPage.logIn();
        logInPage.assertIsAuthorised();
    }
}
