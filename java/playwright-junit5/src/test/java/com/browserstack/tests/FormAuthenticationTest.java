package com.browserstack.tests;

import com.microsoft.playwright.*;
import com.browserstack.pages.FormAuthenticationPage;
import com.browserstack.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class FormAuthenticationTest {
    private Playwright playwright;
    private Browser browser;
    private Page page;
    private HomePage homePage;

    @BeforeEach
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

    @AfterEach
    public void tearDown() {
        if (browser != null) {
            browser.close();
        }

        if (playwright != null) {
            playwright.close();
        }
    }
}