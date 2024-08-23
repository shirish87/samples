package com.browserstack.tests;

import com.browserstack.helpers.DriverProvider;
import com.browserstack.pages.FormAuthenticationPage;
import com.browserstack.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FormAuthenticationTest {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
    public void setUp() {
        driver = DriverProvider.getDriver();
        homePage = new HomePage(driver);
    }

    @Test
    public void testFormAuthentication() {
        homePage.clickFormAuthentication();
        FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage(driver);

        formAuthenticationPage.enterUsername("tomsmith");
        formAuthenticationPage.enterPassword("SuperSecretPassword!");
        formAuthenticationPage.clickLoginButton();

        // Add assertions to verify the login attempt
        assertTrue(driver.getPageSource().contains("You logged into a secure area!"));
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
