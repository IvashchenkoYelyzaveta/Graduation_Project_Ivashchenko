package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    WebDriver driver;

    // Конструктор класса LoginPage, принимает WebDriver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Клик по ссылке "Вхід"
    public void clickLoginLink() {
        WebElement loginLink = driver.findElement(By.linkText("Вхід"));
        loginLink.click();
    }

    // Ввод email
    public void enterEmail(String email) {
        WebElement emailField = driver.findElement(By.cssSelector("#loginform-login"));
        emailField.sendKeys(email);
    }

    // Ввод пароля
    public void enterPassword(String password) {
        WebElement passwordField = driver.findElement(By.cssSelector("#loginform-password"));
        passwordField.sendKeys(password);
    }

    // Клик по кнопке "login-button"
    public void clickLoginButton() {
        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();
    }

    // Проверка, отображается ли профиль пользователя
    public boolean isUserProfileDisplayed() {
        WebElement userProfile = driver.findElement(By.xpath("//a[@href='https://cabinet.planetakino.ua']"));
        return userProfile.isDisplayed();
    }

    // Проверка, отображается ли сообщение об ошибке пустого поля
    public boolean isEmptyFieldErrorDisplayed() {
        WebElement emptyFieldError = driver.findElement(By.xpath("//p[text()='Необхідно заповнити це поле']"));
        return emptyFieldError.isDisplayed();
    }

    // Проверка, отображается ли форма регистрации
    public boolean isRegistrationFormDisplayed() {
        WebElement boxElement = driver.findElement(By.xpath("//div[@class='box']"));
        return boxElement.isDisplayed();
    }

    // Клик по ссылке "Реєстрація"
    public void clickRegisterLink() {
        WebElement registerLink = driver.findElement(By.linkText("Реєстрація"));
        registerLink.click();
    }

}
