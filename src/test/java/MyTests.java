import io.qameta.allure.Description;
import io.qameta.allure.Story;
import io.qameta.allure.testng.AllureTestNg;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import java.time.Duration;


@Listeners({AllureTestNg.class})
public class MyTests {

    WebDriver driver;
    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void initDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.get("https://planetakino.ua/");
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
    }

    @AfterMethod
    public void quitDriver() {

        driver.quit();
    }

    //    Проверка главной страницы
    @Test
    @Description("Check home page title")
    @Story("Home Page")
    public void testHomePageTitle() {
        String title = homePage.getHomePageTitle();
        Assert.assertTrue(title.contains("Планета Кіно"));
    }

    //    Проверка наличия логотипа
    @Test
    @Description("Check logo")
    @Story("Home Page")
    public void testLogoPresence() {
        Assert.assertTrue(homePage.isLogoDisplayed());
    }

    @Test
    @Description("Check the functionality of the 'Contacts' page link")
    @Story("Home Page")
    public void testContactsLink() {
        homePage.clickContactsLink();
        Assert.assertTrue(driver.getCurrentUrl().contains("contacts"));
    }

    @Test
    @Description("Check the functionality of the 'Movies' page link")
    @Story("Home Page")
    public void testMoviesPage() {
        homePage.clickMoviesLink();
        Assert.assertTrue(driver.getCurrentUrl().contains("movies"));
    }

    @Test
    @Description("Check for the presence and display of the movie search form")
    @Story("Search")
    public void testSearchForm() {
        homePage.clickSearchForm();
        // Явное ожидание для появления формы поиска
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean isDisplayed = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".search-input"))).isDisplayed();
        Assert.assertTrue(isDisplayed, "Search input field should be displayed");
    }

    @Test(groups = "positive")
    @Description("Check the correctness of the search function with a valid data")
    @Story("Search")
    public void testSearchFunctionality() throws InterruptedException {
        homePage.clickSearchForm();
        homePage.searchMovie("Місяць");
        WebElement result = driver.findElement(By.cssSelector(".list-search-movie")).findElement(By.tagName("a"));
        Assert.assertTrue(result.isDisplayed());
    }

    @Test(groups = "negative")
    @Description("Check the correctness of the search function with a invalid data")
    @Story("Search")
    public void testSearchFunctionalityNeg() throws InterruptedException {
        homePage.clickSearchForm();
        homePage.searchMovie("123456");
        WebElement result = driver.findElement(By.cssSelector(".list-search-movie")).findElement(By.tagName("p"));
        Assert.assertTrue(result.isDisplayed());
    }

    @Test
    @Description("Check for the presence of the registration/login form")
    @Story("User Login")
    public void testUserRegistration() {
        loginPage.clickRegisterLink();
        Assert.assertTrue(loginPage.isRegistrationFormDisplayed());
    }

    @Test(groups = "positive")
    @Description("Check successful user login with valid data")
    @Story("User Login")
    public void testUserLogin() {
        loginPage.clickLoginLink();
        loginPage.enterEmail("elizabeth.mrs.jack@gmail.com");
        loginPage.enterPassword("20061991");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isUserProfileDisplayed());
    }

    @Test(groups = "negative")
    @Description("Check successful user login with empty fields")
    @Story("User Login")
    public void testUserLoginNeg() {
        loginPage.clickLoginLink();
        loginPage.enterEmail("");
        loginPage.enterPassword("");
        loginPage.clickLoginButton();
        Assert.assertTrue(loginPage.isEmptyFieldErrorDisplayed());
    }

}
