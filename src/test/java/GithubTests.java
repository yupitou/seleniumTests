import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GithubTests {
    public static final String SUCCESS_AUTH_TITLE = "GitHub";
    public static final String FAIL_AUTH_TITLE = "Sign in to GitHub · GitHub";
    public static final String GITHUB_LOGIN_URL = "https://github.com/login";

    @Test
    public void successAuth() {
        // Забираем данные из переменных окружения переданных в виде: -Dlogin=log -Dpassword=pass
        String login = System.getProperty("login");
        String password = System.getProperty("password");

        open(GITHUB_LOGIN_URL);
        $(By.xpath("//input[@id='login_field']")).setValue(login);
        $(By.xpath("//input[@id='password']")).setValue(password);
        $(byXpath("//input[@value='Sign in']")).click();

        String pageTitle = title();

        assertTrue(
                pageTitle.equals(SUCCESS_AUTH_TITLE),
                "Title не содержит ожидаемый текст"
        );
    }

    @Test
    public void failAuth() {
        open(GITHUB_LOGIN_URL);
        $(By.xpath("//input[@id='login_field']")).setValue("11111");
        $(By.xpath("//input[@id='password']")).setValue("22222");
        $(byXpath("//input[@value='Sign in']")).click();

        String pageTitle = title();

        assertTrue(
                pageTitle.equals(FAIL_AUTH_TITLE),
                "Title не содержит ожидаемый текст"
        );
    }
}
