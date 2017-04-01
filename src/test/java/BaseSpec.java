import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseSpec {

    public static Properties useProperties(){
        FileInputStream input = null;
        try {
            input = new FileInputStream("maven.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties properties = new Properties();
        try {
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

    protected static final String URL = useProperties().getProperty("URL");
    protected static final String BROWSER = useProperties().getProperty("BROWSER");;

    public WebDriver driver;

    @Before
    public void setUp() {
        if (BROWSER.equals("firefox")) {
            //System.setProperty("webdriver.chrome.silentOutput", "true");
            System.setProperty("webdriver.gecko.driver", "geckodriver");
            driver = new FirefoxDriver();
        } else if (BROWSER.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
            //System.setProperty("webdriver.chrome.args", "--disable-logging");
            System.setProperty("webdriver.chrome.silentOutput", "true");
            driver = new ChromeDriver();
        } else if (BROWSER.equals("internetExplorer")) {
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            driver = new InternetExplorerDriver(capabilities);
        } else {
            throw new RuntimeException("Browser type unsupported");
        }
        driver.get(URL);
    }

    @After
    public void tearDown() {
        driver.close();
        driver.quit();
    }
}
