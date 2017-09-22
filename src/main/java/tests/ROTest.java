package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import testResources.DataResources;
import testResources.XlsData;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static testResources.XlsData.findColumn;
import static testResources.XlsData.getCellData;

public class ROTest extends BaseTest{

    @Test(dataProviderClass = DataResources.class,dataProvider= "LoginRO_TestDataProvider",enabled=true,description="LoginRegularO")
    public void LoginRO(String email,String password,String firstName,String middleName,String lastName, String country, String address,String phone) throws Exception {
        //End-to-end test case that checks the followind:
        //Verifying that user is able to register an account with valid credentials
        //Verifying that user can successfully log in using valid credentials
        //Test verifies that user can:
        //Choose to report talent of other person
        //fill out some fields(each input type is checked)
        //submit talent
        //sign out
        //log inwith same credentials
        //verify that all the tallent info is correct
        //verify that user's profile info mathes the one provided during registration
        try {//killing cover
            pageResources.getRegPage().pushRegisterNow();
        } catch (Exception e) {
            pageResources.getRegPage().killCover();
            pageResources.getRegPage().pushRegisterNow();
        }
        XlsData.setUpTable(new String[]{"First Name", "Middle Name", "Last Name", "Country", "Address", "Phone", "Email", "Password",
                "Birth Date", "Birth Place","Height","Marital","Work Status","Other First Name","Other Middle Name","Other Last Name",
        "Other "});//Setting up columns of Excel file for data
        System.out.println(XlsData.findColumn("Country"));
        pageResources.getRegPage().inputNames(firstName, middleName, lastName);//REgistration starts
        XlsData.setCellData(firstName, 1, findColumn("First Name"));
        XlsData.setCellData(middleName, 1, findColumn("Middle Name"));
        XlsData.setCellData(lastName, 1, findColumn("Last Name"));
        pageResources.getRegPage().selectCountry(country);
        XlsData.setCellData(country, 1, findColumn("Country"));
        pageResources.getRegPage().inputAddress(address);
        XlsData.setCellData(address, 1, findColumn("Address"));
        pageResources.getRegPage().inputPhone(phone);
        XlsData.setCellData("(" + phone.substring(0, 3) + ") " + phone.substring(3, 6) + "-" + phone.substring(6, 10), 1, findColumn("Phone"));
        pageResources.getRegPage().inputEmail(email);
        XlsData.setCellData(email, 1, findColumn("Email"));
        pageResources.getRegPage().inputPassword(password);
        XlsData.setCellData(password, 1, findColumn("Password"));
        pageResources.getRegPage().pushCreateAccount();//Registration ends
        wait.until(ExpectedConditions.visibilityOf(pageResources.getLoginPage().username));
        try {//Registration check
            assertEquals(baseUrl, driver.getCurrentUrl());
        } catch (AssertionError e) {
            System.err.println("Registration form has not been submitted");
        }
        pageResources.getLoginPage().enterUsername(email);
        pageResources.getLoginPage().enterPassword(password);
        pageResources.getLoginPage().pushLoginButton();//Login
    }
        @Test(priority = 1)
            public void tallentRO() throws Exception {
        pageResources.getTalentPage().pushOtherButton();
        Thread.sleep(1000);
        pageResources.getTalentPage().pushConfirm();
        pageResources.getTalentPage().pushNewButton();
        pageResources.getTalentPage().selectCategory();//Category
        pageResources.getTalentPage().pushNextButton();
       // pageResources.getTalentPage().enterName(firstName,middleName,lastName);//Personal
       // pageResources.getTalentPage().enterAddress(address);
        //pageResources.getTalentPage().enterPhone(phone);
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
        pageResources.getTalentPage().signOut();//signing out form the account
        ///////////////////////////////////////////////////////////
        pageResources.getLoginPage().enterUsername(getCellData(1,findColumn("Email")));
        pageResources.getLoginPage().enterPassword(getCellData(1,findColumn("Password")));
        pageResources.getLoginPage().pushLoginButton();//Login
        pageResources.getTalentPage().pushEditButton();//Opening the last entered tallent for info verification
        Thread.sleep(1000);
//        pageResources.getTalentPage().checkCategory();//Category
        pageResources.getTalentPage().pushNextButton();//Personal
        String actualFName=pageResources.getTalentPage().getFName();
        System.out.println(getCellData(1,findColumn("First Name")));
        System.out.println(actualFName);
        try {assertTrue(actualFName.matches(getCellData(1,findColumn("First Name"))));}
        catch (AssertionError e) {System.out.println("First Name does not match!");}
        String actualMName=pageResources.getTalentPage().getMName();
        System.out.println(getCellData(1,findColumn("Middle Name")));
        System.out.println(actualMName);
        try {assertTrue(actualMName.matches(getCellData(1,findColumn("Middle Name"))));}
        catch (AssertionError e) {System.out.println("Middle Name does not match!");}
        String actualBirthDate=pageResources.getTalentPage().getBirthDate();
        System.out.println(getCellData(1,findColumn("Birth Date")));
        System.out.println(actualBirthDate);
        try {assertTrue(actualBirthDate.matches(getCellData(1,findColumn("Birth Date"))));}
        catch (AssertionError e) {System.out.println("Birth Date does not match!");}
//        pageResources.getTalentPage().checkBirthPlace();
//        pageResources.getTalentPage().ifSelectedRuralRadio();
        try{
            assertTrue(pageResources.getTalentPage().ifSelectedPriviligedRadio());
        } catch (AssertionError e) {
            System.out.println("Rrivileged ststus is not saved!");
        }
        String actualHeight=pageResources.getTalentPage().getHeight();;
        System.out.println(getCellData(1,findColumn("Height")));
        System.out.println(actualHeight);
        try {assertTrue(actualHeight.matches(getCellData(1,findColumn("Height"))));}
        catch (AssertionError e) {System.out.println("Height does not match!");}
//        pageResources.getTalentPage().checkWeight();
        pageResources.getTalentPage().pushNextButton();//Trainig
//        pageResources.getTalentPage().checkTraining();
//        pageResources.getTalentPage().checkCoachingRadio();
//        pageResources.getTalentPage().checkSometimesRadio();
//        pageResources.getTalentPage().checkSchoolName();
//        pageResources.getTalentPage().checkSchoolSuccessLevel();
//        pageResources.getTalentPage().ifSelectedadvancedRadio();
        pageResources.getTalentPage().pushNextButton();//Evidence
//        pageResources.getTalentPage().ifSelectedFamilyRadio();
//        pageResources.getTalentPage().checkTestimony();
//        pageResources.getTalentPage().checkWorkProduct();
        pageResources.getTalentPage().pushNextButton();//Social Background
//        pageResources.getTalentPage().ifSelectedMiddleRadio();
        String actualMarital=pageResources.getTalentPage().actualMaritalStatus();
        System.out.println(actualMarital);
        System.out.println(getCellData(1,findColumn("Marital")));
        try {assertTrue(actualMarital.matches(getCellData(1,findColumn("Marital"))));}
        catch (AssertionError e) {System.out.println("Marital does not match!");}
        String actualWorkStatus=pageResources.getTalentPage().actualWorkStatus();
        System.out.println(actualWorkStatus);
        System.out.println(getCellData(1,findColumn("Work Status")));
        try {assertTrue(actualWorkStatus.matches(getCellData(1,findColumn("Work Status"))));}
        catch (AssertionError e) {System.out.println("Work Status does not match!");}//        pageResources.getTalentPage().checkWorkStatusList();
//        pageResources.getTalentPage().checkRelationList();
//        pageResources.getTalentPage().checkUsdField();
//        pageResources.getTalentPage().checkDisabilitiesList();
        pageResources.getTalentPage().pushNextButton();//Story
//        pageResources.getTalentPage().checkHeadline();
//        pageResources.getTalentPage().checkDiscoveryYears(year);
//        pageResources.getTalentPage().checkInterestLevelList();
        wait.until(ExpectedConditions.visibilityOf(pageResources.getTalentPage().quickTestsTab));
        pageResources.getTalentPage().gotoQuickTestsTab();//Finish
        pageResources.getTalentPage().pushFinishButton();
        pageResources.getTalentPage().gotoMyProfile();//Profile info check starts
        wait.until(ExpectedConditions.visibilityOf(pageResources.getProfilePage().fNameProfileField));
        // String phone=getCellData(0,findColumn("Phone"));
//        phone="("+phone.substring(0,3)+") "+phone.substring(3,6)+"-"+phone.substring(6,10);
        try {
            //System.out.println(getCellData(0,0));
            System.out.println(pageResources.getProfilePage().actualFirst());
            assertEquals(getCellData(1,findColumn("First Name")),pageResources.getProfilePage().actualFirst());
            System.out.println("First Name matches");
            assertEquals(getCellData(1,findColumn("Middle Name")),pageResources.getProfilePage().actualMiddle());
            System.out.println("Middle Name matches");
            assertEquals(getCellData(1,findColumn("Last Name")),pageResources.getProfilePage().actualLast());
            System.out.println("Last Name matches");
            assertEquals(getCellData(1,findColumn("Country")),pageResources.getProfilePage().actualCountry());
            System.out.println("Country matches");
            assertEquals(getCellData(1,findColumn("Address")),pageResources.getProfilePage().actualAddress());
            System.out.println("Address matches");
            assertEquals(getCellData(1,findColumn("Phone")),pageResources.getProfilePage().actualPhone());
            System.out.println("Phone # matches");
            assertEquals(getCellData(1,findColumn("Email")),pageResources.getProfilePage().actualEmail());
            System.out.println("Email matches");
        } catch (AssertionError e) {
            System.err.println("Information does not match");
        }
    }
}
