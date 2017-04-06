import org.junit.Before;
import org.junit.Test;
import pages.InboxPage;
import pages.LogInPage;

import pages.appendice.CommonConstants;

import static junit.framework.TestCase.assertTrue;

public class SendNewLetterTest extends BaseSpec{
    InboxPage inboxPage = new InboxPage(driver);
    LogInPage logInPage = new LogInPage(driver);

    @Before
    public void logIn(){
        logInPage.logIn();
    }

    @Test
    public void sendNewLetterTest() {
        //logInPage.check();
        inboxPage.sendNewLetter(CommonConstants.EMAIL, CommonConstants.LETTER_TOPIC, CommonConstants.LETTER_BODY);
        assertTrue(inboxPage.isLetterReceived(CommonConstants.LETTER_TOPIC, CommonConstants.LETTER_BODY));
    }
}
