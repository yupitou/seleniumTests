package org.example.pages;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {
    protected GithubLoginPage githubLoginPage;
    protected GithubHomePage githubHomePage;
    protected GithubHeader githubHeader;
    protected GithubCICDPage githubCICDPage;
    protected GithubContactSalesPage githubContactSalesPage;
    protected GithubCookies githubCookies;
    protected GoogleHomePage googleHomePage;
    protected GoogleSearchPage googleSearchPage;

    @BeforeEach
    void setUp() {
        githubLoginPage = new GithubLoginPage();
        githubHomePage = new GithubHomePage();
        githubHeader = new GithubHeader();
        githubCICDPage = new GithubCICDPage();
        githubContactSalesPage = new GithubContactSalesPage();
        githubCookies = new GithubCookies();
        googleHomePage = new GoogleHomePage();
        googleSearchPage = new GoogleSearchPage();
    }

}
