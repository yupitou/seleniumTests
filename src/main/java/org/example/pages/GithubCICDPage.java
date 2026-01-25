package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class GithubCICDPage {
    public SelenideElement contactCalesButton = $x("//a//span[contains(text(), 'Contact sales')]");

    public void navigateToContactSales() {
        contactCalesButton.click();
    }
}
