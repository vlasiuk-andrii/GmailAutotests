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
        inboxPage.init(driver);
        logInPage.logInSuccess();
    }

    @Test
    public void sendNewLetterTest(){
        inboxPage.sendNewLetter(CommonConstants.EMAIL, "TestLetterTopic_", "LetterBody");
        inboxPage.verifyLetterCame("TestLetterTopic_", "LetterBody");
    }
}
