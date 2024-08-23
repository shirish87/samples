package com.browserstack.tests;

import com.browserstack.helpers.DriverProvider;
import com.browserstack.pages.HomePage;
import com.browserstack.pages.ShadowDomPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ShadowDomTest {

    private WebDriver driver;
    private HomePage homePage;

    @BeforeClass
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

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
