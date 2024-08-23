package com.browserstack.steps;

import com.browserstack.helpers.DriverProvider;
import com.browserstack.pages.FormAuthenticationPage;
import com.browserstack.pages.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class FormAuthenticationSteps {
    private WebDriver driver;
    private HomePage homePage;
    private FormAuthenticationPage formAuthenticationPage;

    @Before
    public void setUp() {
        driver = DriverProvider.getDriver();
        homePage = new HomePage(driver);
    }

    @Given("I am on the form authentication page")
    public void iAmOnTheFormAuthenticationPage() {
        homePage.clickFormAuthentication();
        formAuthenticationPage = new FormAuthenticationPage(driver);
    }

    @When("I enter valid credentials")
    public void iEnterValidCredentials() {
        formAuthenticationPage.enterUsername("tomsmith");
        formAuthenticationPage.enterPassword("SuperSecretPassword!");
    }

    @When("I enter invalid credentials")
    public void iEnterInvalidCredentials() {
        formAuthenticationPage.enterUsername("invalidUser");
        formAuthenticationPage.enterPassword("invalidPassword");
    }

    @When("I click the login button")
    public void iClickTheLoginButton() {
        formAuthenticationPage.clickLoginButton();
    }

    @Then("I should be redirected to the secure area")
    public void iShouldBeRedirectedToTheSecureArea() {
        assertTrue(formAuthenticationPage.isSecureAreaDisplayed());
    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        assertTrue(formAuthenticationPage.isErrorMessageDisplayed());
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}