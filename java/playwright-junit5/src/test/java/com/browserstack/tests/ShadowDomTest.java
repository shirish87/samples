package com.browserstack.tests;

import com.browserstack.pages.HomePage;
import com.browserstack.pages.ShadowDomPage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShadowDomTest {
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
    public void testShadowDom() {
        homePage.clickShadowDom();
        ShadowDomPage shadowDomPage = new ShadowDomPage(page);

        // Verify text inside Shadow DOM
        String shadowDomText = shadowDomPage.getShadowDomText();
        assertEquals(shadowDomText, "My default text");
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
