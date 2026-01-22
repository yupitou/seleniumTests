import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class GoogleSearchTest {
    public static final String addExperienceButtonXpath = "//*[@data-qa=\\\"resume-list-card-experience\\\"]//*[text()=\\\"Добавить\\\"]\"";
    private WebDriver driver;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void testGoogleSearch() throws InterruptedException {
        driver.get("https://ya.ru/");
        String source = driver.getPageSource();
        System.out.println(source);
        WebElement searchBox = driver.findElement(By.name("text"));
        WebElement searchBox2 = driver.findElement(By.xpath(addExperienceButtonXpath));

        searchBox2.click();
        searchBox.sendKeys("погода в москве");
        Thread.sleep(2000);
        searchBox.submit();
        Thread.sleep(500);
        // простая проверка — в заголовке есть текст запроса
        assertTrue(driver.getTitle().contains("погода в москве"));
    }

    @Test
    void testDubrovskySearch() throws InterruptedException {
        driver.get("https://rutube.ru/");
        WebElement searchBox = driver.findElement(By.xpath("//*[@class='wdp-search-line-module__input']"));
        //searchBox.click();
        searchBox.sendKeys("ОГРАБЬ МЕНЯ, ЕСЛИ ПОЙМАЕШЬ!");
        WebElement searchButton = driver.findElement(By.xpath("//button[@type='submit']"));
        searchButton.click();
        Thread.sleep(1500);
        WebElement closePopupButton = driver.findElement(By.xpath("//div[contains(@class, 'popup')]/button"));
        if (closePopupButton.isDisplayed()) {
            Thread.sleep(1000);
            closePopupButton.click();

        }
        List<WebElement> searchResults = driver.findElements(By.xpath("//section[contains(@class, 'grid')]/div"));

        Thread.sleep(2000);
        searchResults.get(0).click();
        Thread.sleep(5000);

    }

    @AfterEach
    void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
//button[@class='NavDropdown-module__button--Hq9UR js-details-target']