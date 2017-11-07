package test.java;

import main.java.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.*;

public class LoginPageTests {

    private WebDriver driver;
    private static String baseUrl = "http://demo.guru99.com/";


    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.gecko.driver","bin/geckodriver_0_19_0/geckodriver.exe");
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);
        driver.get(baseUrl);

    }

    @Test
    public void testLoginMessage() throws Exception{
        final String expectedLoginMessage="Enter your email address to get\n" +
                "access details to demo site";

        LoginPage objLoginPage=new LoginPage(driver);
        String actualLoginMessage=objLoginPage.getLoginMessage();

        assertEquals(expectedLoginMessage, actualLoginMessage);
    }

    @Test
    public void testButtonPresence(){
        LoginPage objLoginPage=new LoginPage(driver);

        assertTrue(objLoginPage.findButton());

    }



    @AfterSuite
    void tearDown() {
        driver.quit();
    }
}
