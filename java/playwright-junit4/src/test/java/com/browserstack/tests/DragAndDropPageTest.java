package com.browserstack.tests;

import com.browserstack.pages.DragAndDropPage;
import com.browserstack.pages.HomePage;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DragAndDropPageTest {
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
    public void testDragAndDrop() {
        homePage.clickDragAndDropLink();
        DragAndDropPage dragAndDropPage = new DragAndDropPage(page);

        dragAndDropPage.performDragAndDrop();
        String result = dragAndDropPage.getResult();
        assertEquals(result, "A");
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
