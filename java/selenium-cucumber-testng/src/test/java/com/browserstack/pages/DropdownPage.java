package com.browserstack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropdownPage extends BasePage {

    @FindBy(id = "dropdown")
    private WebElement dropdown;

    public DropdownPage(WebDriver driver) {
        super(driver);
    }

    public void selectOptionByValue(String value) {
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    public void selectOptionByVisibleText(String text) {
        Select select = new Select(dropdown);
        select.selectByVisibleText(text);
    }

    public String getSelectedOption() {
        Select select = new Select(dropdown);
        return select.getFirstSelectedOption().getText();
    }
}
