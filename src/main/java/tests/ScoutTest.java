package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import testResources.DataResources;

import static org.junit.Assert.assertEquals;

public class ScoutTest extends BaseTest {
    @Test(dataProviderClass = DataResources.class,dataProvider= "LoginScout_TestDataProvider",enabled=true,description="LoginScout")
    public void loginScout(String email,String password,String firstName,String middleName,String lastName,String country, String address,String phone) throws Exception {
        try {
            pageResources.getRegPage().pushRegisterNow();
        } catch (Exception e){
            pageResources.getRegPage().killCover();
            pageResources.getRegPage().pushRegisterNow();
        }
        pageResources.getRegPage().checkScoutButton();//REgistration starts
        pageResources.getRegPage().inputNames(firstName,middleName,lastName);
        pageResources.getRegPage().selectCountry(country);
        pageResources.getRegPage().inputAddress(address);
        pageResources.getRegPage().inputPhone(phone);
        pageResources.getRegPage().inputEmail(email);
        pageResources.getRegPage().inputPassword(password);;
        pageResources.getRegPage().pushCreateAccount();
        wait.until(ExpectedConditions.visibilityOf(pageResources.getLoginPage().username));
        try {//Registration check
            assertEquals(baseUrl,driver.getCurrentUrl());
        } catch (AssertionError e) {
            System.err.println("Registration form has not been submitted");
        }
        pageResources.getLoginPage().enterUsername(email);//Login
        pageResources.getLoginPage().enterPassword(password);
        pageResources.getLoginPage().pushLoginButton();
        Thread.sleep(1000);
        pageResources.getTalentPage().pushNewButton();
        pageResources.getTalentPage().selectCategory();//Category
        pageResources.getTalentPage().pushNextButton();
        pageResources.getTalentPage().enterName(firstName,middleName,lastName);//Personal
        pageResources.getTalentPage().enterAddress(address);
        pageResources.getTalentPage().enterPhone(phone);
        pageResources.getTalentPage().enterEmail();
        String birth =pageResources.getTalentPage().randomDate();
        int year = Integer.parseInt(birth.substring(4));
        pageResources.getTalentPage().enterBirth(birth);
        pageResources.getTalentPage().enterPlaceBirth();
        pageResources.getTalentPage().ruralRadioClick();
        pageResources.getTalentPage().priviligedRadioClick();
        pageResources.getTalentPage().enterHeight();
        pageResources.getTalentPage().enterWeight();
        pageResources.getTalentPage().pushNextButton();//Trainig
        pageResources.getTalentPage().selectTraining();
        pageResources.getTalentPage().noRadioClick();
        pageResources.getTalentPage().sometimesRadioClick();
        pageResources.getTalentPage().enterSchoolName();
        pageResources.getTalentPage().enterSchoolSuccessLevel();
        pageResources.getTalentPage().advancedRadioClick();
        pageResources.getTalentPage().pushNextButton();//Evidence
        pageResources.getTalentPage().familyRadioClick();
        pageResources.getTalentPage().enterTestimony();
        pageResources.getTalentPage().enterWorkProduct();
        pageResources.getTalentPage().pushNextButton();//Social Background
        pageResources.getTalentPage().middleRadioClick();
        pageResources.getTalentPage().maritalListSelect();
        pageResources.getTalentPage().workStatusListSelect();
        pageResources.getTalentPage().relationListSelect();
        pageResources.getTalentPage().enterUsdField();
        pageResources.getTalentPage().disabilitiesListSelect();
        pageResources.getTalentPage().pushNextButton();//Story
        pageResources.getTalentPage().EnterHeadline();
        pageResources.getTalentPage().EnterDiscoveryYears(year);
        pageResources.getTalentPage().interestLevelListSelect();
        pageResources.getTalentPage().gotoQuickTestsTab();//Finish
        pageResources.getTalentPage().pushFinishButton();
        pageResources.getTalentPage().gotoMyProfile();//Profile info check start
        phone="("+phone.substring(0,3)+") "+phone.substring(3,6)+"-"+phone.substring(6,10);
        try {
            assertEquals(firstName,pageResources.getProfilePage().actualFirst());
            System.out.println("First Name matches");
            assertEquals(middleName,pageResources.getProfilePage().actualMiddle());
            System.out.println("Middle Name matches");
            assertEquals(lastName,pageResources.getProfilePage().actualLast());
            System.out.println("Last Name matches");
            assertEquals(country,pageResources.getProfilePage().actualCountry());
            System.out.println("Country matches");
            assertEquals(address,pageResources.getProfilePage().actualAddress());
            System.out.println("Address matches");
            assertEquals(phone,pageResources.getProfilePage().actualPhone());
            System.out.println("Phone # matches");
            assertEquals(email,pageResources.getProfilePage().actualEmail());
            System.out.println("Email matches");
        } catch (AssertionError e) {
            System.err.println("Information does not match");
        }
    }
}
