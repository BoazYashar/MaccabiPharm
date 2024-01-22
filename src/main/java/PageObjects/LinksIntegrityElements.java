package PageObjects;

import AbstractComponents.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LinksIntegrityElements extends AbstractComponents {


    @FindBy(xpath = "//div[@class=\"footer-linksWrapper-20Y\"]")
    public WebElement testResultsEl;

    public LinksIntegrityElements (WebDriver driver) {
    }
}
