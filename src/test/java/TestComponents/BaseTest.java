package TestComponents;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {


    protected static WebDriver driver;

    protected static WebDriverWait wait;
    protected static SoftAssert softAsserts;

    public WebDriver initializeDriver () throws IOException {

//    Properties Class
        Properties prop = new Properties ();

        String filePath = System.getProperty ("user.dir") + "/src/main/resources/GlobalData.properties";

        FileInputStream fis = new FileInputStream (filePath);

        prop.load (fis);
        String browserName = prop.getProperty ("browser");

        if (browserName.equalsIgnoreCase ("chrome")) {

            WebDriverManager.chromedriver ().setup ();
            ChromeOptions opt = new ChromeOptions ();
            opt.setExperimentalOption ("debuggerAddress", "localhost:9222");
            driver = new ChromeDriver (opt);

        } else if (browserName.equalsIgnoreCase ("edge")) {

            System.setProperty ("webdriver.edge.driver", "edge.exe");
            driver = new EdgeDriver ();

        } else if (browserName.equalsIgnoreCase ("firefox")) {

            System.setProperty ("webdriver.firefox.driver", "firefox.exe");
            driver = new FirefoxDriver ();

        }


        return driver;
    }


    public void launchSite () throws IOException {

        driver = initializeDriver ();
        driver.get ("https://mac.maccabi4u.co.il/magento/login?SAMLRequest=lZJfb9owFMXf%2BRSV30mckE7UAqSsrBsSAwSsD3uZbpwLWPKfzNfZ2m9fk7Rdu6mVdm2%2FHPv8dO6VJwRGN6Jsw8lu8WeLFAYXse6MtiS6yylrvRUOSJGwYJBEkGJXfl2KPOGi8S446TT7y%2Fa%2BC4jQB%2BVsb1vMp2y9%2BrRcf16sfuTy8IFnMpeVvJIVzys8XMWVjeo6GwEf86rgh2JU9NZb9BQ5UxaxbNDTiFpcWApgQ9R5Phrycdx7PhaXheD59946j80qC6Gzn0JoSKSpAZnEI6FSRZtIlygdtSPa4FLtjuox8eax7Y%2FK1soe3%2B%2B26h%2BR%2BLLfb4ab9W7fQ8qnKVw7S61Bv0P%2FS0n8tl2%2BCnQO05zAm3%2BSEbn0PO08BUls1lEnZ0F0Q%2FCz%2F6QYDFBDgEn6EvIH24hV7G4x3zit5H2nn%2BvGeQPh7SFkSdYpqh4euqcCDShd1rVHIvbMKbV2v689QsApC75FdpHOBn2Y15909gA%3D&RelayState=https%3A%2F%2Fmaccabipharm.maccabi4u.co.il%2F&SigAlg=http%3A%2F%2Fwww.w3.org%2F2000%2F09%2Fxmldsig%23rsa-sha1&Signature=oMJ%2FDp44MHo4tnseG%2F3dxh1r89tn8FxyQXaaFYA10CnG4hNP8KMGS3z2Jk8HYit1cQ5%2FiV5hFyQcq%2Bkk%2B5lZ%2BXFgcMuOByEYfkDWeqnGfdXURgFGTAQXsXYT7TcqzgBuQsUJfxEXahgPBjvIbwvdydam4v2yGQZelE50LK%2BDODU%3D");
        System.setProperty ("webdriver.chrome.verboseLogging", "true");
//        driver.manage ().window ().maximize ();

    }

}

