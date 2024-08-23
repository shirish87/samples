package com.browserstack.tests;

import com.browserstack.pages.CheckboxesPage;
import com.browserstack.pages.HomePage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckboxesTest {
    private Playwright playwright;
    private Browser browser;
    private Page page;
    private HomePage homePage;

    @BeforeTest
    public void setUp() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true));
        page = browser.newPage();
        homePage = new HomePage(page);
    }

    @Test
    public void testCheckboxes() {
        homePage.clickCheckboxes();
        CheckboxesPage checkboxesPage = new CheckboxesPage(page);

        // Check the first checkbox
        checkboxesPage.checkCheckbox1();
        assertTrue(checkboxesPage.isCheckbox1Checked());

        // Uncheck the first checkbox
        checkboxesPage.uncheckCheckbox1();
        assertFalse(checkboxesPage.isCheckbox1Checked());

        // Check the second checkbox
        checkboxesPage.checkCheckbox2();
        assertTrue(checkboxesPage.isCheckbox2Checked());

        // Uncheck the second checkbox
        checkboxesPage.uncheckCheckbox2();
        assertFalse(checkboxesPage.isCheckbox2Checked());
    }

    @AfterTest
    public void tearDown() {
        if (browser != null) {
            browser.close();
        }

        if (playwright != null) {
            playwright.close();
        }
    }
}

