package com.browserstack.tests;

import com.browserstack.helpers.DriverProvider;
import com.browserstack.pages.HomePage;
import com.browserstack.pages.ShadowDomPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static org.junit.Assert.assertEquals;

public class ShadowDomTest {

    private WebDriver driver;
    private HomePage homePage;

    @Before
    public void setUp() {
        driver = DriverProvider.getDriver();
        homePage = new HomePage(driver);
    }

    @Test
    public void testShadowDom() {
        homePage.clickShadowDom();
        ShadowDomPage shadowDomPage = new ShadowDomPage(driver);

        // Verify text inside Shadow DOM
        String shadowDomText = shadowDomPage.getShadowDomText();
        assertEquals(shadowDomText, "My default text");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
