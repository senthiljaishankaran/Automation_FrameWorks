package BaseClass;

import TestUtil.TestUtilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    static WebDriver driver;
    static Properties properties;

    public TestBase(){
        try {
            properties = new Properties();
            FileInputStream input = new FileInputStream("C:\\Users\\senth\\IdeaProjects\\SwagLabs\\" +
                    "src\\main\\java\\ConfigProperties");
            properties.load(input);
        } catch(IOException exception){
            exception.printStackTrace();
        }
    }

    public static void initialization(){
        String browserName=properties.getProperty("browser");
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.chrome.driver","C:\\Program Files\\Google\\Chrome\\Application\\chrome");
            driver =new ChromeDriver();
        }
        else if(browserName.equals("firefox")){
            System.setProperty("webdriver.gecko.driver","C:\\Program Files\\Mozilla Firefox\\firefox");
            driver =new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtilities.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtilities.IMPLICIT_WAIT,TimeUnit.SECONDS);

        driver.get(properties.getProperty("URL"));
    }

}
