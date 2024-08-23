package com.browserstack.tests;

import com.browserstack.helpers.DriverProvider;
import com.browserstack.pages.DragAndDropPage;
import com.browserstack.pages.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class DragAndDropPageTest {
    private WebDriver driver;
    private HomePage homePage;

    @Before
    public void setUp() {
        driver = DriverProvider.getDriver();
        homePage = new HomePage(driver);
    }

    @Test
    public void testDragAndDrop() {
        homePage.clickDragAndDropLink();
        DragAndDropPage dragAndDropPage = new DragAndDropPage(driver);

        dragAndDropPage.performDragAndDrop();
        String result = dragAndDropPage.getResult();
        assertEquals("A", result);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
