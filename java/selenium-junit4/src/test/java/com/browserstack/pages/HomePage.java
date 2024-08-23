package com.browserstack.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(linkText = "Form Authentication")
    private WebElement formAuthenticationLink;

    @FindBy(linkText = "Checkboxes")
    private WebElement checkboxesLink;

    @FindBy(linkText = "Dropdown")
    private WebElement dropdownLink;

    @FindBy(linkText = "Shadow DOM")
    private WebElement shadowDomLink;

    @FindBy(linkText = "Drag and Drop")
    private WebElement dragAndDropLink;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickFormAuthentication() {
        formAuthenticationLink.click();
    }

    public void clickCheckboxes() {
        checkboxesLink.click();
    }

    public void clickDropdown() {
        dropdownLink.click();
    }

    public void clickShadowDom() {
        shadowDomLink.click();
    }

    public void clickDragAndDropLink() {
        dragAndDropLink.click();
    }
}
