package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
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
