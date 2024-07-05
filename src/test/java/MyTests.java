import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class MyTests {

    WebDriver driver;

    @BeforeMethod
    public void initDriver() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://planetakino.ua/");
    }

    @AfterMethod
    public void quitDriver() {
        driver.quit();
    }


    //    Проверка главной страницы
    @Test
    public void testHomePageTitle() {
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("Планета Кіно"));
    }

    //    Проверка наличия логотипа
    @Test
    public void testLogoPresence() {
        WebElement logo = driver.findElement(By.cssSelector("#logo"));
        Assert.assertTrue(logo.isDisplayed());
    }

    //    Проверка ссылки на страницу "Контакты"
    @Test
    public void testContactsLink() {
        WebElement contactsLink = driver.findElement(By.linkText("Контакти"));
        Assert.assertTrue(contactsLink.isDisplayed());
        contactsLink.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("contacts"));
    }

    //    Проверка доступности страницы "Фільми"
    @Test
    public void testRepertoirePage() {
        WebElement repertoireLink = driver.findElement(By.linkText("Фільми"));
        repertoireLink.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("movies"));
    }


    //    Проверка формы поиска фильмов
    @Test
    public void testSearchForm() {
        WebElement searchForm = driver.findElement(By.cssSelector(".move-to-active"));
        searchForm.click();
        Assert.assertTrue(searchForm.isDisplayed());
    }

    //    Проверка результатов поиска
    @Test(groups = "positive")
    public void testSearchFunctionality() {
        WebElement searchForm = driver.findElement(By.cssSelector(".move-to-active"));
        searchForm.click();
        WebElement searchField = driver.findElement(By.cssSelector(".search-input"));
        searchField.sendKeys("Місяць");
        searchField.click();
        WebElement searchResult = driver.findElement(By.cssSelector(".list-search-movie"));
        Assert.assertTrue(searchResult.isDisplayed());
    }

    //    !!! Проверка результатов поиска neg !!!
    @Test(groups = "negative")
    public void testSearchFunctionalityNeg() {
        WebElement searchForm = driver.findElement(By.cssSelector(".move-to-active"));
        searchForm.click();
        WebElement searchField = driver.findElement(By.cssSelector(".search-input"));
        searchField.sendKeys("123456");
        searchField.click();

        // не могу понять почему не находит этот элемент хотя в инстурментах разработчика по этому xpath находит
        WebElement noResultsMessage = driver.findElement(By.xpath("//p[text()='Фільм не знайдено']"));
        Assert.assertTrue(noResultsMessage.isDisplayed());
    }

    //    Проверка наличия формы регистрации
    @Test
    public void testUserRegistration() {
        WebElement registerLink = driver.findElement(By.linkText("Реєстрація"));
        registerLink.click();
        WebElement boxElement = driver.findElement(By.xpath("//div[@class='box']"));
        Assert.assertTrue(boxElement.isDisplayed());
    }

    //    Проверка логина пользователя (позитивный сценарий)
    @Test(groups = "positive")
    public void testUserLogin() {
        WebElement loginLink = driver.findElement(By.linkText("Вхід"));
        loginLink.click();
        WebElement emailField = driver.findElement(By.cssSelector("#loginform-login"));
        WebElement passwordField = driver.findElement(By.cssSelector("#loginform-password"));
        WebElement loginButton = driver.findElement(By.name("login-button"));
        emailField.sendKeys("elizabeth.mrs.jack@gmail.com");
        passwordField.sendKeys("20061991");
        loginButton.click();
        WebElement userProfile = driver.findElement(By.xpath("//a[@href='https://cabinet.planetakino.ua']"));
        Assert.assertTrue(userProfile.isDisplayed());
    }

    //    Проверка логина пользователя (негативный сценарий пустые поля)
    @Test(groups = "negative")
    public void testUserLoginNeg() {
        WebElement loginLink = driver.findElement(By.linkText("Вхід"));
        loginLink.click();
        WebElement emailField = driver.findElement(By.cssSelector("#loginform-login"));
        WebElement passwordField = driver.findElement(By.cssSelector("#loginform-password"));
        WebElement loginButton = driver.findElement(By.name("login-button"));
        emailField.sendKeys("");
        passwordField.sendKeys("");
        loginButton.click();
        WebElement userProfile = driver.findElement(By.xpath("//p[text()='Необхідно заповнити це поле']"));
        Assert.assertTrue(userProfile.isDisplayed());
    }



}
