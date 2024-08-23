package com.browserstack.pages;

import com.microsoft.playwright.Page;

public class HomePage extends BasePage {

    public HomePage(Page page) {
        super(page);

        if (page.url() == null || !page.url().contains("the-internet.herokuapp.com")) {
            navigateTo("https://the-internet.herokuapp.com/");
        }
    }

    public void clickFormAuthentication() {
        page.click("text=Form Authentication");
    }

    public void clickCheckboxes() {
        page.click("text=Checkboxes");
    }

    public void clickDropdown() {
        page.click("text=Dropdown");
    }

    public void clickShadowDom() {
        page.click("text=Shadow DOM");
    }

    public void clickDragAndDropLink() {
        page.click("text=Drag and Drop");
    }
}
