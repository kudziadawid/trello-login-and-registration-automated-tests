Feature: Registration on Trello website

  Scenario: Registration attempt with already registered e-mail address
    Given I navigate to the Signup page with “nettestgutu@gmail.com” e-mail address
    When I enter “!1QAZ1qaz1!” to the password field
    And I clear the e-mail address
    And I enter already registered e-mail address to the e-mail field
    And I click on the Register button
    Then I verify that the user is navigated to the Login screen
    And I verify that „Wygląda na to, że masz już konto powiązane z tym adresem e-mail. Zaloguj się lub zresetuj hasło, jeśli go nie pamiętasz” message is visible