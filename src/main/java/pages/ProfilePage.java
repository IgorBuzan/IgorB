package pages;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.sound.midi.MidiDevice;

import static org.junit.Assert.*;
public class ProfilePage {
    WebDriver driver;
    WebDriverWait wait;

    public ProfilePage(WebDriver driver) {
        this.driver=driver;
        wait= new WebDriverWait(driver,5);
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "firstName")
    public WebElement fNameProfileField;
    @FindBy(id = "middleName")
    WebElement mNameProfileField;
    @FindBy(id = "lastName")
    WebElement lNameProfileField;
    @FindBy(id = "county")
    WebElement countryProfileField;
    @FindBy(id = "address")
    WebElement addressProfileField;
    @FindBy(id = "phone")
    WebElement phoneProfileField;
    @FindBy(id = "email")
    WebElement emailProfileField;

    //WebElement interaction methods

    public String actualFirst(){
        return fNameProfileField.getAttribute("value");
    }
    public String actualMiddle(){
        return mNameProfileField.getAttribute("value");
    }
    public String actualLast(){
        return lNameProfileField.getAttribute("value");
    }
    public String actualCountry(){
        return countryProfileField.getAttribute("value");
    }
    public String actualAddress(){
        return addressProfileField.getAttribute("value");
    }
    public String actualPhone(){
        return phoneProfileField.getAttribute("value");
    }
    public String actualEmail() {
        return emailProfileField.getAttribute("value");
    }
}
