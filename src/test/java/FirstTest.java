import org.junit.Assert;
import org.junit.Test;

import static java.lang.Thread.sleep;

public class FirstTest extends BaseSpec {

    LogInPage logInPage = new LogInPage(driver);

    @Test
    public void logInTest(){
        System.out.println("driver in test=" + driver);
        logInPage.logIn();
        logInPage.assertIsAuthorised();
    }
}
