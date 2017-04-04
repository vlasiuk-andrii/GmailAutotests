import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.LogInPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthorizationTest extends BaseSpec {

    LogInPage logInPage = new LogInPage(driver);

    @Test
    public void firstLogInTest(){
        logInPage.logInSuccess();
        logInPage.assertIsAuthorised();
    }

    @Test
    public void secondLogOutTest(){
        logInPage.logOutSuccess();
        logInPage.assertIsNotAuthorized();
    }
}
