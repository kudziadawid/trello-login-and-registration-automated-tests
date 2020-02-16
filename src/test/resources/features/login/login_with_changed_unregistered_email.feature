Feature: Login on Trello website

  Scenario: Atlassian login with a changed, unregistered e-mail
    Given I navigate to the Atlassian Login Screen
    When I clear the e-mail field
    And I enter an "nettestguru123@gmail.com" to the e-mail field
    And I click on the continue button
    Then I verify that "Zarejestruj się i utwórz konto" text is visible
    And I verify that the e-mail field is visible
    And I verify that the First and Last Name field is visible
    And I verify that the password field is visible
