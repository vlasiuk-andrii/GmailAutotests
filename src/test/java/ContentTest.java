import org.apache.commons.logging.Log;
import org.junit.Test;
import pages.InboxPage;
import pages.LogInPage;

public class ContentTest extends BaseSpec{
    InboxPage inboxPage = new InboxPage(driver);
    LogInPage logInPage = new LogInPage(driver);

    @Test
    public void inboxPageContentTest(){
        logInPage.init(driver);
        logInPage.logInSuccess();
        inboxPage.init(driver);
        inboxPage.assertContentOnPage();
    }

    @Test
    public void logInPageContentText(){
        logInPage.init(driver);
        logInPage.assertContentOnPage();
    }
}
