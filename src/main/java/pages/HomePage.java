package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.NoSuchElementException;

public class HomePage {
//
//    WebDriver driver;
//
//    public HomePage(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    public String getHomePageTitle() {
//        return driver.getTitle();
//    }
//
//    public boolean isLogoDisplayed() {
//        WebElement logo = driver.findElement(By.cssSelector("#logo"));
//        return logo.isDisplayed();
//    }
//
//    public void clickContactsLink() {
//        WebElement contactsLink = driver.findElement(By.xpath("//a[@href='/contacts/']"));
//        contactsLink.click();
//    }
//
//    public void clickMoviesLink() {
//        WebElement movies = driver.findElement(By.xpath("//a[@href='/lvov/movies/']"));
//        movies.click();
//    }
//
//    public void clickSearchForm() {
//        WebElement searchForm = driver.findElement(By.cssSelector(".move-to-active"));
//        searchForm.click();
//    }
//
//    public void searchMovie(String movieName) throws InterruptedException {
//        WebElement searchField = driver.findElement(By.cssSelector(".search-input"));
//        // Set the value using JavaScript
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].value='" + movieName + "';", searchField);
//        Thread.sleep(5000);
//        // Optionally trigger the input event if needed
//        js.executeScript("arguments[0].dispatchEvent(new Event('input'));", searchField);
//    }
//
//    public boolean isSearchResultDisplayed() {
//        WebElement searchResult = driver.findElement(By.cssSelector(".list-search-movie"));
//        return searchResult.isDisplayed();
//    }

    WebDriver driver;

    @FindBy(css = "#logo")
    private WebElement logo;

    @FindBy(xpath = "//a[@href='/contacts/']")
    private WebElement contactsLink;

    @FindBy(xpath = "//a[@href='/lvov/movies/']")
    private WebElement moviesLink;

    @FindBy(css = ".move-to-active")
    private WebElement searchForm;

    @FindBy(css = ".search-input")
    private WebElement searchField;

    @FindBy(css = ".list-search-movie")
    private WebElement searchResult;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getHomePageTitle() {
        return driver.getTitle();
    }

    public boolean isLogoDisplayed() {
        return logo.isDisplayed();
    }

    public void clickContactsLink() {
        contactsLink.click();
    }

    public void clickMoviesLink() {
        moviesLink.click();
    }

    public void clickSearchForm() {
        searchForm.click();
    }

    public void searchMovie(String movieName) throws InterruptedException {
        // Set the value using JavaScript
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + movieName + "';", searchField);
        Thread.sleep(5000);
        // Optionally trigger the input event if needed
        js.executeScript("arguments[0].dispatchEvent(new Event('input'));", searchField);
    }

    public boolean isSearchResultDisplayed() {
        return searchResult.isDisplayed();
    }

    public WebElement getContactsLink() {
        return contactsLink;
    }


}
