package com.browserstack.tests;

import com.browserstack.pages.CheckboxesPage;
import com.browserstack.pages.HomePage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CheckboxesTest {

    private Browser browser;
    private Page page;
    private HomePage homePage;

    @Before
    public void setUp() {
        Playwright playwright = Playwright.create();
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

    @After
    public void tearDown() {
        if (browser != null) {
            browser.close();
        }
    }
}