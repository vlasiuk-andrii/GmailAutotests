import org.junit.Before;
import org.junit.Test;
import pages.InboxPage;
import pages.LogInPage;
import pages.appendice.CommonConstants;

import static org.junit.Assert.assertTrue;

public class CreateNewDraftTest extends BaseSpec{
    InboxPage inboxPage = new InboxPage();
    LogInPage logInPage = new LogInPage();

    @Before
    public void logIn(){
        logInPage.logIn();
    }

    @Test
    public void createNewDraftTest(){
        inboxPage.createNewDraft(CommonConstants.DRAFT_TOPIC, CommonConstants.DRAFT_BODY);
        assertTrue("Draft wasn't created",inboxPage.isDraftCreated(CommonConstants.DRAFT_TOPIC, CommonConstants.DRAFT_BODY));
    }
}
