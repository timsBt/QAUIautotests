package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Класс описания главной страницы Yandex.
 */
public class MainPage {

    /**
     * Конструктор класса для инициализации вэб элементов.
     *
     * @param webDriver драйвер для управления браузером
     */
    public MainPage(final WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Поиск и объявление локатора кнопки "Войти".
     */
    @FindBy(xpath = "//div[@class=\"login-button__textButton-3Y\"]")
    private WebElement signIn;

    /**
     * Поиск и объявление локатора кнопки "Войти через Яндекс ID".
     */
    @FindBy(xpath = "//div[@class=\"login-content__yaButtonWrapper-15\"]")
    private WebElement signInYandexId;

    /**
     * Поиск и объявление локатора кнопки Профиля.
     */
    @FindBy(xpath = "//button[@class=\"zen-ui-avatar _is-button"
            + " _icon-size_32\"]")
    private WebElement loginButton;

    /**
     * Поиск и объявление локатора текста Логина.
     */
    @FindBy(xpath = "//span[@class=\"cell-middle-content__title-3u\"]")
    private WebElement userNameText;

    /**
     * Поиск и объявление локатора кнопки Выйти.
     */
    @FindBy(xpath = "//a[@aria-label=\"Выйти\"]")
    private WebElement outButton;

    /**
     * Метод проверки на наличия элементов на странице.
     *
     * @param element элемент на странице
     */
    public void openElement(final WebElement element) {
        Assert.assertTrue(element.isDisplayed());
    }

    /**
     * Метод получения элемента кнопки "Войти"
     * и проверка его наличия на странице.
     *
     * @return элемент кнопки "Войти"
     */
    public WebElement getSignIn() {
        openElement(signIn);
        return signIn;
    }

    /**
     * Метод получения элемента кнопки "Войти через Яндекс ID"
     * и проверка его наличия на странице.
     *
     * @return элемент кнопки "Войти через Яндекс ID"
     */
    public WebElement getSignInYandexId() {
        openElement(signInYandexId);
        return signInYandexId;
    }

    /**
     * Метод получения элемента кнопки Профиля
     * и проверка его наличия на странице.
     *
     * @return элемент кнопки Профиля
     */
    public WebElement getLoginButton() {
        openElement(loginButton);
        return loginButton;
    }

    /**
     * Метод получения элемента текста Имени пользователя
     * и проверка его наличия на странице.
     *
     * @return элемент элемента текста Имени пользователя
     */
    public WebElement getUserNameText() {
        openElement(userNameText);
        return userNameText;
    }

    /**
     * Метод получения элемента кнопки "Выйти"
     * и проверка его наличия на странице.
     *
     * @return элемент кнопки "Выйти"
     */
    public WebElement getOutButton() {
        openElement(outButton);
        return outButton;
    }

    /**
     * Метод клика по кнопке Войти.
     *
     * @return Текущая страница
     */
    @Step("Клик по кнопке Войти")
    public MainPage signInButtonClick() {
        getSignIn().click();
        return this;
    }

    /**
     * Метод клика по кнопке Войти через Яндекс ID.
     *
     * @return Текущая страница
     */
    @Step("Клик по кнопке Войти через Яндекс ID")
    public MainPage signInYandexIdButtonClick() {
        getSignInYandexId().click();
        return this;
    }

    /**
     * Метод клика по кнопке Профиля.
     *
     * @return Текущая страница
     */
    @Step("Клик по кнопке Профиля")
    public MainPage logButtonClick() {
        getLoginButton().click();
        return this;
    }

    /**
     * Метод получения текста Логина.
     *
     * @return текст Логина
     */
    @Step("Получение текста Логина")
    public String userNameCheck() {
        return getUserNameText().getText();
    }

    /**
     * Метод клика по кнопке Выйти.
     *
     * @return Текущая страница
     */
    @Step("Клик по кнопке Выйти")
    public MainPage outButtonClick() {
        getOutButton().click();
        return this;
    }
}
