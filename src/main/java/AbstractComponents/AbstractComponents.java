package AbstractComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponents {

    public WebDriver driver;
    public WebDriverWait wait;

    public void waitForElement (WebElement findBy) {

        wait = new WebDriverWait (driver, Duration.ofSeconds (10));
        wait.until (ExpectedConditions.visibilityOf (findBy));
    }


}
