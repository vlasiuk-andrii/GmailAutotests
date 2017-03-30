import org.junit.Before;
import org.junit.Test;
import pages.InboxPage;
import pages.LogInPage;

public class SendNewLetterTest extends BaseSpec{
    InboxPage inboxPage = new InboxPage(driver);
    LogInPage logInPage = new LogInPage(driver);

    @Before
    public void logIn(){
        logInPage.init(driver);
        logInPage.logInSuccess();
        inboxPage.init(driver);
    }

    @Test
    public void sendNewLetterTest(){
        inboxPage.init(driver);
        inboxPage.sendNewLetter();
    }
}
