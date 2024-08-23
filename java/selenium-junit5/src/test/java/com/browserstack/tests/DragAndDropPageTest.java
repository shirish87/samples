package com.browserstack.tests;

import com.browserstack.helpers.DriverProvider;
import com.browserstack.pages.DragAndDropPage;
import com.browserstack.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DragAndDropPageTest {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeEach
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

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
