import org.junit.Test;
import pages.InboxPage;
import pages.LogInPage;

public class ContentTest extends BaseSpec{
    InboxPage inboxPage = new InboxPage(driver);
    LogInPage logInPage = new LogInPage(driver);

    @Test
    public void inboxPageContentTest(){
        logInPage.logInSuccess();
        inboxPage.assertContentOnPage();
    }

    @Test
    public void logInPageContentText(){
        logInPage.assertContentOnPage();
    }
}
