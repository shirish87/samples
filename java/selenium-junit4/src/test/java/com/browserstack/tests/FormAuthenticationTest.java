package com.browserstack.tests;

import com.browserstack.helpers.DriverProvider;
import com.browserstack.pages.FormAuthenticationPage;
import com.browserstack.pages.HomePage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertTrue;

public class FormAuthenticationTest {

    private WebDriver driver;
    private HomePage homePage;

    @Before
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

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
