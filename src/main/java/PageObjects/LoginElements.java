package PageObjects;

import AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginElements extends AbstractComponents {


    @FindBy(id = "tab1")
    public WebElement loginWithPermanentPass;
    @FindBy(id = "identifyWithPasswordCitizenId")
    public WebElement idEL;
    @FindBy(id = "password")
    public WebElement passEl;
    @FindBy(xpath = "//button[@class=\"submit validatePassword\"]")
    public WebElement loginButton;

    public LoginElements (WebDriver driver) {
       // super (driver);
        this.driver = driver;
        PageFactory.initElements (driver, this);
    }

    public void login (String id, String pass) {

        loginWithPermanentPass.click ();
        idEL.sendKeys (id);
        passEl.clear ();
        passEl.sendKeys (pass);
        loginButton.click ();

    }

    public int solution(int[] A) {

        // Initialize the smallest positive integer to 1
        int smallestPositive = 0;


        // Iterate through the sorted array
        for (int i = 0; i < A.length; i++) {
            // If the current element is negative or equal to the smallest positive, continue to the next element
            if (A[i] > 0 & A[i] < smallestPositive) {
                smallestPositive =A[i];
            }

        }
        return smallestPositive;

    }

}
