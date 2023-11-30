package PageObjects;

import AbstractComponents.AbstractComponents;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PromotionsElements extends AbstractComponents {

    @FindBy(id = "product1")
    public WebElement product1;

    @FindBy(xpath = "//*[@aria-label=\"הוספה לסל\"]")
    public List<WebElement> mouseOverProduct;
    @FindBy(xpath = "//*[@id=\"productItem\"]/div[2]/div/div/button")
    public WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"productItem\"]/div[2]/div/div/button")
    public WebElement eraseFromCartButton;


    @FindBy(xpath = "//div[@class=\"productSort-chevron-1mw productSort-chevron-1mw\"]")
    public WebElement filterBy;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/article/div/div[2]/div[2]/div[2]/div/div/div[2]/ul/li[2]/button/span/span")
    public WebElement filterByPrice;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/article/div/div[2]/div[2]/div[2]/div/div/div[2]/ul/li[3]/button/span/span")

    public WebElement filterByABC;
    @FindBy(xpath = "//a[@href='/promotions']")
    public WebElement promotionsButtonEL;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[1]/header/div/div[1]/div[3]/div[2]/button/span")
    public WebElement numberOfProductsInCartEL;


    @FindBy(xpath = "//*[contains(@id,'product')]/a")
    public List<WebElement> productView;

    @FindBy(xpath = "//div[@class=\"gallery-root-16K\"]")
    public WebElement PromotionsEl;

    @FindBy(xpath = "//input[@id=\"item-mac_brand_name-3\"]/following-sibling::span")
    public WebElement altmanFilter;

    @FindBy(xpath = "//*[@id=\"rangePrice\"]/input")
    public WebElement sliderFilter;


    @FindBy(xpath = "//button[@class=\"filterList-showMore-y2m\"]")
    public WebElement showMoreFilters;


    @FindBy(xpath = "//input[@id=\"item-mac_brand_name-14\"]//following-sibling::span")
    public WebElement superbFilter;

    public PromotionsElements (WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements (driver, this);
    }



    public void sortingBy () throws InterruptedException {

        waitForElement (promotionsButtonEL);
        promotionsButtonEL.click ();
        Uninterruptibles.sleepUninterruptibly (5, TimeUnit.SECONDS);
        filterBy.click ();
        filterByPrice.click ();
        Uninterruptibles.sleepUninterruptibly (5, TimeUnit.SECONDS);

        filterBy.click ();
        filterByABC.click ();

    }

    public void addTwoToCartAndEraseOneFromCart () throws InterruptedException {

        waitForElement (promotionsButtonEL);
        promotionsButtonEL.click ();
        Uninterruptibles.sleepUninterruptibly (5, TimeUnit.SECONDS);

        Actions action = new Actions (driver);
        action.moveToElement (promotionsButtonEL).moveToElement (product1).build ().perform ();
        addToCartButton.click ();
        eraseFromCartButton.click ();

    }


    public void addToCartAllProductsInThePage () {

        waitForElement (promotionsButtonEL);

        promotionsButtonEL.click ();
        Uninterruptibles.sleepUninterruptibly (3, TimeUnit.SECONDS);

        System.out.println ("The size of  productView is: " + productView.size ());
//
        productView.stream ().forEach (s ->
        {
            waitForElement (s);
            s.click ();
            Uninterruptibles.sleepUninterruptibly (3, TimeUnit.SECONDS);

            addToCartButton.click ();
            Uninterruptibles.sleepUninterruptibly (3, TimeUnit.SECONDS);

            driver.navigate ().back ();
        });


    }

    public void filterProducts () {
        waitForElement (sliderFilter);
        Actions action = new Actions (driver);
        action.dragAndDropBy (sliderFilter, -10, 20).perform ();
        altmanFilter.click ();
        showMoreFilters.click ();
        Uninterruptibles.sleepUninterruptibly (2, TimeUnit.SECONDS);
        superbFilter.click ();

    }

}
