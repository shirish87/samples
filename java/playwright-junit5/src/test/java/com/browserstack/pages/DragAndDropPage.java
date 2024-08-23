package com.browserstack.pages;

import com.microsoft.playwright.Page;

public class DragAndDropPage {

    private final Page page;

    public DragAndDropPage(Page page) {
        this.page = page;
    }

    public void performDragAndDrop() {
        page.dragAndDrop("#column-a", "#column-b");
    }

    public String getResult() {
        return page.textContent("#column-b");
    }
}
