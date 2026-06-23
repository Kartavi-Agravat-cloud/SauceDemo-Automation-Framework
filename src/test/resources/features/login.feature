Feature: Login Functionality

Scenario Outline: Login Validation

Given User launches SauceDemo application
When User enters username "<username>" and password "<password>"
And User clicks Login button
Then User should see result "<result>"

Examples:
| username        | password      | result |
| standard_user   | secret_sauce  | PASS   |
| locked_out_user | secret_sauce  | FAIL   |