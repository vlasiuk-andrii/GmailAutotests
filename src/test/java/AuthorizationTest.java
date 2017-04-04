import org.junit.Before;
import org.junit.Test;
import pages.LogInPage;

//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthorizationTest extends BaseSpec {

    LogInPage logInPage = new LogInPage(driver);

    @Before
    public void logInTest(){
        logInPage.logInSuccess();
        logInPage.assertIsAuthorised();
    }

    @Test
    public void logOutTest()  {
        logInPage.logOutSuccess();
        logInPage.assertIsNotAuthorized();
    }
}
