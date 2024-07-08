package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

//    WebDriver driver;
//
//    public LoginPage(WebDriver driver) {
//        this.driver = driver;
//    }
//
//    public void clickLoginLink() {
//        WebElement loginLink = driver.findElement(By.linkText("Вхід"));
//        loginLink.click();
//    }
//
//    public void enterEmail(String email) {
//        WebElement emailField = driver.findElement(By.cssSelector("#loginform-login"));
//        emailField.sendKeys(email);
//    }
//
//    public void enterPassword(String password) {
//        WebElement passwordField = driver.findElement(By.cssSelector("#loginform-password"));
//        passwordField.sendKeys(password);
//    }
//
//    public void clickLoginButton() {
//        WebElement loginButton = driver.findElement(By.name("login-button"));
//        loginButton.click();
//    }
//
//    public boolean isUserProfileDisplayed() {
//        WebElement userProfile = driver.findElement(By.xpath("//a[@href='https://cabinet.planetakino.ua']"));
//        return userProfile.isDisplayed();
//    }
//
//    public boolean isEmptyFieldErrorDisplayed() {
//        WebElement emptyFieldError = driver.findElement(By.xpath("//p[text()='Необхідно заповнити це поле']"));
//        return emptyFieldError.isDisplayed();
//    }
//
//    public boolean isRegistrationFormDisplayed() {
//        WebElement boxElement = driver.findElement(By.xpath("//div[@class='box']"));
//        return boxElement.isDisplayed();
//    }
//
//    public void clickRegisterLink() {
//        WebElement registerLink = driver.findElement(By.linkText("Реєстрація"));
//        registerLink.click();
//    }

    private WebDriver driver;

    @FindBy(linkText = "Вхід")
    private WebElement loginLink;

    @FindBy(css = "#loginform-login")
    private WebElement emailField;

    @FindBy(css = "#loginform-password")
    private WebElement passwordField;

    @FindBy(name = "login-button")
    private WebElement loginButton;

    @FindBy(xpath = "//a[@href='https://cabinet.planetakino.ua']")
    private WebElement userProfile;

    @FindBy(xpath = "//p[text()='Необхідно заповнити це поле']")
    private WebElement emptyFieldError;

    @FindBy(xpath = "//div[@class='box']")
    private WebElement boxElement;

    @FindBy(linkText = "Реєстрація")
    private WebElement registerLink;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLoginLink() {
        loginLink.click();
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean isUserProfileDisplayed() {
        return userProfile.isDisplayed();
    }

    public boolean isEmptyFieldErrorDisplayed() {
        return emptyFieldError.isDisplayed();
    }

    public boolean isRegistrationFormDisplayed() {
        return boxElement.isDisplayed();
    }

    public void clickRegisterLink() {
        registerLink.click();
    }

}
