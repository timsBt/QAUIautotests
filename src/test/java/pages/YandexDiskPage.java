package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static tests.BaseTest.getDriver;

/**
 * Класс описания страницы Yandex Disk.
 */
public class YandexDiskPage {

    /**
     * Конструктор класса для инициализации вэб элементов.
     *
     * @param webDriver драйвер для управления браузером
     */
    public YandexDiskPage(final WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    /**
     * Поиск и объявление локатора кнопки "Создать".
     */
    @FindBy(xpath = "//button[@class=\"Button2 Button2_view_raised"
            + " Button2_size_m Button2_width_max\"]")
    private WebElement createButton;

    /**
     * Поиск и объявление локатора кнопки "Создать Папку".
     */
    @FindBy(xpath = "//button[@class=\"create-resource-button"
            + " create-resource-popup-with-anchor__create-item\"]")
    private WebElement createFolderButton;

    /**
     * Поиск и объявление локатора поля ввода Названия папки.
     */
    @FindBy(xpath = "//input[@text=\"Новая папка\"]")
    private WebElement createNameFolder;

    /**
     * Поиск и объявление локатора поля ввода Названия Документа.
     */
    @FindBy(xpath = "//input[@text=\"Новый документ\"]")
    private WebElement createNameDocument;

    /**
     * Поиск и объявление локатора кнопки Сохранить.
     */
    @FindBy(xpath = "//button[@class=\"Button2 Button2_view_action"
            + " Button2_size_m confirmation-dialog__button"
            + " confirmation-dialog__button_submit \"]")
    private WebElement saveFolderAndFiles;

    /**
     * Поиск и объявление локатора Созданной папки.
     */
    @FindBy(xpath = "//div[@class=\"listing-item listing-item_theme_tile"
            + " listing-item_size_m listing-item_type_dir"
            + " listing-item_selected js-prevent-deselect\"]")
    private WebElement newFolder;

    /**
     * Поиск и объявление локатора кнопки "Создать Текстовый документ".
     */
    @FindBy(xpath = "//span[@class=\"file-icon file-icon_size_m"
            + " file-icon_doc create-resource-button__icon\"]")
    private WebElement createTextDocument;

    /**
     * Поиск и объявление локатора названия Нового Файла.
     */
    @FindBy(xpath = "//span[@class=\"clamped-text\"]")
    private WebElement textNewFile;

    /**
     * Поиск и объявление кнопки Логина.
     */
    @FindBy(xpath = "//div[@class=\"user-pic user-pic_has-plus_"
            + " user-account__pic\"]")
    private WebElement loginButton;

    /**
     * Поиск и объявление кнопки Выйти.
     */
    @FindBy(xpath = "//a[@class=\"menu__item menu__item_type_link"
            + " legouser__menu-item legouser__menu-item_action_exit\"]")
    private WebElement outButton;

    /**
     * Поиск и объявление локатора Нового Загруженного Файла.
     */
    @FindBy(xpath = "//div[@class=\"listing-item__title"
            + " listing-item__title_overflow_clamp\"]")
    private WebElement newUploadFile;

    /**
     * Поиск и объявление локатора текста Нового Загруженного Файла.
     */
    @FindBy(xpath = "//div[@class=\"__page-1\"]")
    private WebElement fileTextUploadFile;

    /**
     * Метод проверки на наличия элементов на странице.
     *
     * @param element элемент на странице
     */
    public void openElement(final WebElement element) {
        Assert.assertTrue(element.isDisplayed());
    }

    /**
     * Метод получения элемента кнопки "Создать"
     * и проверка его наличия на странице.
     *
     * @return элемент кнопки "Создать"
     */
    public WebElement getCreateButton() {
        openElement(createButton);
        return createButton;
    }

    /**
     * Метод получения элемента кнопки "Создать Папку"
     * и проверка его наличия на странице.
     *
     * @return элемент кнопки "Создать Папку"
     */
    public WebElement getCreateFolderButton() {
        openElement(createFolderButton);
        return createFolderButton;
    }

    /**
     * Метод получения элемента поля ввода Названия Папки
     * и проверка его наличия на странице.
     *
     * @return элемент поля ввода Названия папки
     */
    public WebElement getCreateNameFolder() {
        openElement(createNameFolder);
        return createNameFolder;
    }

    /**
     * Метод получения элемента поля ввода Названия Документа
     * и проверка его наличия на странице.
     *
     * @return элемент поля ввода Названия Документа
     */
    public WebElement getCreateNameDocument() {
        openElement(createNameDocument);
        return createNameDocument;
    }

    /**
     * Метод получения элемента кнопки Сохранить
     * и проверка его наличия на странице.
     *
     * @return элемент кнопки Сохранить
     */
    public WebElement getSaveFolderAndFiles() {
        openElement(saveFolderAndFiles);
        return saveFolderAndFiles;
    }

    /**
     * Метод получения элемента Новой Папки
     * и проверка его наличия на странице.
     *
     * @return элемент Новой папки
     */
    public WebElement getNewFolder() {
        openElement(newFolder);
        return newFolder;
    }

    /**
     * Метод получения элемента кнопки "Создать Текстовый Документ"
     * и проверка его наличия на странице.
     *
     * @return элемент кнопки "Создать Текстовый Документ"
     */
    public WebElement getCreateTextDocument() {
        openElement(createTextDocument);
        return createTextDocument;
    }

    /**
     * Метод получения элемента названия Нового Файла
     * и проверка его наличия на странице.
     *
     * @return элемент названия Нового Файла
     */
    public WebElement getTextNewFile() {
        openElement(textNewFile);
        return textNewFile;
    }

    /**
     * Метод получения элемента кнопки Логин
     * и проверка его наличия на странице.
     *
     * @return элемент кнопки Логин
     */
    public WebElement getLoginButton() {
        openElement(loginButton);
        return loginButton;
    }

    /**
     * Метод получения элемента кнопки Выйти
     * и проверка его наличия на странице.
     *
     * @return элемент кнопки Выйти
     */
    public WebElement getOutButton() {
        openElement(outButton);
        return outButton;
    }

    /**
     * Метод получения элемента Нового Загруженного файла
     * и проверка его наличия на странице.
     *
     * @return элемент Нового Загруженного файла
     */
    public WebElement getNewUploadFile() {
        openElement(newUploadFile);
        return newUploadFile;
    }

    /**
     * Метод получения элемента Текста Загруженного файла
     * и проверка его наличия на странице.
     *
     * @return элемент Нового Загруженного файла
     */
    public WebElement getFileTextUploadFile() {
        openElement(fileTextUploadFile);
        return fileTextUploadFile;
    }

    /**
     * Метод клика по кнопке "Создать".
     *
     * @return Текущая страница
     */
    @Step("Клик по кнопке Создать")
    public YandexDiskPage createButtonClick() {
        getCreateButton().click();
        return this;
    }

    /**
     * Метод Создания Папки с Названием".
     *
     * @param folderName Название папки
     * @return Текущая страница
     */
    @Step("Создание Папки с Названием")
    public YandexDiskPage createFolder(final String folderName) {
        getCreateFolderButton().click();
        getCreateNameFolder().sendKeys(Keys.CONTROL + "A");
        getCreateNameFolder().sendKeys(Keys.BACK_SPACE, folderName);
        getSaveFolderAndFiles().click();
        return this;
    }

    /**
     * Метод открытия Новой папки.
     *
     * @return Текущая страница
     */
    @Step("Открытие Новой папки")
    public YandexDiskPage openNewFolder() {
        Actions actions = new Actions(getDriver());
        actions.doubleClick(getNewFolder()).perform();
        return this;
    }

    /**
     * Метод Создания Текстового Документа с Названием.
     *
     * @param documentName Название Документа
     * @return Текущая страница
     */
    @Step("Создание нового Текстового Документа с Названием")
    public YandexDiskPage createTextDocumentFile(final String documentName) {
        getCreateTextDocument().click();
        getCreateNameDocument().sendKeys(Keys.CONTROL + "A");
        getCreateNameDocument().sendKeys(Keys.BACK_SPACE, documentName);
        getSaveFolderAndFiles().click();
        return this;
    }

    /**
     * Метод получения названия Нового Файла.
     *
     * @return Текущая страница
     */
    @Step("Получение названия Нового Файла")
    public String newFileTextCheck() {
        return getTextNewFile().getText();
    }

    /**
     * Метод клика на Логин.
     *
     * @return Текущая страница
     */
    @Step("Клик на Логин")
    public YandexDiskPage loginButtonClick() {
        getLoginButton().click();
        return this;
    }

    /**
     * Метод клика на кнопку Выйти.
     *
     * @return Текущая страница
     */
    @Step("Клик на кнопку Выйти")
    public YandexDiskPage outButtonClick() {
        getOutButton().click();
        return this;
    }

    /**
     * Метод Загрузки файла на Яндекс Диск.
     *
     * @return Текущая страница
     */
    @Step("Загрузка файла")
    public YandexDiskPage uploadButtonClick() {
        By fileInput = By.cssSelector("input[type=file]");
        String filePath = "C:\\Users\\timsb\\IdeaProjects"
                + "\\QAUIautotests\\FileUpload.txt";
        getDriver().findElement(fileInput).sendKeys(filePath);
        return this;
    }

    /**
     * Метод Открытия Нового Загруженного файла.
     *
     * @return Текущая страница
     */
    @Step("Открытие Нового Загруженного файла")
    public YandexDiskPage openNewUploadFile() {
        final int x = 3000;
        new Actions(getDriver()).pause(x).perform();
        Actions actions = new Actions(getDriver());
        actions.doubleClick(getNewUploadFile()).perform();
        return this;
    }

    /**
     * Метод получения текста Загруженного Файла.
     *
     * @return Текущая страница
     */
    @Step("Получение текста Загруженного Файла")
    public String newFileText() {
        return getFileTextUploadFile().getText();
    }
}
