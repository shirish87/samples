package com.browserstack.tests;

import com.browserstack.helpers.DriverProvider;
import com.browserstack.pages.CheckboxesPage;
import com.browserstack.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckboxesTest {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeEach
    public void setUp() {
        driver = DriverProvider.getDriver();
        homePage = new HomePage(driver);
    }

    @Test
    public void testCheckboxes() {
        homePage.clickCheckboxes();
        CheckboxesPage checkboxesPage = new CheckboxesPage(driver);

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

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}