package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,5);
        PageFactory.initElements(driver,this);
    }
    //Page factory for WebElements
    @FindBy(xpath = "//input[@name='email']")
    public
    WebElement username;
    @FindBy(xpath = "//input[@name='password']")
    WebElement userpassword;
    @FindBy(id = "login")
    WebElement loginButton;
    //Methods for logging into the account
    public void enterUsername(String email){
        username.sendKeys(email);
    }
    public void enterPassword(String password){
        userpassword.sendKeys(password);
    }
    public void pushLoginButton(){

        loginButton.click();
    }
}

