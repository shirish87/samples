package com.browserstack.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShadowDomPage extends BasePage {

    public ShadowDomPage(WebDriver driver) {
        super(driver);
    }

    public String getShadowDomText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement shadowHost = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("my-paragraph")));
        SearchContext shadowRoot = shadowHost.getShadowRoot();
        if (shadowRoot == null) {
            throw new RuntimeException("Shadow root is null");
        }

        WebElement shadowContent = shadowRoot.findElement(By.cssSelector("slot"));
        return shadowContent.getText();
    }
}
