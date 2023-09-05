package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

import static tests.BaseTest.getDriver;

/**
 * Класс описания страницы авторизации.
 */
public class AuthorizationPage {

    /**
     * Конструктор класса для инициализации вэб элементов.
     *
     * @param webDriver драйвер для управления браузером
     */
    public AuthorizationPage(final WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Поиск и объявление локатора поля ввода Логина.
     */
    @FindBy(xpath = "//input[@name=\"login\"]")
    private WebElement login;

    /**
     * Поиск и объявление локатора кнопки "Войти".
     */
    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement signIn;

    /**
     * Поиск и объявление локатора поля ввода Пароля.
     */
    @FindBy(xpath = "//input[@name=\"passwd\"]")
    private WebElement password;

    /**
     * Поиск и объявление локатора кнопки "Почта".
     */
    @FindBy(xpath = "//button[@data-type=\"login\"]")
    private WebElement mailButton;

    /**
     * Метод проверки на наличия элементов на странице.
     *
     * @param element элемент на странице
     */
    public void checkOpen(final WebElement element) {
        final int seconds = 10;
        WebDriverWait wait = new WebDriverWait(getDriver(),
                Duration.ofSeconds(seconds));
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.isDisplayed());
    }

    /**
     * Метод получения элемента поля Логин
     * и проверка его наличия на странице.
     *
     * @return элемент поля Логин
     */
    public WebElement getLogin() {
        checkOpen(login);
        return login;
    }

    /**
     * Метод получения элемента кнопки "Войти"
     * и проверка его наличия на странице.
     *
     * @return элемент кнопки "Войти"
     */
    public WebElement getSignIn() {
        checkOpen(signIn);
        return signIn;
    }

    /**
     * Метод получения элемента поля Пароля
     * и проверка его наличия на странице.
     *
     * @return элемент поля Пароля
     */
    public WebElement getPassword() {
        checkOpen(password);
        return password;
    }

    /**
     * Метод получения элемента кнопки Почта
     * и проверка его наличия на странице.
     *
     * @return элемент кнопки почта
     */
    public WebElement getMailButton() {
        checkOpen(mailButton);
        return mailButton;
    }

    /**
     * Метод ввода данных в поля Логин, Пароль и нажатие кнопки Войти.
     *
     * @param username Имя пользователя
     * @param passwordUser Пароль пользователя
     * @return Текущая страница
     */
    @Step("Авторизация с логином и паролем")
    public AuthorizationPage userInput(final String username,
                                       final String passwordUser) {
        getMailButton().click();
        getLogin().sendKeys(username);
        getSignIn().click();
        getPassword().sendKeys(passwordUser);
        getSignIn().click();
        return this;
    }
}
