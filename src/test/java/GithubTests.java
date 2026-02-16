import com.codeborne.selenide.ElementsCollection;
import org.example.pages.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.CollectionCondition.itemWithText;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GithubTests {

    public static final String SUCCESS_AUTH_TITLE = "GitHub";
    public static final String FAIL_AUTH_TITLE = "Sign in to GitHub · GitHub";
    public static final String INVALID_LOGIN = "1111";
    public static final String INVALID_PASSWORD = "4444";

    public static final String FIRST_NAME = "Anton";
    public static final String LAST_NAME = "Nazarov";

    public static final String RESOURCES = "Resources";
    public static final String EXPLORE_BY_TOPIC = "EXPLORE BY TOPIC";

    GithubLoginPage githubLoginPage = new GithubLoginPage();
    GithubHomePage githubHomePage = new GithubHomePage();
    GithubHeader githubHeader = new GithubHeader();
    GithubCICDPage githubCICDPage = new GithubCICDPage();
    GithubContactSalesPage githubContactSalesPage = new GithubContactSalesPage();
    GithubCookies githubCookies = new GithubCookies();

    @Test
    public void successAuth() {
        // Забираем данные из переменных окружения, переданных в виде: login=log; password=pass
        String login = System.getenv("login");
        String password = System.getenv("password");

        githubLoginPage.open();
        githubLoginPage.login(login, password);
        String pageTitle = title();

        assertEquals(SUCCESS_AUTH_TITLE, pageTitle);
    }

    @Test
    public void failAuth() {
        githubLoginPage.open();
        githubLoginPage.login(INVALID_LOGIN, INVALID_PASSWORD);
        String pageTitle = title();

        assertEquals(FAIL_AUTH_TITLE, pageTitle);
    }

    @Test
    public void dataInContactSales() {
        githubHomePage.open();
        githubHeader.navigateToCICD();
        githubCookies.acceptCookies();
        githubCICDPage.navigateToContactSales();
        githubContactSalesPage.setFirstNameField(FIRST_NAME);
        githubContactSalesPage.setLastNameField(LAST_NAME);

        String actualFirstNameValue = githubContactSalesPage.getValueFirstNameField();
        String actualLastNameValue = githubContactSalesPage.getValueLastNameField();

        assertEquals(FIRST_NAME, actualFirstNameValue);
        assertEquals(LAST_NAME, actualLastNameValue);
    }

    @Test
    void topicsShouldContainExpectedValues() {
        githubHomePage.open();
        githubHeader.hoverOnMenuItemByName(RESOURCES);
        ElementsCollection topics = githubHeader.getGroupItemsFromMenuByName(EXPLORE_BY_TOPIC);

        topics.shouldHave(itemWithText("AI"));
        topics.shouldHave(itemWithText("DevOps"));
        topics.shouldHave(itemWithText("Security"));
        topics.shouldHave(itemWithText("Software Development"));
        topics.shouldHave(itemWithText("View all topics"));
    }
}




