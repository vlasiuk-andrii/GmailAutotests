import org.junit.Test;
import pages.InboxPage;
import pages.LogInPage;

import static org.junit.Assert.assertTrue;
import static pages.appendice.CommonConstants.DRAFT_BODY;
import static pages.appendice.CommonConstants.DRAFT_TOPIC;

public class CreateNewDraftTest extends BaseSpec{
    InboxPage inboxPage = new InboxPage();
    LogInPage logInPage = new LogInPage();

    @Test
    public void createNewDraftTest(){
        given:
        logInPage.visit();
        logInPage.logIn();

        when:
        inboxPage.check();
        inboxPage.createNewDraft(DRAFT_TOPIC, DRAFT_BODY);

        then:
        assertTrue("Draft wasn't created",inboxPage.isDraftCreated(DRAFT_TOPIC, DRAFT_BODY));
    }
}
