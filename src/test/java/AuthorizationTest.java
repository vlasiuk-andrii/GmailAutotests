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
        logInPage.logIn();
        assertTrue("User is not authorized but has to be authorized",logInPage.isAuthorised());
    }

    @Test
    public void secondLogOutTest(){
        logInPage.logOut();
        assertTrue("User is authorized but has to be not authorized",logInPage.isNotAuthorized());
    }
}
