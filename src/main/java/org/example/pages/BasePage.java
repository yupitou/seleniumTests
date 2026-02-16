package org.example.pages;

import com.codeborne.selenide.Selenide;

public abstract class BasePage {
    protected String pageUrl;

    public BasePage(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public void open() {
        String url = pageUrl.trim();
        Selenide.open(url);
    }
}
