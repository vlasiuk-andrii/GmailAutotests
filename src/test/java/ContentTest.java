import org.junit.Test;
import pages.InboxPage;
import pages.LogInPage;

import static junit.framework.TestCase.assertTrue;

public class ContentTest extends BaseSpec{
    InboxPage inboxPage = new InboxPage();
    LogInPage logInPage = new LogInPage();

    @Test
    public void inboxPageContentTest(){
        given: // user is on LogInPage

        when:
        logInPage.logIn();

        then:
        assertTrue("Content on InboxPage is incorrect",inboxPage.isContentOnPageCorrect());
    }

    @Test
    public void logInPageContentText(){
        given: // user is on LogInPage

        when:

        then:
        assertTrue("Content on LogInPage is incorrect",logInPage.isContentOnPageCorrect());
    }
}
