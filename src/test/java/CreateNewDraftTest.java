import org.junit.Before;
import org.junit.Test;
import pages.InboxPage;
import pages.LogInPage;
import static org.junit.Assert.assertTrue;

public class CreateNewDraftTest extends BaseSpec{
    InboxPage inboxPage = new InboxPage(driver);
    LogInPage logInPage = new LogInPage(driver);

    @Before
    public void logIn(){
        logInPage.logInSuccess();
    }

    @Test
    public void createNewDraftTest(){
        inboxPage.createNewDraft("DraftTopic_", "DraftBody");
        assertTrue("Draft wasn't created",inboxPage.verifyDraftCreated("DraftTopic_", "DraftBody"));
    }
}
