package pages.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlreadyRegisteredPage {

    @FindBy(css = "div#login-info")
    private WebElement titleMessage;

    WebDriver driver;

    public AlreadyRegisteredPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getTitleMessage() {
        return titleMessage;
    }
}
