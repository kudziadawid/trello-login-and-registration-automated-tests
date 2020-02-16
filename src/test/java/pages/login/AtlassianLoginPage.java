package pages.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AtlassianLoginPage {

    @FindBy(css = "input#username")
    private WebElement emailField;

    @FindBy(css = "button#login-submit")
    private WebElement logInButton;

    WebDriver driver;

    public AtlassianLoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getLogInButton() {
        return logInButton;
    }
}
