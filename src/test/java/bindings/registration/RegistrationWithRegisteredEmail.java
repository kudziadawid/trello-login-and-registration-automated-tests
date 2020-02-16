package bindings.registration;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.registration.AlreadyRegisteredPage;
import pages.registration.AtlassianRegistrationPage;
import pages.registration.TrelloRegistrationPage;

import java.util.concurrent.TimeUnit;

public class RegistrationWithRegisteredEmail {

    WebDriver driver;
    TrelloRegistrationPage trelloRegistrationPage;
    AtlassianRegistrationPage atlassianRegistrationPage;
    AlreadyRegisteredPage alreadyRegisteredPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Given("^I navigate to the Signup page with \"([^\"]*)\" e-mail address$")
    public void navigate_to_signup_page_with_email_address(String email) {
        driver.navigate().to("https://trello.com/signup");
        trelloRegistrationPage = new TrelloRegistrationPage(driver);
        trelloRegistrationPage.getEmailField().sendKeys(email);
        trelloRegistrationPage.getContinueButton().click();
    }

    @When("^I enter \"([^\"]*)\" to the password field$")
    public void enter_password_to_the_password_field(String password) {
        atlassianRegistrationPage = new AtlassianRegistrationPage(driver);
        atlassianRegistrationPage.getPasswordField().sendKeys(password);
    }

    @When("^I clear the e-mail address$")
    public void clear_email_address() {
        atlassianRegistrationPage.getEmailField().sendKeys((Keys.chord(Keys.CONTROL,"a", Keys.DELETE)));
    }

    @When("^I enter \"([^\"]*)\" - already registered e-mail address to the e-mail field$")
    public void enter_already_registered_email_to_the_email_field(String registeredEmail) {
        atlassianRegistrationPage.getEmailField().sendKeys(registeredEmail);
    }

    @When("^I click on the Register button$")
    public void click_on_the_register_button() {
        atlassianRegistrationPage.getRegisterButton().click();
    }

    @When("^I verify that \"([^\"]*)\" message is visible$")
    public void verify_user_is_navigate_to_the_login_screen(String loginMessage) {
        alreadyRegisteredPage = new AlreadyRegisteredPage(driver);
        Assert.assertEquals(alreadyRegisteredPage.getTitleMessage().getText(), loginMessage);
    }

    @After
    public void cleanUp() {
        driver.close();
    }
}
