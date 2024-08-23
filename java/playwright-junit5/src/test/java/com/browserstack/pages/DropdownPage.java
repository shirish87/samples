package com.browserstack.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.SelectOption;

public class DropdownPage {

    private final Page page;

    public DropdownPage(Page page) {
        this.page = page;
    }

    public void selectOptionByValue(String value) {
        page.selectOption("#dropdown", value);
    }

    public void selectOptionByVisibleText(String text) {
        page.selectOption("#dropdown", new SelectOption().setLabel(text));
    }

    public String getSelectedOption() {
        return page.textContent("#dropdown option:checked");
    }
}
