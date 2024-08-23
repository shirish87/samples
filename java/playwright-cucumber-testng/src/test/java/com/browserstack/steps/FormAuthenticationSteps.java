package com.browserstack.steps;

import com.browserstack.pages.FormAuthenticationPage;
import com.browserstack.pages.HomePage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class FormAuthenticationSteps {
    private Playwright playwright;
    private Browser browser;
    private Page page;
    private HomePage homePage;
    private FormAuthenticationPage formAuthenticationPage;

    @Before
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        page = browser.newPage();
        homePage = new HomePage(page);
    }

    @Given("I am on the form authentication page")
    public void iAmOnTheFormAuthenticationPage() {
        homePage.clickFormAuthentication();
        formAuthenticationPage = new FormAuthenticationPage(page);
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
        Assert.assertTrue(formAuthenticationPage.isSecureAreaDisplayed());
    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        Assert.assertTrue(formAuthenticationPage.isErrorMessageDisplayed());
    }

    @After
    public void tearDown() {
        if (page != null) {
            page.close();
        }
        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}
