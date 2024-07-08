package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage {

    WebDriver driver;

    @FindBy(css = ".cart__icon")
    private WebElement cart;

    public boolean isCartDisplayed() {
        return cart.isDisplayed();
    }

    @FindBy(css = ".city-selector")
    private WebElement city;

    public boolean isCityDisplayed() {
        return cart.isDisplayed();
    }

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
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='" + movieName + "';", searchField);
        Thread.sleep(5000);
        js.executeScript("arguments[0].dispatchEvent(new Event('input'));", searchField);
    }

    public boolean isSearchResultDisplayed() {
        return searchResult.isDisplayed();
    }

    public WebElement getContactsLink() {
        return contactsLink;
    }


}
