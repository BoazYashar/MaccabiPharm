package PageObjects;

import AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginElements extends AbstractComponents {

    public WebDriver driver;
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



}
