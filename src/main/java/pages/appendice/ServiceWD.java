package pages.appendice;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.util.Properties;

import static org.openqa.selenium.phantomjs.PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY;
import static pages.appendice.CommonConstants.*;


public class ServiceWD {
    protected static WebDriver driver;
    protected static final String URL = useProperties().getProperty("URL");
    protected static final String BROWSER = useProperties().getProperty("BROWSER");

    public static Properties useProperties(){
        FileInputStream input = null;
        Properties properties = new Properties();
        try {
            input = new FileInputStream("maven.properties");
            properties.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return properties;
    }

    public static void initWD(){
        if (BROWSER.equals(BROWSER_NAME_FIREFOX)) {
            //System.setProperty("webdriver.chrome.silentOutput", "true");
            System.setProperty("webdriver.gecko.driver", BROWSER_PATH_FIREFOX);
            driver = new FirefoxDriver();
        } else if (BROWSER.equals(BROWSER_NAME_CHROME)) {
            System.setProperty("webdriver.chrome.driver",  BROWSER_PATH_CHROME);
            //System.setProperty("webdriver.chrome.args", "--disable-logging");
            System.setProperty("webdriver.chrome.silentOutput", "true");
            driver = new ChromeDriver();
        } else if (BROWSER.equals(BROWSER_NAME_EDGE)) {
            System.setProperty("webdriver.edge.driver", BROWSER_PATH_EDGE);
            driver = new EdgeDriver();
        } else if (BROWSER.equals(BROWSER_NAME_PHANTOMJS)) {
            Capabilities caps = new DesiredCapabilities();
            ((DesiredCapabilities) caps).setJavascriptEnabled(true);
            ((DesiredCapabilities) caps).setCapability("takesScreenshot", true);
            ((DesiredCapabilities) caps).setCapability(
                    PHANTOMJS_EXECUTABLE_PATH_PROPERTY, BROWSER_PATH_PHANTOMJS);
            driver = new PhantomJSDriver(caps);
        } else {
            throw new RuntimeException("Browser type unsupported");
        }
    }

    public static WebDriver getDriver(){
        return driver;
    }
}
