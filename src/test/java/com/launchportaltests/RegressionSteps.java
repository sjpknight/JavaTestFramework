package com.launchportaltests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

// todo setup pageobject type stuff
public class RegressionSteps extends CukesRunner {

    @Given("^I am on the LaunchPortal administrator login page$")
    public void i_am_on_the_LaunchPortal_administrator_login_page() throws Throwable {
        driver.get(props.get("localUrl")+"administration");
    }

    @When("^I enter valid credentials and hit the Logon button$")
    public void i_enter_valid_credentials_and_hit_the_Logon_button() throws Throwable {
        driver.findElement(By.cssSelector("[name=\"username\"]")).sendKeys(props.get("adminUserName").toString());
        driver.findElement(By.cssSelector("[name=\"password\"]")).sendKeys(props.get("adminUserPassword").toString());
        driver.findElement(By.cssSelector("input[value=Logon]")).click();
    }

    @Then("^I see I am logged into the administrator console$")
    public void i_see_I_am_logged_into_the_administrator_console() throws Throwable {
        String pageTitle = driver.getTitle();
        String pageHeader = driver.findElement(By.cssSelector("tr.header > td:nth-of-type(1)")).getText();
        String addApplicationLink = driver.findElement(By.cssSelector("tbody > tr:nth-of-type(3) > td.adminlink > a")).getText();
        String viewApplicationLink = driver.findElement(By.cssSelector("tbody > tr:nth-of-type(4) > td.adminlink > a")).getText();
        assertThat(pageTitle).isEqualToIgnoringCase("Launch Admin");
        assertThat(pageHeader).isEqualToIgnoringCase("Launch Administration Control Panel");
        assertThat(addApplicationLink).isEqualToIgnoringCase("Add Application");
        assertThat(viewApplicationLink).isEqualToIgnoringCase("View Applications");
    }
}