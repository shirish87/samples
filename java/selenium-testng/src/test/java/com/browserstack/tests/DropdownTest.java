package com.browserstack.tests;

import com.browserstack.helpers.DriverProvider;
import com.browserstack.pages.DropdownPage;
import com.browserstack.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class DropdownTest {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
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

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
