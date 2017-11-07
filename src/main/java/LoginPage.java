package main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    //By userEmail= By.xpath("//input[@name='emailid']");

    @FindBy(xpath = "//input[@name='emailid']")
    private WebElement userEmail;

    //By button=By.name("btnLogin");
    @FindBy(name = "btnLogin")
    private WebElement button;

    @FindBy(xpath="//tr[1]/td[1]/h2")
    private WebElement loginMessage;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public void setEmail(String strEmail) {
        //driver.findElement(userEmail).sendKeys(strEmail);
        userEmail.clear();
        userEmail.sendKeys(strEmail);
    }

    public void clickLogin() {
        //driver.findElement(button).click();
        button.click();
    }

    public void loginToHomePage(String strEmail) {
        setEmail(strEmail);
        clickLogin();
    }

    public String getLoginMessage(){
        //String loginMessage=this.loginMessage.getText();
        //return loginMessage;
        return loginMessage.getText();
    }

    public Boolean findButton(){
        //return this.button.isDisplayed();
        return button.isDisplayed();
    }

}


