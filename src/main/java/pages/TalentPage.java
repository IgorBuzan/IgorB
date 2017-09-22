package pages;


import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import static testResources.XlsData.*;

import java.util.List;
import java.util.Random;
import static java.lang.Thread.sleep;

public class TalentPage {
    WebDriver driver;
    WebDriverWait wait;
    public Random rand=new Random();
    JavascriptExecutor ex;
    public TalentPage(WebDriver driver) {
        this.driver=driver;
        wait = new WebDriverWait(driver,5);
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//label[contains(text(),'Yourself')]//span")
    WebElement youButton;
    @FindBy(xpath = "//div//button[@class=\"confirm\"]")
    WebElement confirmButton;
    @FindBy(xpath = "//label[contains(text(),'Other Talent')]//span")
    WebElement otherButton;
    @FindBy(xpath = "//a[contains(text(),'New')]")
    WebElement newButton;
    @FindBy(xpath = "//i[@ng-click='$select.toggle($event)']")
    WebElement categoryButton;
    @FindBy(xpath = "//div[@ng-attr-id='ui-select-choices-row-{{ $select.generatedId }}-{{$index}}']")
    List<WebElement> categoryList;
    @FindBy(xpath = "//button[contains(.,'Next')]")
    WebElement nextButton;
    @FindBy(id = "firstName")
    WebElement fNameField;
    @FindBy(id = "middleName")
    WebElement mNameField;
    @FindBy(id = "lastName")
    WebElement lNameField;
    @FindBy(id = "address")
    WebElement addressField;
    @FindBy(id = "phone")
    WebElement phoneField;
    @FindBy(id = "email")
    WebElement emailField;
    @FindBy(id = "dateBirth")
    WebElement birthField;
    @FindBy(id = "placeBirth")
    WebElement placeBirthField;
    @FindBy(xpath = "//input[@value='RURAL']")
    WebElement ruralRadio;
    @FindBy(xpath = "//input[@value='PRIVILEGED']")
    WebElement priviligedRadio;
    @FindBy(id = "height")
    WebElement heightField;
    @FindBy(id = "weight")
    WebElement weightField;
    @FindBy(xpath = "//select[@name='trainingHistory']")
    WebElement Select;
    @FindBy(xpath = "//input[@name='coached'][@value='false']")
    WebElement noRadio;
    @FindBy(xpath = "//input[@value='SOMETIMES']")
    WebElement sometimesRadio;
    @FindBy(xpath = "//input[@name='schoolName']")
    WebElement schoolNameField;
    @FindBy(xpath = "//input[@name='schoolSuccessLevel']")
    WebElement schoolSuccessLevelField;
    @FindBy(xpath = "//input[@value='ADVANCED']")
    WebElement advancedRadio;
    @FindBy(xpath = "//label[contains(text(),'Family')]//input")
    WebElement familyRadio;
    @FindBy(xpath = "//textarea[@name='testimony0']")
    WebElement testimonyField;
    @FindBy(xpath = "//input[@name='workProduct']")
    WebElement workProduct;
    @FindBy(xpath = "//input[@value='MIDDLE']")
    WebElement middleRadio;
    @FindBy(xpath = "//select[@name='maritalStatus']")
    WebElement selectMarital;
    @FindBy(xpath = "//select[@name='workStatus']")
    WebElement selectWorkStatus;
    @FindBy(xpath = "//select[@name='relation']")
    WebElement selectRelation;
    @FindBy(xpath = "//input[@placeholder='USD']")
    WebElement usdField;
    @FindBy(xpath = "//select[@name='disabilities']")
    WebElement selectDisability;
    @FindBy(xpath = "//textarea[@name='headline']")
    WebElement headlineField;
    @FindBy(xpath = "//input[@name='discoveryYears']")
    WebElement discoveryYearsField;
    @FindBy(xpath = "//select[@name='interestLevel']")
    WebElement selectInterest;
    @FindBy(xpath = "//*[@id='talentForm']//wizard-form//div//ol//li[10]")
    public WebElement quickTestsTab;
    @FindBy(xpath = "//*[@id='talentForm']//wizard-form//div//ol//li[2]")
    WebElement personalTab;
    @FindBy(xpath = "//button[contains(text(),'Finish')]")
    WebElement finishButton;
    @FindBy(xpath = "//em[@class='icon-user']")
    WebElement profileIcon;
    @FindBy(xpath = "//p[contains(text(),'My Profile')]")
    WebElement myProfile;
    @FindBy(xpath = "//a[@ng-click='PublicCtrl.onSignOutClick()']")
    WebElement signOutIcon;
    @FindBy(xpath = "//a[@title='Edit']")
    WebElement editButton;


    public String randomDate() {     //Random DOB generator
        int year = randBetween(1900, 2015);
        int month = randBetween(1,12);
        int day;
        String days,months;
        if (month==2) {
            day= randBetween(1,28);
        } else { day=randBetween(1,30);
        }
        if (day<10) {
            days= "0"+day;
        } else {
            days=String.valueOf(day);
        }
        if (month<10) {
            months= "0"+month;
        } else {
            months=String.valueOf(month);
        }
        return months+days+year;
    }

    public static int randBetween(int start, int end) {     //Random number generator
        return start + (int)Math.round(Math.random() * (end - start));
    }

    //WebElement interaction methods
    public void enterSchoolSuccessLevel(){
        schoolSuccessLevelField.sendKeys(RandomStringUtils.randomAlphanumeric(7));
    }

    public void enterSchoolName(){
        schoolNameField.sendKeys(RandomStringUtils.randomAlphanumeric(7));
    }
    public void sometimesRadioClick(){
        sometimesRadio.click();
    }
    public void noRadioClick(){
        noRadio.click();
    }
    public void selectTraining(){
        int i=rand.nextInt(4);
        Select training= new Select(Select);
        training.selectByIndex(i);
    }
    public void enterWeight(){
        weightField.sendKeys(RandomStringUtils.randomNumeric(2,3));
    }
    public void enterHeight() throws Exception {
        String height=RandomStringUtils.randomNumeric(2,3);
        heightField.sendKeys(height);
        setCellData(height,1,findColumn("Height"));
    }
    public void priviligedRadioClick(){
        priviligedRadio.click();
    }
    public void ruralRadioClick(){
        ruralRadio.click();
    }

    public void enterPlaceBirth()throws Exception {
        String birthPlace=RandomStringUtils.randomAlphabetic(5,7);
        placeBirthField.sendKeys(birthPlace);
        setCellData(birthPlace,1,findColumn("Birth Place"));
    }
    public void enterBirth(String dateBirth) throws Exception {
        birthField.sendKeys(dateBirth);
        dateBirth=dateBirth.substring(0,2)+"/"+dateBirth.substring(2,4)+"/"+dateBirth.substring(4);
        setCellData(dateBirth,1,findColumn("Birth Date"));
    }
    public void enterEmail(){
        emailField.sendKeys(RandomStringUtils.randomAlphanumeric(7)+"@getnada.com");
    }

    public void enterAddress(String address){
        addressField.sendKeys(address);
    }
    public void enterPhone(String phone){
        phoneField.sendKeys(phone);
    }

    public void enterName(String fName,String mName, String lName){
        fNameField.sendKeys(fName);
        mNameField.sendKeys(mName);
        lNameField.sendKeys(lName);
    }
    public void pushNextButton(){
        JavascriptExecutor ex=(JavascriptExecutor)driver;
        ex.executeScript("arguments[0].click();",nextButton);
    }

    public void pushYouButton(){
        youButton.click();
    }

    public void pushConfirm(){
        confirmButton.click();
    }
    public void pushOtherButton(){
        otherButton.click();
    }
    public void pushNewButton(){
        ex=(JavascriptExecutor)driver;
        ex.executeScript("arguments[0].click();",newButton);
    }
    public void selectCategory(){
        ex = (JavascriptExecutor) driver;
        ex.executeScript("arguments[0].click();",categoryButton);
        Random rand=new Random();
        int i=rand.nextInt(17);
        categoryList.get(i).click();
    }
    public void pushFinishButton() {
        finishButton.click();
    }

    public void gotoQuickTestsTab() {
            quickTestsTab.click();

    }

    public void interestLevelListSelect() {
        Select interestLevelList=new Select(selectInterest);
        interestLevelList.selectByIndex(rand.nextInt(5));
    }

    public void EnterDiscoveryYears(int year) {
        discoveryYearsField.sendKeys(String.valueOf(randBetween(year,2017)));
    }

    public void EnterHeadline() {
        headlineField.sendKeys(RandomStringUtils.randomAscii(50,150));
    }

    public void disabilitiesListSelect() {
        Select disabilitiesList=new Select(selectDisability);
        List<WebElement> disabilities=disabilitiesList.getOptions();
        int i=disabilities.size();
        disabilitiesList.selectByIndex(rand.nextInt(i));
    }

    public void enterUsdField() {
        usdField.sendKeys(RandomStringUtils.randomNumeric(4,6));
    }

    public void relationListSelect() {
        Select relationList=new Select(selectRelation);
        relationList.selectByIndex(rand.nextInt(4));
    }

    public void workStatusListSelect() throws Exception {
        Select workStatusList=new Select(selectWorkStatus);
        int el=rand.nextInt(4);
        workStatusList.selectByIndex(el);
        setCellData(workStatusList.getFirstSelectedOption().getAttribute("value"),1,findColumn("Work Status"));
    }
    
    public void maritalListSelect() throws Exception {
        Select maritalList=new Select(selectMarital);
        int el=rand.nextInt(5);
        maritalList.selectByIndex(el);
        setCellData(maritalList.getFirstSelectedOption().getAttribute("value"),1,findColumn("Marital"));
    }
    public String actualMaritalStatus(){
        Select maritalList=new Select(selectMarital);
        return maritalList.getFirstSelectedOption().getAttribute("value");
    }

    public void middleRadioClick() {
        middleRadio.click();
    }

    public void enterWorkProduct() {
        workProduct.sendKeys(RandomStringUtils.randomAlphabetic(30,49));
    }

    public void enterTestimony() {
        try {
            testimonyField.sendKeys(RandomStringUtils.randomAlphabetic(50));
        } catch(StaleElementReferenceException e) {
            testimonyField.sendKeys(RandomStringUtils.randomAlphabetic(50));
        }
    }

    public void familyRadioClick() {
        familyRadio.click();
    }

    public void advancedRadioClick() {
        advancedRadio.click();
    }
    public void gotoMyProfile() {
        try {
            profileIcon.click();
        } catch (StaleElementReferenceException e){
            profileIcon.click();
        }
        myProfile.click();
    }
    public void signOut() {
        try {
            profileIcon.click();
        } catch (StaleElementReferenceException e){
            profileIcon.click();
        }
        signOutIcon.click();
    }

    public void pushEditButton() {
        editButton.click();
    }

    public String getBirthDate() {
        return birthField.getAttribute("value");
    }

    public String getFName() {
        return fNameField.getAttribute("value");
    }

    public String getMName() {
        return mNameField.getAttribute("value");
    }

    public boolean ifSelectedPriviligedRadio() {
        return priviligedRadio.isSelected();
    }

    public String getHeight() {
        return heightField.getAttribute("value");
    }

    public String actualWorkStatus() {
        Select workStatusList=new Select(selectWorkStatus);
        return workStatusList.getFirstSelectedOption().getAttribute("value");
    }


//    public String checkCategory() {
//        categoryList.
//    }
}
