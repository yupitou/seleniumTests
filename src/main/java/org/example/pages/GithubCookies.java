package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class GithubCookies {
    private SelenideElement acceptCookiesButton = $x("//button[contains(text(), 'Accept') and contains(@class, '_1XuCi2WhiqeWRUVp3pnFG3 erL690_8JwUW-R4bJRcfl')]");

    public void acceptCookies() {
        if (acceptCookiesButton.isDisplayed()) {
            acceptCookiesButton.click();
        }
    }
}

