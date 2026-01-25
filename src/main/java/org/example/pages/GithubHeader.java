package org.example.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.*;

public class GithubHeader {
    public static final String SOLUTION = "Solution";
    public SelenideElement cicdButton = $x("//*[contains(., 'CI/CD') and contains(@class, 'NavLink-module__title--xw3ok')]");

    public void navigateToCICD() {
        hoverOnMenuItemByName(SOLUTION);
        cicdButton.click();
    }
    public void hoverOnMenuItemByName(String menuItemsName) {
        SelenideElement menuItem = $x("//button[contains(normalize-space(), '" + menuItemsName + "')]");
        menuItem.hover();
    }
    public ElementsCollection getGroupItemsFromMenuByName(String groupItemsName) {
        return $$x("//span[contains(text(), '" + groupItemsName + "')]/following-sibling::ul/li//span");
    }
}
