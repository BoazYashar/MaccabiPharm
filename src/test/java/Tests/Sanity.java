package Tests;

import PageObjects.PromotionsElements;
import PageObjects.SanityElements;
import TestComponents.BaseTest;
import TestComponents.Verifications;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class Sanity extends BaseTest {
    SanityElements SE;


    @BeforeClass(alwaysRun = true)
    public void beforeClass () throws IOException {
        driver = initializeDriver ();
        SE = new SanityElements (driver);

    }

    @Test(description = "All buy Process", groups = "Sanity")
    public void allBuyProcess () throws InterruptedException {
        SE.allBuyProcess ();
        Verifications.verifyTextInElement (SE.approvedOrder,"ההזמנה אושרה");
    }
}
