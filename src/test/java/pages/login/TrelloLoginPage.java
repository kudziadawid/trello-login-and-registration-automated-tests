package pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TrelloLoginPage {

    @FindBy(css = "input#user")
    private WebElement emailField;

    @FindBy(css = "input#login")
    private WebElement LogInButton;

    WebDriver driver;

    public TrelloLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getLogInButton() {
        return LogInButton;
    }
}
