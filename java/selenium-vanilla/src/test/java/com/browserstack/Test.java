package com.browserstack;

import com.browserstack.helpers.DriverProvider;
import com.browserstack.pages.FormAuthenticationPage;
import com.browserstack.pages.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

    public static void main(String[] args) {
        WebDriver driver = null;

        try {
            driver = DriverProvider.getDriver();
            HomePage homePage = new HomePage(driver);
            homePage.clickFormAuthentication();
            FormAuthenticationPage formAuthenticationPage = new FormAuthenticationPage(driver);

            formAuthenticationPage.enterUsername("tomsmith");
            formAuthenticationPage.enterPassword("SuperSecretPassword!");
            formAuthenticationPage.clickLoginButton();

            // Add assertions to verify the login attempt
            if (!(driver.getPageSource().contains("You logged into a secure area!"))) {
                throw new AssertionError("login failed");
            }
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}
