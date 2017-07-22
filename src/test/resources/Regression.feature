Feature: Regression
  As a LaunchWorks tester, when LaunchPortal is deployed, I expect to see key functionality is working

Scenario: administrator can login to administration console
  Given I am on the LaunchPortal administrator login page
  When I enter valid credentials and hit the Logon button
  Then I see I am logged into the administrator console