import com.codeborne.selenide.ElementsCollection;
import org.example.pages.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleSearchTest extends BaseTest {
    @ParameterizedTest
    @ValueSource(strings = {"qa", "aqa", "cars"})
    void googleSearchMoreFiveResults(String searchQuery) {
        googleHomePage.open();
        googleHomePage.setValueAndPressEnter(searchQuery);
        ElementsCollection results = googleSearchPage.getSearchResults();

        assertTrue(results.size()>5);
    }

}
