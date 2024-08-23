package com.browserstack.tests;

import com.browserstack.helpers.DriverProvider;
import com.browserstack.pages.DragAndDropPage;
import com.browserstack.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DragAndDropPageTest {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeMethod
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
        assertEquals(result, "A");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
