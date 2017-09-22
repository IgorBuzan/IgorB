package tests;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import testResources.DataResources;
import testResources.PageResources;

import static org.junit.Assert.assertEquals;

public class LoginTest extends BaseTest{
    @Test(dataProviderClass = DataResources.class,dataProvider = "Negative_TestDataProvider",enabled=true,description="Negative")
    public void LoginNegative(String email,String password,String email1,String password1,String errorMessage){
        //Test case with 4 sets of data that checks following scenarios:
        //1.Invalid email/valid password
        //2.Valid meail/invalid password
        //3.blank email/valid password
        //4.Valid email/blank password
        String firstName = RandomStringUtils.randomAlphabetic(5);
        String middleName = RandomStringUtils.randomAlphabetic(5);
        String lastName = RandomStringUtils.randomAlphabetic(5);
        String country=RandomStringUtils.randomAlphabetic(5,7);
        String address = RandomStringUtils.randomNumeric(4)+" "+RandomStringUtils.randomAlphabetic(5);
        String phone = RandomStringUtils.randomNumeric(10);
        try {//Killing loding cover on a start page;
            pageResources.getRegPage().pushRegisterNow();
        } catch (Exception e){
            pageResources.getRegPage().killCover();
            pageResources.getRegPage().pushRegisterNow();
        }
        pageResources.getRegPage().inputNames(firstName,middleName,lastName);//Registration starts
        pageResources.getRegPage().selectCountry(country);
        pageResources.getRegPage().inputAddress(address);
        pageResources.getRegPage().inputPhone(phone);
        pageResources.getRegPage().inputEmail(email);
        pageResources.getRegPage().inputPassword(password);;
        pageResources.getRegPage().pushCreateAccount();//Registration ends
        pageResources.getLoginPage().enterUsername(email1);
        pageResources.getLoginPage().enterPassword(password1);
        pageResources.getLoginPage().pushLoginButton();//Login Attempt

        try {//Verifying that user is still on the login page
            assertEquals(baseUrl,driver.getCurrentUrl());
        } catch(AssertionError e) {
            System.err.println(errorMessage);
        }
    }
}
