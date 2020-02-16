# Trello login and registration automated tests

Two automated scenarios (of 37 prepared)  to verify Trello login and registration


## Configuration

Due to configuration problems, tests can be run properly if:
1. Chrome driver file path is: "C:\Program Files\chromedriver\chromedriver.exe"
2. System.setProperty (in both bindings classes) will be changed to the correct path

## Test runners
1. Login: runners.login.LoginWithChangedUnregisteredEmailRunner
2. Registration: runners.registration.RegistrationWithRegisteredEmailRunner 