package testResources;

import com.github.javafaker.Faker;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

public class DataResources {
    @DataProvider(name="Negative_TestDataProvider")
    //Test Data for negative login tests
    public static Object[][] getNegativeData(){
        Faker fake =new Faker();
        Object[][] data = new Object[4][5];
        data[0][0]= fake.internet().emailAddress();//registered email
        data[0][1]= RandomStringUtils.randomAlphanumeric(8);//registered password
        data[0][2]= fake.internet().emailAddress();//invalid email for entering
        data[0][3]=data[0][1];//valid password
        data[0][4]="System let user in with wrong email";//error message
        data[1][0]= fake.internet().emailAddress();//registered emai
        data[1][1]= RandomStringUtils.randomAlphanumeric(8);//registered password
        data[1][2]= data[1][0];//valid email
        data[1][3]= RandomStringUtils.randomAlphanumeric(8);//invalid password
        data[1][4]="System let user in with wrong password";//error message
        data[2][0]= fake.internet().emailAddress();//registered emai
        data[2][1]= RandomStringUtils.randomAlphanumeric(8);//registered password
        data[2][2]= "";//blank email
        data[2][3]=data[2][1];//valid password
        data[2][4]="System let user in with blank email";//error message
        data[3][0]= fake.internet().emailAddress();//registered emai
        data[3][1]= RandomStringUtils.randomAlphanumeric(8);//registered password
        data[3][2]= data[3][0];//valid email
        data[3][3]="";//blank password
        data[3][4]="System let user in with blank password";//error message
        return data;
    }

    @DataProvider(name = "LoginRU_TestDataProvider")
    public static Object[][] getlogRUData(){
        Faker fake =new Faker();
        //Test data for end-to-end login RU test
        Object[][] data = new Object[1][8];
        data[0][0]= fake.internet().emailAddress();//email
        data[0][1]= RandomStringUtils.randomAlphanumeric(8);//password
        data[0][2]= fake.name().firstName();//first name
        data[0][3]= fake.name().firstName();//middle name
        data[0][4]= fake.name().lastName();//last name
        data[0][5]= fake.address().country();//country
        data[0][6]= fake.address().streetAddress();//address
        data[0][7]= fake.phoneNumber().cellPhone();//phone#
        return data;
    }
    @DataProvider(name= "LoginROLogin_TestDataProvider")
    public static Object[][] getLogROLData() {
        Faker fake =new Faker();
        //Test data for end-to-end RO test
        Object[][] data = new Object[1][8];
        data[0][0]= fake.internet().emailAddress();//email
        data[0][1]= RandomStringUtils.randomAlphanumeric(8);//password
        data[0][2]= fake.pokemon().name();//first name
        data[0][3]= fake.name().firstName();//middle name
        data[0][4]= fake.name().lastName();;//last name
        data[0][5]= fake.address().country();;//country
        data[0][6]= fake.address().streetAddress();//address
        data[0][7]= fake.phoneNumber().cellPhone();//phone#
        return data;
    }
    @DataProvider(name= "LoginROTallent_TestDataProvider")
    public static Object[][] getLogROTData() {
        Faker fake =new Faker();
        Object[][] data = new Object[1][6];
        data[0][0]= fake.name().firstName();//Other First Name
        data[0][1]= fake.name().firstName();//Other Middle Name
        data[0][2]= fake.name().lastName();//Other Last Name
        data[0][3]= fake.address().streetAddress();//Other address
        data[0][4]= fake.phoneNumber().cellPhone();//Other phone#
        data[0][5]= fake.internet().emailAddress();//Other email
        return data;
    }

    @DataProvider(name= "LoginScout_TestDataProvider")
    public static Object[][] getLogRScoutData() {
        Faker fake =new Faker();
        //Test data for end-to-end scout test
        Object[][] data = new Object[1][8];
        data[0][0]= fake.internet().emailAddress();//email
        data[0][1]= RandomStringUtils.randomAlphanumeric(8);//password
        data[0][2]= fake.pokemon().name();//first name
        data[0][3]= fake.name().firstName();//middle name
        data[0][4]= fake.name().lastName();//last name
        data[0][5]= fake.address().country();//country
        data[0][6]= fake.address().streetAddress();//address
        data[0][7]= fake.phoneNumber().cellPhone();//phone#
        return data;
    }
}
