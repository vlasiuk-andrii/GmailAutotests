import pages.LogInPage;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static java.lang.Thread.sleep;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthorizationTest extends BaseSpec {

    LogInPage logInPage = new LogInPage(driver);

    @Before
    public void logInTest(){
        logInPage.init(driver);
        logInPage.logInSuccess();
        logInPage.assertIsAuthorised();
    }

    @Test
    public void logOutTest(){
        logInPage.logOutSuccess();
        logInPage.assertIsNotAuthorized();
    }
}
