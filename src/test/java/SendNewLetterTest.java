import org.junit.Before;
import org.junit.Test;
import pages.InboxPage;
import pages.LogInPage;

import pages.appendice.CommonConstants;

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
        inboxPage.sendNewLetter(CommonConstants.EMAIL, "TestLetterTopic_", "LetterBody");
        inboxPage.verifyLetterCame("TestLetterTopic_", "LetterBody");
    }
}
