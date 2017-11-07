package main.java;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
    WebDriver driver;

    @FindBy(xpath="//td[2]")
    private WebElement userId;

    @FindBy(xpath="//tr[5]/td[2]")
    private WebElement userPassword;

    @FindBy(xpath="//tr[1]")
    private WebElement userDetailsTitle;

    @FindBy(xpath="//tr[6]")
    private WebElement accessMessage;


    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public String getUserId(){
        //String userId=this.userId.getText();
        //return userId;
        return userId.getText();
    }

    public String getPassword(){
//        String userPassword=this.userPassword.getText();
//        return userPassword;
        return userPassword.getText();
    }

    public String getTitle(){
//        String userDetailsTitle=this.userDetailsTitle.getText();
//        return userDetailsTitle;
        return userDetailsTitle.getText();
    }

    public String getAccessMessage(){
//        String accessMessage=this.accessMessage.getText();
//        return accessMessage;
        return accessMessage.getText();
    }

}

