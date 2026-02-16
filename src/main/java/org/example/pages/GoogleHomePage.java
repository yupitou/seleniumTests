package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class GoogleHomePage extends BasePage {
    public static final String GOOGLE_URL = "https://www.google.ru/";
    public SelenideElement googleSearchInput = $x("//textarea[@name='q']");

    public GoogleHomePage() {
        super(GOOGLE_URL);
    }
    public void setValueAndPressEnter(String searchQuery) {
        googleSearchInput.setValue(searchQuery).pressEnter();
    }
}
