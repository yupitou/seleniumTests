package org.example.pages;

import static com.codeborne.selenide.Selenide.*;
import com.codeborne.selenide.SelenideElement;

public class GithubLoginPage extends BasePage {
    public static final String GITHUB_LOGIN_URL = "https://github.com/login";

    public SelenideElement loginField = $x("//input[@id='login_field']");
    public SelenideElement passwordField = $x("//input[@id='password']");
    public SelenideElement signUpButton = $x("//input[@value='Sign in']");

    public GithubLoginPage() {
        super(GITHUB_LOGIN_URL);
    }

    public void login(String login, String password) {
        loginField.setValue(login);
        passwordField.setValue(password);
        signUpButton.click();
    }
}
