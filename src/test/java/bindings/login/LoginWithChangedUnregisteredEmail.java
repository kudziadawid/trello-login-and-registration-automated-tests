package bindings.login;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.login.AtlassianLoginPage;
import pages.login.TrelloLoginPage;
import pages.registration.AtlassianRegistrationPage;

import java.util.concurrent.TimeUnit;

public class LoginWithChangedUnregisteredEmail {

    WebDriver driver;
    AtlassianLoginPage atlassianLoginPage;
    TrelloLoginPage trelloLoginPage;
    AtlassianRegistrationPage atlassianRegistrationPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Given("^I navigate to the Atlassian Login Screen$")
    public void navigate_to_the_atlassian_login_screen() {
        driver.navigate().to("https://trello.com/login");
        trelloLoginPage = new TrelloLoginPage(driver);
        trelloLoginPage.getEmailField().sendKeys("dawka_ck@op.pl");
        trelloLoginPage.getLogInButton().click();
    }

    @When("^I clear the e-mail field$")
    public void clear_email_field() {
        atlassianLoginPage = new AtlassianLoginPage(driver);
        atlassianLoginPage.getEmailField().clear();
    }

    @When("^I enter an \"([^\"]*)\" to the e-mail field$")
    public void enter_unregistered_mail_to_email_field(String unregistered_email) {
        atlassianLoginPage.getEmailField().sendKeys(unregistered_email);
    }

    @When("^I click on the continue button$")
    public void click_continue_button() {
        atlassianLoginPage.getLogInButton().click();
    }

    @Then("^I verify that \"([^\"]*)\" text is visible$")
    public void verify_text_is_visible(String text) {
        atlassianRegistrationPage = new AtlassianRegistrationPage(driver);
        Assert.assertEquals(atlassianRegistrationPage.getRegistrationTitle().getText(), text);
    }

    @Then("^I verify that the e-mail field is visible$")
    public void verify_email_field_is_visible() {
        Assert.assertTrue(atlassianRegistrationPage.getEmailField().isDisplayed());
    }

    @Then("^I verify that the First and Last Name field is visible$")
    public void verify_first_and_last_name_field_is_visible() {
        Assert.assertTrue(atlassianRegistrationPage.getFirstLastNameField().isDisplayed());
    }

    @Then("^I verify that the password field is visible$")
    public void verify_password_field_is_visible() {
        Assert.assertTrue(atlassianRegistrationPage.getPasswordField().isDisplayed());
    }

    @After
    public void cleanUp() {
        driver.close();
    }
}
