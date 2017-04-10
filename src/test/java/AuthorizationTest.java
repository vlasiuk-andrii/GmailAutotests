import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.InboxPage;
import pages.LogInPage;

import static org.junit.Assert.assertTrue;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AuthorizationTest extends BaseSpec {

    LogInPage logInPage = new LogInPage();
    InboxPage inboxPage = new InboxPage();

    @Test
    public void firstLogInTest(){
        given:
        logInPage.visit();

        when:
        logInPage.logIn();

        then:
        assertTrue("User is not authorized but has to be authorized",logInPage.isAuthorised());
    }

    @Test
    public void secondLogOutTest(){
        given:
        inboxPage.check();

        when:
        logInPage.logOut();

        then:
        assertTrue("User is authorized but has to be not authorized",logInPage.isNotAuthorized());
    }
}
