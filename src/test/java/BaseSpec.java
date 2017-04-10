import org.junit.AfterClass;
import org.junit.BeforeClass;
import pages.appendice.ServiceWD;

public class BaseSpec {

    @BeforeClass
    public static void setUp() {
        ServiceWD.initWD();
    }

    @AfterClass
    public static void tearDown() {
        ServiceWD.getDriver().close();
        ServiceWD.getDriver().quit();
    }
}