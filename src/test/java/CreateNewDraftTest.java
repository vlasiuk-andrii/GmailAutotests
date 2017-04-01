import org.junit.Before;
import org.junit.Test;
import pages.InboxPage;
import pages.LogInPage;
import pages.appendice.CommonConstants;

public class CreateNewDraftTest extends BaseSpec{
    InboxPage inboxPage = new InboxPage(driver);
    LogInPage logInPage = new LogInPage(driver);

    @Before
    public void logIn(){
        logInPage.init(driver);
        logInPage.logInSuccess();
        inboxPage.init(driver);
    }

    @Test
    public void createNewDraftTest(){
        inboxPage.createNewDraft("DraftTopic_", "DraftBody");
        inboxPage.verifyDraftCreated("DraftTopic_", "DraftBody");
    }
}
