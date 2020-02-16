package pages.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AtlassianRegistrationPage {

    @FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div[2]/div[2]/div/section/div[1]/h5")
    private WebElement registrationTitle;

    @FindBy(css = "input#email")
    private WebElement emailField;

    @FindBy(css = "input#displayName")
    private WebElement firstLastNameField;

    @FindBy(css = "input#password")
    private WebElement passwordField;

    @FindBy(css = "button#signup-submit")
    private WebElement registerButton;

    WebDriver driver;

    public AtlassianRegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getRegistrationTitle() {
        return registrationTitle;
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getFirstLastNameField() {
        return firstLastNameField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getRegisterButton() {
        return registerButton;
    }
}
