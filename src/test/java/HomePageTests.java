package test.java;
import main.java.LoginPage;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.testng.Assert.assertEquals;


import main.java.HomePage;


public class HomePageTests {

    private WebDriver driver;
    private static String baseUrl = "http://demo.guru99.com/";
    //LoginPage objLogin;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.gecko.driver","bin/geckodriver_0_19_0/geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);
        driver.get(baseUrl);

        LoginPage objLogin=new LoginPage(driver);
        objLogin.loginToHomePage("abc@gmail.com");
    }



    @Test(priority = 1)
    public void testUserId() throws Exception {
        final String expectedUserId = "mngr26593";

        HomePage objHomePage=new HomePage(driver);
        String actualUserId = objHomePage.getUserId();

        //String actualText = driver.findElement(By.xpath("//td[2]")).getText();
        assertEquals(expectedUserId, actualUserId);
    }

    @Test(priority = 2)
    public void testPassword() throws Exception {
        final String expectedPassword = "test@1234";

        HomePage objHomePage=new HomePage(driver);
        String actualPassword = objHomePage.getPassword();

        assertEquals(expectedPassword, actualPassword);
    }

    @Test (priority = 3)
    public void testTitle() throws Exception{
        final String expectedTitle="Access details to demo site.";

        HomePage objHomePage=new HomePage(driver);
        String actualTitle=objHomePage.getTitle();

        assertEquals(expectedTitle, actualTitle);
    }

    @Test (priority = 4)
    public void testAccessMessage() throws Exception{
        final String expectedAccessMessage="This access is valid only for 20 days.";

        HomePage objHomePage=new HomePage(driver);
        String actualAccessMessage=objHomePage.getAccessMessage();

        assertEquals(expectedAccessMessage, actualAccessMessage);
    }

    @AfterSuite void tearDown() {
        driver.quit();
    }

}

