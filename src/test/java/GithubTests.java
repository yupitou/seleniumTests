import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GithubTests {
    public static final String SUCCESS_AUTH_TITLE = "GitHub";
    public static final String FAIL_AUTH_TITLE = "Sign in to GitHub · GitHub";
    public static final String GITHUB_LOGIN_URL = "https://github.com/login";
    public static final String GITHUB_LOGIN = "//input[@id='login_field']";
    public static final String GITHUB_PASSWORD = "//input[@id='password']";
    public static final String GITHUB_SIGN_UP_BUTTON = "//input[@value='Sign in']";
    public static final String INVALID_LOGIN = "1111";
    public static final String INVALID_PASSWORD = "4444";

    public static final String GITHUB_URL = "https://github.com/";
    public static final String SOLUTION_BUTTON = "//button[contains(text(), 'Solution')]";
    public static final String CI_CD_BUTTON = "//*[contains(., 'CI/CD') and contains(@class, 'NavLink-module__title--xw3ok')]";
    public static final String CONTACT_SALES_BUTTON = "//div[@data-testid='Grid-:R6pb:']//span[contains(text(), 'Contact sales')]";
    public static final String ACCEPT_COOKIE_BUTTON = "//button[contains(text(), 'Accept') and contains(@class, '_1XuCi2WhiqeWRUVp3pnFG3 erL690_8JwUW-R4bJRcfl')]";
    public static final String FIRST_NAME_INPUT = "//*[@name = 'first_name']";
    public static final String LAST_NAME_INPUT = "//*[@name = 'last_name']";
    public static final String FIRST_NAME = "Anton";
    public static final String LAST_NAME = "Nazarov";

    public static final String RESOURSES = "//button[contains(text(), 'Resources')]";
    public static final String TOPICS = "//span[contains(text(), 'EXPLORE BY TOPIC')]/following-sibling::ul/li//span";

    public static final String GOOGLE_URL = "https://www.google.ru/";
    public static final String GOOGLE_SEARCH_INPUT = "//textarea[@name='q']";
    public static final String GOOGLE_SEARCH_RESULT = "//div[@id='search']//div[contains(@class, 'g')]";


    @Test
    public void successAuth() {
        // Забираем данные из переменных окружения переданных в виде: -Dlogin=log -Dpassword=pass
        String login = System.getProperty("login");
        String password = System.getProperty("password");

        open(GITHUB_LOGIN_URL);
        $(By.xpath(GITHUB_LOGIN)).setValue(login);
        $(By.xpath(GITHUB_PASSWORD)).setValue(password);
        $(byXpath(GITHUB_SIGN_UP_BUTTON)).click();

        String pageTitle = title();

        assertEquals(SUCCESS_AUTH_TITLE, pageTitle, "Title не содержит ожидаемый текст");
    }

    @Test
    public void failAuth() {
        open(GITHUB_LOGIN_URL);
        $(By.xpath(GITHUB_LOGIN)).setValue(INVALID_LOGIN);
        $(By.xpath(GITHUB_PASSWORD)).setValue(INVALID_PASSWORD);
        $(byXpath(GITHUB_SIGN_UP_BUTTON)).click();

        String pageTitle = title();

        assertEquals(FAIL_AUTH_TITLE, pageTitle, "Title не содержит ожидаемый текст");
    }

    @Test
    public void dataInContactSales() {
        open(GITHUB_URL);
        $(By.xpath(SOLUTION_BUTTON)).hover();
        $(byXpath(CI_CD_BUTTON)).click();
        if ($(byXpath(ACCEPT_COOKIE_BUTTON)).isDisplayed()) {
            $(byXpath(ACCEPT_COOKIE_BUTTON)).click();
        }
        $(byXpath(CONTACT_SALES_BUTTON)).click();
        $(By.xpath(FIRST_NAME_INPUT)).setValue(FIRST_NAME);
        $(By.xpath(LAST_NAME_INPUT)).setValue(LAST_NAME);

        String actualFirstNameValue = $(By.xpath(FIRST_NAME_INPUT)).getValue();
        String actualLastNameValue = $(By.xpath(LAST_NAME_INPUT)).getValue();

        assertEquals(FIRST_NAME, actualFirstNameValue);
        assertEquals(LAST_NAME, actualLastNameValue);
    }

    @Test
    void topicsShouldContainExpectedValues() {
        open(GITHUB_URL);
        $(By.xpath(RESOURSES)).hover();
        ElementsCollection topics = $$x(TOPICS);

        topics.shouldHave(itemWithText("AI"));
        topics.shouldHave(itemWithText("DevOps"));
        topics.shouldHave(itemWithText("Security"));
        topics.shouldHave(itemWithText("Software Development"));
        topics.shouldHave(itemWithText("View all topics"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"qa", "aqa", "cars"})
    void googleSearchMoreFiveResults(String searchQuery) {
        open(GOOGLE_URL);
        $(By.xpath(GOOGLE_SEARCH_INPUT)).setValue(searchQuery).pressEnter();
        ElementsCollection results = $$x(GOOGLE_SEARCH_RESULT);

        assertTrue(results.size()>5);
    }
}




