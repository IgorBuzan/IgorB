package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.*;

public class RegPage {
    private WebDriver driver;
    private WebDriverWait wait;
    JavascriptExecutor ex;
    String baseUrl = "http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com/sign-in.html";
    public RegPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,5);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath ="//a[contains(text(),'Register Now')]" )
    WebElement registerButton;
    @FindBy(id = "userType")
    WebElement userType;
    @FindBy(id = "signUpFirstName")
    WebElement signUpFirstName;
    @FindBy(id = "signUpmiddleName")
    WebElement signUpmiddleName;
    @FindBy(id = "signUpLastName")
    WebElement signUpLastName;
    @FindBy(id = "signUpCounty")
    WebElement signUpCounty;
    @FindBy(id = "signUpAddress")
    WebElement signUpAddress;
    @FindBy(id = "signUpPhone")
    WebElement signUpPhone;
    @FindBy(id = "signUpRegisterEmail")
    WebElement signUpRegisterEmail;
    @FindBy(id = "signUpRegisterRePassword")
    WebElement signUpRegisterRePassword;
    @FindBy(id = "signUpRegisterPassword")
    WebElement signUpRegisterPassword;
    @FindBy(id = "createAccount")
    WebElement createAccount;
    @FindBy(css ="body > app > splash-screen > div" )
    WebElement cover;

    //WebElement interaction methods
    public void pushRegisterNow(){
        wait.until(ExpectedConditions.visibilityOf(registerButton));
        registerButton.click();
    }

    public void checkScoutButton() throws InterruptedException {
        Thread.sleep(500);
        ex=(JavascriptExecutor)driver;
        ex.executeScript("arguments[0].click();",userType);
    }
    public void inputNames(String firstName,String middleName,String lastName){
        signUpFirstName.sendKeys(firstName);
        signUpmiddleName.sendKeys(middleName);
        signUpLastName.sendKeys(lastName);
    }
    public void selectCountry(String country){
        signUpCounty.sendKeys(country);
    }
    public void inputAddress(String address){
        signUpAddress.sendKeys(address);
    }
    public void inputPhone(String phone){
        signUpPhone.sendKeys(phone);
    }
    public void inputEmail(String email){
        signUpRegisterEmail.sendKeys(email);
    }
    public void inputPassword(String password){
        signUpRegisterPassword.sendKeys(password);
        signUpRegisterRePassword.sendKeys(password);
    }
    public void pushCreateAccount(){
        JavascriptExecutor ex=(JavascriptExecutor)driver;
        ex.executeScript("arguments[0].click();",createAccount);
    }
    ///Method for killing load cover for a login page
    public void killCover() {
        JavascriptExecutor ex = (JavascriptExecutor) driver;
        ex.executeScript("arguments[0].parentNode.removeChild(arguments[0]);",cover);
        System.out.println("Cover killed");
    }
}
