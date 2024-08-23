package com.browserstack.pages;

import com.microsoft.playwright.Page;

public class CheckboxesPage {

    private final Page page;

    public CheckboxesPage(Page page) {
        this.page = page;
    }

    public void checkCheckbox1() {
        if (!isCheckbox1Checked()) {
            page.click("//form[@id='checkboxes']/input[1]");
        }
    }

    public void uncheckCheckbox1() {
        if (isCheckbox1Checked()) {
            page.click("//form[@id='checkboxes']/input[1]");
        }
    }

    public void checkCheckbox2() {
        if (!isCheckbox2Checked()) {
            page.click("//form[@id='checkboxes']/input[2]");
        }
    }

    public void uncheckCheckbox2() {
        if (isCheckbox2Checked()) {
            page.click("//form[@id='checkboxes']/input[2]");
        }
    }

    public boolean isCheckbox1Checked() {
        return page.isChecked("//form[@id='checkboxes']/input[1]");
    }

    public boolean isCheckbox2Checked() {
        return page.isChecked("//form[@id='checkboxes']/input[2]");
    }
}
