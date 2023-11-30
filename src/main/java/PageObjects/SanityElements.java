package PageObjects;

import AbstractComponents.AbstractComponents;
import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class SanityElements extends AbstractComponents {


    @FindBy(xpath = "//a[@href='/promotions']")
    public WebElement promotionsButtonEL;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[1]/header/div/div[1]/div[3]/div[2]/button")
    public WebElement enterToCart;

    @FindBy(id = "product1")
    public WebElement product1;
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div[1]/div[1]/div/div/div[2]/button")
    public WebElement approveToBuy;
    @FindBy(xpath = "//*[@id=\"productItem\"]/div[2]/div/div/button")
    public WebElement addToCartButton;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div[1]/div[1]/div/div[1]/div/div/label[2]/span")
    public WebElement deliveryOption;


    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div[1]/div[1]/div/div[1]/div/div[2]/form/button")
    public WebElement continueToLevel2;

    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div[2]/div/div[1]/div[1]/div/div[2]/div/div/form/button")
    public WebElement continueToLevel3;

    @FindBy(xpath = "//*[@id=\"step3\"]/div/button")
    public WebElement approveAndFinishOrder;

    @FindBy(xpath = "//*[@id=\"step3\"]/div/button")
    public WebElement approvedOrder;

    public SanityElements (WebDriver driver) {
        super ();
    }

    public void allBuyProcess () throws InterruptedException {

        Object waitForElement = new Object ();
        waitForElement (promotionsButtonEL);
        promotionsButtonEL.click ();
        Uninterruptibles.sleepUninterruptibly (3, TimeUnit.SECONDS);

        Actions action = new Actions (driver);
        action.moveToElement (promotionsButtonEL).moveToElement (product1).build ().perform ();
        Uninterruptibles.sleepUninterruptibly (2, TimeUnit.SECONDS);

        addToCartButton.click ();
        Uninterruptibles.sleepUninterruptibly (2, TimeUnit.SECONDS);
        enterToCart.click ();
        Uninterruptibles.sleepUninterruptibly (2, TimeUnit.SECONDS);

        approveToBuy.click ();
        Uninterruptibles.sleepUninterruptibly (2, TimeUnit.SECONDS);
        deliveryOption.click ();
        continueToLevel2.click ();
        continueToLevel3.click ();
//   approveAndFinishOrder.click ();///Pay attention -  Make a real purchase
    }
}
