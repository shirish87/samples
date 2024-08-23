package com.browserstack.tests;

import com.microsoft.playwright.*;
import com.browserstack.pages.FormAuthenticationPage;
import com.browserstack.pages.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class FormAuthenticationTest {
    private Playwright playwright;
    private Browser browser;
    private Page page;
    private HomePage homePage;

    @Before
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        page = browser.newPage();
        homePage = new HomePage(page);
    }

    @Test
    public void testFormAuthentication() {
        homePage.clickFormAuthentication();
        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage(page);

        formAuthenticationPage.enterUsername("tomsmith");
        formAuthenticationPage.enterPassword("SuperSecretPassword!");
        formAuthenticationPage.clickLoginButton();

        // Add assertions to verify the login attempt
        assertTrue(page.content().contains("You logged into a secure area!"));
    }

    @After
    public void tearDown() {
        if (browser != null) {
            browser.close();
        }

        if (playwright != null) {
            playwright.close();
        }
    }
}
