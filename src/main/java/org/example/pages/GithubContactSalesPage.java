package org.example.pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;

public class GithubContactSalesPage {
    public SelenideElement firstNameField = $x("//*[@name = 'first_name']");
    public SelenideElement lastNameField = $x("//*[@name = 'last_name']");

    public void setFirstNameField(String firstName) {
        firstNameField.setValue(firstName);
    }
    public void setLastNameField(String lastName) {
        lastNameField.setValue(lastName);
    }
    public String getValueFirstNameField() {
        return firstNameField.getValue();
    }
    public String getValueLastNameField() {
        return lastNameField.getValue();
    }
}
