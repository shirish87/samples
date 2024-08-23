package com.browserstack.tests;

import com.browserstack.helpers.DriverProvider;
import com.browserstack.pages.DropdownPage;
import com.browserstack.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DropdownTest {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeEach
    public void setUp() {
        driver = DriverProvider.getDriver();
        homePage = new HomePage(driver);
    }

    @Test
    public void testDropdown() {
        homePage.clickDropdown();
        DropdownPage dropdownPage = new DropdownPage(driver);

        // Select option by value
        dropdownPage.selectOptionByValue("1");
        assertEquals(dropdownPage.getSelectedOption(), "Option 1");

        // Select option by visible text
        dropdownPage.selectOptionByVisibleText("Option 2");
        assertEquals(dropdownPage.getSelectedOption(), "Option 2");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}