package Tests;

import PageObjects.LinksIntegrityElements;
import PageObjects.PromotionsElements;
import TestComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LinksIntegrity extends BaseTest {

    LinksIntegrityElements LIE;


    @BeforeClass (alwaysRun = true)
    public void beforeClass () throws IOException {
        driver = initializeDriver ();
        LIE = new LinksIntegrityElements (driver);

    }

    @Test(description = "Test if links are working")
    @Description(" ")
    public void brokenListTest () throws MalformedURLException, IOException {

        List<WebElement> Links = LIE.testResultsEl.findElements (By.xpath ("//*[@href]"));
        SoftAssert a = new SoftAssert ();
        for (WebElement link : Links) {

            String url = link.getAttribute ("href");
            System.out.println (url);
            HttpURLConnection conn = (HttpURLConnection) new URL (url).openConnection ();

            conn.setRequestMethod ("HEAD");
            conn.connect ();
            int respCode = conn.getResponseCode ();

            System.out.println (respCode);

            a.assertTrue (respCode < 400, "The link with Text" + link.getText () + " is broken with code" + respCode);
            a.assertAll ();
        }


    }
}