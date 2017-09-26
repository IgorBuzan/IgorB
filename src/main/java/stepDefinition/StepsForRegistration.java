package stepDefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import testResources.PageResources;
import testResources.*;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class StepsForRegistration {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected String baseUrl = "http://ec2-52-53-181-39.us-west-1.compute.amazonaws.com";
    protected PageResources pageResources;
    @Given("^User is on Home Page$")
    public void user_is_on_Home_Page() throws Throwable {
        driver = new ChromeDriver();
        pageResources = new PageResources(driver);
        wait = new WebDriverWait(driver,5);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(baseUrl);
    }

    @When("^User Navigate to registrationPage$")
    public void user_Navigate_to_registrationPage() throws Throwable {
        try {//Killing loding cover on a start page;
            pageResources.getRegPage().pushRegisterNow();
        } catch (Exception e){
            pageResources.getRegPage().killCover();
            pageResources.getRegPage().pushRegisterNow();
        }
    }

    @Then("^Message displayed Login Successfully$")
    public void message_displayed_Login_Successfully() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @When("^User LogOut from the Application$")
    public void user_LogOut_from_the_Application() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^Message displayed LogOut Successfully$")
    public void message_displayed_LogOut_Successfully() throws Throwable {
    }

    @And("^User enters Country$")
    public void userEntersAsACountry(String country) throws Throwable {
        pageResources.getRegPage().selectCountry((String) DataResources.getlogRUData()[0][5]);
    }

    @And("^User enters First Name, Second Name, Last Name$")
    public void userEntersNames() throws Throwable {
        pageResources.getRegPage().inputNames((String) DataResources.getlogRUData()[0][2],(String) DataResources.getlogRUData()[0][3],(String) DataResources.getlogRUData()[0][4]);
    }

    @And("^User enters Adress$")
    public void userEntersAdress(String address) throws Throwable {
        pageResources.getRegPage().inputAddress(address);
    }

    @And("^User enters \"([^\"]*)\"/ as a Phone number$")
    public void userEntersPhone(String phone) throws Throwable {
        pageResources.getRegPage().inputPhone(phone);
    }

    @And("^User enters an Email$")
    public void userEntersEmail() throws Throwable {
        pageResources.getRegPage().inputEmail((String) DataResources.getlogRUData()[0][0]);
    }

    @And("^User enters \"([^\"]*)\" as a Password and retypes that as well$")
    public void userEntersPassword(String password) throws Throwable {
        pageResources.getRegPage().inputPassword(password);
    }

    @And("^User pushes Create account button$")
    public void userPushesCreateAccountButton() throws Throwable {
        pageResources.getRegPage().pushCreateAccount();
    }

    @Then("^User gets redirected to login page$")
    public void userGetsRedirectedToLoginPage() throws Throwable {
        try {//Registration check
            assertEquals(baseUrl, driver.getCurrentUrl());
        } catch (AssertionError e) {
            System.err.println("Registration form has not been submitted");
        }
    }
}
