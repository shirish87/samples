package com.browserstack.pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.ElementHandle;

public class ShadowDomPage {

    private final Page page;

    public ShadowDomPage(Page page) {
        this.page = page;
    }

    public String getShadowDomText() {
        ElementHandle shadowHost = page.waitForSelector("my-paragraph");
        ElementHandle shadowRoot = shadowHost.evaluateHandle("element => element.shadowRoot").asElement();
        if (shadowRoot == null) {
            throw new RuntimeException("Shadow root is null");
        }

        ElementHandle shadowContent = shadowRoot.querySelector("slot");
        return shadowContent.textContent();
    }
}
