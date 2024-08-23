package com.browserstack.pages;

import com.microsoft.playwright.Page;

public class FormAuthenticationPage extends BasePage {

    public FormAuthenticationPage(Page page) {
        super(page);
    }

    public void enterUsername(String username) {
        page.fill("input[name='username']", username);
    }

    public void enterPassword(String password) {
        page.fill("input[name='password']", password);
    }

    public void clickLoginButton() {
        page.click("button[type='submit']");
    }

    public boolean isSecureAreaDisplayed() {
        return page.url().endsWith("/secure");
    }

    public boolean isErrorMessageDisplayed() {
        return page.isVisible("#flash.error");
    }
}
