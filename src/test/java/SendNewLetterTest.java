import org.junit.Test;
import pages.InboxPage;
import pages.LogInPage;
import pages.appendice.CommonConstants;

import static junit.framework.TestCase.assertTrue;

public class SendNewLetterTest extends BaseSpec{
    InboxPage inboxPage = new InboxPage();
    LogInPage logInPage = new LogInPage();

    @Test
    public void sendNewLetterTest() {
        given:
        logInPage.visit();
        logInPage.logIn();

        when:
        inboxPage.check();
        inboxPage.sendNewLetter(CommonConstants.EMAIL, CommonConstants.LETTER_TOPIC, CommonConstants.LETTER_BODY);

        then:
        assertTrue(inboxPage.isLetterReceived(CommonConstants.LETTER_TOPIC, CommonConstants.LETTER_BODY));
    }
}
