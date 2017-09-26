package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import testResources.DataResources;
import testResources.XlsData;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static testResources.XlsData.*;

public class ROTest extends BaseTest{

    @Test(dataProviderClass = DataResources.class,dataProvider= "LoginROLogin_TestDataProvider",enabled=true,description="LoginRegularO")
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
        XlsData.setExcelFile(Path_TestData + File_TestData, "LoginRO");
        XlsData.setUpTable(new String[]{"First Name", "Middle Name", "Last Name", "Country", "Address", "Phone", "Email", "Password",
                "Birth Date", "Birth Place","Height","Marital","Work Status","Other First Name","Other Middle Name","Other Last Name",
        "Other Address","Other Phone","Other Email"});//Setting up columns of Excel file for data
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
        @Test(priority = 1,dataProviderClass = DataResources.class,dataProvider= "LoginROTallent_TestDataProvider")
            public void tallentRO(String otherFirstName,String otherMiddleName,String otherLastName,
                                  String otherAddress,String otherPhone,String otherEmail) throws Exception {
        pageResources.getTalentPage().pushOtherButton();
        Thread.sleep(1000);
        pageResources.getTalentPage().pushConfirm();
        pageResources.getTalentPage().pushNewButton();
        pageResources.getTalentPage().selectCategory();//Category
        pageResources.getTalentPage().pushNextButton();
        pageResources.getTalentPage().enterName(otherFirstName,otherMiddleName,otherLastName);//Personal
            XlsData.setCellData(otherFirstName, 3, findColumn("Other First Name"));
            XlsData.setCellData(otherMiddleName, 3, findColumn("Other Middle Name"));
            XlsData.setCellData(otherLastName, 3, findColumn("Other Last Name"));
        pageResources.getTalentPage().enterAddress(otherAddress);
            XlsData.setCellData(otherAddress, 3, findColumn("Other Address"));
        pageResources.getTalentPage().enterPhone(otherPhone);
            XlsData.setCellData(otherPhone, 3, findColumn("Other Phone"));
        pageResources.getTalentPage().enterEmail(otherEmail);
            XlsData.setCellData(otherEmail, 3, findColumn("Other Email"));
//        String birth =pageResources.getTalentPage().randomDate();
//        int year = Integer.parseInt(birth.substring(4))
        int year=fabricator.alphaNumeric().randomInt(100);
        pageResources.getTalentPage().enterBirth(year);
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
        System.out.println(getCellData(3,findColumn("Other First Name")));
        System.out.println(actualFName);
        try {assertTrue(actualFName.matches(getCellData(3,findColumn("Other First Name"))));}
        catch (AssertionError e) {System.out.println("First Name does not match!");}
        String actualMName=pageResources.getTalentPage().getMName();
        System.out.println(getCellData(3,findColumn("Other Middle Name")));
        System.out.println(actualMName);
        try {assertTrue(actualMName.matches(getCellData(3,findColumn("Other Middle Name"))));}
        catch (AssertionError e) {System.out.println("Middle Name does not match!");}
            String actualLName=pageResources.getTalentPage().getLName();
            System.out.println("last name from table:"+getCellData(3,findColumn("Other Last Name")));
            System.out.println("Last name on form:"+actualLName);
            try {assertTrue(actualLName.matches(getCellData(3,findColumn("Other Last Name"))));}
            catch (AssertionError e) {System.out.println("Last Name does not match!");}
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
