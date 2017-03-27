import org.junit.Assert;
import org.junit.Test;

public class FirstTest extends BaseSpec {

    @Test
    public void initialTest(){

       // WebDriver driver = new ChromeDriver();
        //driver.navigate().to("https://www.google.com.ua");
        Assert.assertEquals("Google", driver.getTitle());
        driver.close();
        driver.quit();
    }
}
