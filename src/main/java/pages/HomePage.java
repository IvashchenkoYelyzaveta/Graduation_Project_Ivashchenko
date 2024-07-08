package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;

public class HomePage {

    WebDriver driver;

    // Конструктор класса HomePage, принимает WebDriver
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Получение заголовка главной страницы
    public String getHomePageTitle() {
        return driver.getTitle();
    }

    // Проверка, отображается ли логотип
    public boolean isLogoDisplayed() {
        WebElement logo = driver.findElement(By.cssSelector("#logo"));
        return logo.isDisplayed();
    }

    // Клик по ссылке "Контакти"
    public void clickContactsLink() {
        WebElement contactsLink = driver.findElement(By.linkText("Контакти"));
        contactsLink.click();
    }

    // Клик по ссылке "Фільми"
    public void clickMoviesLink() {
        WebElement movies = driver.findElement(By.linkText("Фільми"));
        movies.click();
    }

    // Клик по форме поиска
    public void clickSearchForm() {
        WebElement searchForm = driver.findElement(By.cssSelector(".move-to-active"));
        searchForm.click();
    }

    public void searchMovie(String movieName) throws InterruptedException {
        WebElement searchField = driver.findElement(By.cssSelector(".search-input"));
        // Set the value using JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + movieName + "';", searchField);
        Thread.sleep(5000);
        // Optionally trigger the input event if needed
        js.executeScript("arguments[0].dispatchEvent(new Event('input'));", searchField);
    }

    // Проверка, отображаются ли результаты поиска
    public boolean isSearchResultDisplayed() {
        WebElement searchResult = driver.findElement(By.cssSelector(".list-search-movie"));
        return searchResult.isDisplayed();
    }

}
