import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.LogInPage;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthorizationTest extends BaseSpec {

    LogInPage logInPage = new LogInPage();

    @Test
    public void firstLogInTest(){
        given: // user is not authorized

        when:
        logInPage.logIn();

        then:
        assertTrue("User is not authorized but has to be authorized",logInPage.isAuthorised());
    }

    @Test
    public void secondLogOutTest(){
        given:  // after previous test user is authorized

        when:
        logInPage.logOut();

        then:
        assertTrue("User is authorized but has to be not authorized",logInPage.isNotAuthorized());
    }
}
