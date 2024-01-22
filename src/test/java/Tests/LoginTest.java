package Tests;

import PageObjects.LoginElements;
import TestComponents.BaseTest;
import TestComponents.Retry;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;

public class LoginTest extends BaseTest {
    LoginElements LE;


    @BeforeClass(alwaysRun = true)
    public void beforeClass () throws IOException {
        launchSite ();
        LE = new LoginElements (driver);


    }

    @Test(dataProvider = "getData", description = "Login to Maccabi Pharm site", retryAnalyzer = Retry.class)
    public void login (HashMap<String, String> input) {

        LE.login (input.get ("id"), input.get ("password"));

    }


    @DataProvider
    public Object[][] getData () {
        HashMap<String, String> map = new HashMap<String, String> ();
        map.put ("id", "313519589");
        map.put ("password", "ZLG942bv");
//
//        HashMap<String, String> map1 = new HashMap<String, String> ();
//        map.put ("id", "313519589");
//        map.put ("password", "ZLG942bv");

        return new Object[][]{{map}};
    }

}
