import org.junit.Test;
import pages.InboxPage;
import pages.LogInPage;
import pages.appendice.CommonConstants;

import static org.junit.Assert.assertTrue;

public class CreateNewDraftTest extends BaseSpec{
    InboxPage inboxPage = new InboxPage();
    LogInPage logInPage = new LogInPage();

    @Test
    public void createNewDraftTest(){
        given:
        logInPage.logIn();

        when:
        inboxPage.createNewDraft(CommonConstants.DRAFT_TOPIC, CommonConstants.DRAFT_BODY);

        then:
        assertTrue("Draft wasn't created",inboxPage.isDraftCreated(CommonConstants.DRAFT_TOPIC, CommonConstants.DRAFT_BODY));
    }
}
