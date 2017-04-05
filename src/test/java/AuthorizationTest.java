import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.LogInPage;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthorizationTest extends BaseSpec {

    LogInPage logInPage = new LogInPage(driver);

    @Test
    public void firstLogInTest(){
        logInPage.logInSuccess();
        assertTrue(logInPage.assertIsAuthorised());
    }

    @Test
    public void secondLogOutTest(){
        logInPage.logOutSuccess();
        assertTrue(logInPage.assertIsNotAuthorized());
    }
}
