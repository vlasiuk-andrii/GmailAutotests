import org.junit.Test;
import pages.InboxPage;
import pages.LogInPage;

import static junit.framework.TestCase.assertTrue;

public class ContentTest extends BaseSpec{
    InboxPage inboxPage = new InboxPage(driver);
    LogInPage logInPage = new LogInPage(driver);

    @Test
    public void inboxPageContentTest(){
        logInPage.logInSuccess();
        assertTrue(inboxPage.assertContentOnPage());
    }

    @Test
    public void logInPageContentText(){
        assertTrue(logInPage.assertContentOnPage());
    }
}
