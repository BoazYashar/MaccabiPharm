package Tests;

import PageObjects.PromotionsElements;
import TestComponents.BaseTest;
import TestComponents.Verifications;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

public class Promotions extends BaseTest {


    PromotionsElements PE;

    @BeforeClass (alwaysRun = true)
    public void beforeClass () throws IOException {
        driver = initializeDriver ();
        PE = new PromotionsElements (driver);

    }

    @Test (description = "Sorting by coast, ABC and Relevance", groups = "Promotions")
    public void filterBy () throws InterruptedException {

        PE.sortingBy ();
        Verifications.verifyTextInElement (PE.filterByTitle,"סדר א-ב");
    }
    @Test (description = "Add Two To Cart And Erase one From Cart", groups = "Promotions")
    public void addTwoToCartAndEraseOneFromCart () throws InterruptedException {

        PE.addTwoToCartAndEraseOneFromCart ();
        Verifications.verifyTextInElement (PE.numberOfProductsInCartEL,"1");

    }

    @Test (description = "Add To Cart All Products In The Page", groups = "Promotions")
    public void addToCartAllProductsInThePage () throws IOException, InterruptedException {
        PE.addToCartAllProductsInThePage ();
        Verifications.verifyTextInElement (PE.numberOfProductsInCartEL,"12");

    }

    @Test(description = "Filter Products", groups = "Promotions")
    public void filterProducts () {

        PE.filterProducts ();
        Assert.assertTrue (PE.altmanFilter.isEnabled (), "The Altman filter is disable");
        Assert.assertTrue (PE.superbFilter.isEnabled (), "The Superb filter is disable");

    }



}


