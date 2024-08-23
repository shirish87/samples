package com.browserstack.tests;

import com.browserstack.pages.DropdownPage;
import com.browserstack.pages.HomePage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DropdownTest {
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
    public void testDropdown() {
        homePage.clickDropdown();
        DropdownPage dropdownPage = new DropdownPage(page);

        // Select option by value
        dropdownPage.selectOptionByValue("1");
        assertEquals(dropdownPage.getSelectedOption(), "Option 1");

        // Select option by visible text
        dropdownPage.selectOptionByVisibleText("Option 2");
        assertEquals(dropdownPage.getSelectedOption(), "Option 2");
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
