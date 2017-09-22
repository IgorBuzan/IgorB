package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import testResources.PageResources;
import testResources.XlsData;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static testResources.XlsData.File_TestData;
import static testResources.XlsData.Path_TestData;

public class BaseTest {
    //Superclass for tests that declared most of the variables;
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = "http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com";
    //String talentUrl = "http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/talents.html";
    public static final String USERNAME = "Homer01";
    public static final String AUTOMATE_KEY="13983765-0f69-48db-b728-04742fd64dab";
    public static final String URL1 = "https://" + USERNAME + ":" + AUTOMATE_KEY +  "@ondemand.saucelabs.com:443/wd/hub";

    @BeforeClass
    public void remoteSetUp() throws MalformedURLException {

    }
    protected PageResources pageResources;
    @BeforeTest
    public void setUp() throws Exception {
        //instantiation of a driver and getting to baseURL
        driver = new ChromeDriver();
        //DesiredCapabilities caps = DesiredCapabilities.chrome();
//        DesiredCapabilities caps = DesiredCapabilities.iphone();
//        caps.setCapability("appiumVersion", "1.6.4");
//        caps.setCapability("deviceName","iPhone 7 Simulator");
//        caps.setCapability("deviceOrientation", "portrait");
//        caps.setCapability("platformVersion","10.0");
//        caps.setCapability("platformName", "iOS");
//        caps.setCapability("browserName", "Safari");
    //    driver =new RemoteWebDriver(new URL(URL1), caps);
        pageResources = new PageResources(driver);
        wait = new WebDriverWait(driver,5);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
        try {//Setting up Excel file for writing/reading data from it
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @AfterTest
    public void tearDown() throws Exception {
     //     driver.quit();
    }
}
