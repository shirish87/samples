package com.browserstack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckboxesPage extends BasePage {

    @FindBy(xpath = "//form[@id='checkboxes']/input[1]")
    private WebElement checkbox1;

    @FindBy(xpath = "//form[@id='checkboxes']/input[2]")
    private WebElement checkbox2;

    public CheckboxesPage(WebDriver driver) {
        super(driver);
    }

    public void checkCheckbox1() {
        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }
    }

    public void uncheckCheckbox1() {
        if (checkbox1.isSelected()) {
            checkbox1.click();
        }
    }

    public void checkCheckbox2() {
        if (!checkbox2.isSelected()) {
            checkbox2.click();
        }
    }

    public void uncheckCheckbox2() {
        if (checkbox2.isSelected()) {
            checkbox2.click();
        }
    }

    public boolean isCheckbox1Checked() {
        return checkbox1.isSelected();
    }

    public boolean isCheckbox2Checked() {
        return checkbox2.isSelected();
    }
}
