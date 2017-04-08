import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.appendice.CommonConstants;
import pages.appendice.ServiceWD;

import java.io.FileInputStream;
import java.util.Properties;

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