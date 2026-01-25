package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import static com.codeborne.selenide.Selenide.$$x;

public class GoogleSearchPage {
    public static final String GOOGLE_SEARCH_RESULT = "//div[@id='search']//div[contains(@class, 'g')]";

    public ElementsCollection getSearchResults() {
        return $$x(GOOGLE_SEARCH_RESULT);
    }
}
