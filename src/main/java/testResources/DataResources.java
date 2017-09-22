package testResources;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.DataProvider;

public class DataResources {
    @DataProvider(name="Negative_TestDataProvider")
    //Test Data for negative login tests
    public static Object[][] getNegativeData(){
        Object[][] data = new Object[4][5];
        data[0][0]= RandomStringUtils.randomAlphanumeric(7).toLowerCase()+"@getnada.com";//registered email
        data[0][1]= RandomStringUtils.randomAlphanumeric(8);//registered password
        data[0][2]= RandomStringUtils.randomAlphanumeric(7).toLowerCase()+"@getnada.com";//invalid email for entering
        data[0][3]=data[0][1];//valid password
        data[0][4]="System let user in with wrong email";//error message
        data[1][0]= RandomStringUtils.randomAlphanumeric(7).toLowerCase()+"@getnada.com";//registered emai
        data[1][1]= RandomStringUtils.randomAlphanumeric(8);//registered password
        data[1][2]= data[1][0];//valid email
        data[1][3]= RandomStringUtils.randomAlphanumeric(8);//invalid password
        data[1][4]="System let user in with wrong password";//error message
        data[2][0]= RandomStringUtils.randomAlphanumeric(7).toLowerCase()+"@getnada.com";//registered emai
        data[2][1]= RandomStringUtils.randomAlphanumeric(8);//registered password
        data[2][2]= "";//blank email
        data[2][3]=data[2][1];//valid password
        data[2][4]="System let user in with blank email";//error message
        data[3][0]= RandomStringUtils.randomAlphanumeric(7).toLowerCase()+"@getnada.com";//registered emai
        data[3][1]= RandomStringUtils.randomAlphanumeric(8);//registered password
        data[3][2]= data[3][0];//valid email
        data[3][3]="";//blank password
        data[3][4]="System let user in with blank password";//error message
        return data;
    }

    @DataProvider(name = "LoginRU_TestDataProvider")
    public static Object[][] getlogRUData(){
        //Test data for end-to-end login RU test
        Object[][] data = new Object[1][8];
        data[0][0]= RandomStringUtils.randomAlphanumeric(7).toLowerCase()+"@getnada.com";//email
        data[0][1]= RandomStringUtils.randomAlphanumeric(8);//password
        data[0][2]= RandomStringUtils.randomAlphabetic(5);//first name
        data[0][3]= RandomStringUtils.randomAlphabetic(5);//middle name
        data[0][4]= RandomStringUtils.randomAlphabetic(5);//last name
        data[0][5]= RandomStringUtils.randomAlphabetic(4,7);//country
        data[0][6]= RandomStringUtils.randomNumeric(4)+" "+RandomStringUtils.randomAlphabetic(5);//address
        data[0][7]= RandomStringUtils.randomNumeric(10);//phone#
        return data;
    }
    @DataProvider(name= "LoginRO_TestDataProvider")
    public static Object[][] getLogROData() {
        //Test data for end-to-end RO test
        Object[][] data = new Object[1][8];
        data[0][0]= RandomStringUtils.randomAlphanumeric(8).toLowerCase()+"@getnada.com";//email
        data[0][1]= RandomStringUtils.randomAlphanumeric(8);//password
        data[0][2]= RandomStringUtils.randomAlphabetic(5);//first name
        data[0][3]= RandomStringUtils.randomAlphabetic(5);//middle name
        data[0][4]= RandomStringUtils.randomAlphabetic(5);//last name
        data[0][5]= RandomStringUtils.randomAlphabetic(4,7);//country
        data[0][6]= RandomStringUtils.randomNumeric(4)+" "+RandomStringUtils.randomAlphabetic(5);//address
        data[0][7]= RandomStringUtils.randomNumeric(10);//phone#
        return data;
    }
    @DataProvider(name= "LoginScout_TestDataProvider")
    public static Object[][] getLogRScoutData() {
        //Test data for end-to-end scout test
        Object[][] data = new Object[1][8];
        data[0][0]= RandomStringUtils.randomAlphanumeric(7).toLowerCase()+"@getnada.com";//email
        data[0][1]= RandomStringUtils.randomAlphanumeric(8);//password
        data[0][2]= RandomStringUtils.randomAlphabetic(5);//first name
        data[0][3]= RandomStringUtils.randomAlphabetic(5);//middle name
        data[0][4]= RandomStringUtils.randomAlphabetic(5);//last name
        data[0][5]= RandomStringUtils.randomAlphabetic(4,7);//country
        data[0][6]= RandomStringUtils.randomNumeric(4)+" "+RandomStringUtils.randomAlphabetic(5);//address
        data[0][7]= RandomStringUtils.randomNumeric(10);//phone#
        return data;
    }
}
