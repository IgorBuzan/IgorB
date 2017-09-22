package testResources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;

public class PageResources {
    WebDriver driver;
    WebDriverWait wait;
    LoginPage loginPage;
    RegPage regPage;
    TalentPage talentPage;
    ProfilePage profilePage;
    public PageResources(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,5);
    }
    public RegPage getRegPage() {
        return regPage= new RegPage(driver);
    }
    public LoginPage getLoginPage() {
        return loginPage= new LoginPage(driver);
    }
    public TalentPage getTalentPage() {
        return talentPage = new TalentPage(driver);
    }

    public ProfilePage getProfilePage() {
        return profilePage = new ProfilePage(driver);
    }
}
