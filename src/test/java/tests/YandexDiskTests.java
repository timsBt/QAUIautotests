package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AuthorizationPage;
import pages.MainPage;
import pages.YandexDiskPage;

import java.util.ArrayList;

import static utils.PropertiesUtils.valueProperties;

@Epic(value = "UI Tests")
public class YandexDiskTests extends BaseTest {

    /**
     * Открытие главной страницы.
     */
    @BeforeMethod
    public void openPage() {
        getDriver().get(valueProperties("mainPageUrl"));
    }

    /**
     * Тест авторизации, Создание папки и файла на Яндекс Диске.
     */
    @Test(description = "TC-1 Авторизация, Создание папки и файла")
    @Feature(value = "Создание папки и файла")
    @Description("Авторизация, Создание папки и файла")
    public void authorizationCreateFileTest() {
        MainPage mainPage = new MainPage(getDriver());
        AuthorizationPage authorization = new AuthorizationPage(getDriver());
        mainPage.signInButtonClick()
            .signInYandexIdButtonClick();
        authorization.userInput(valueProperties("login"),
            valueProperties("password"));
        mainPage.logButtonClick();
        Assert.assertEquals(mainPage.userNameCheck(), "Timur Bekmatov");
        getDriver().switchTo().newWindow(WindowType.TAB);
        getDriver().get(valueProperties("yandexDiskPageUrl"));
        YandexDiskPage yandexDiskPage = new YandexDiskPage(getDriver());
        yandexDiskPage.createButtonClick()
            .createFolder("New Folder")
            .openNewFolder()
            .createButtonClick()
            .createTextDocumentFile("New File");
        ArrayList tabs = new ArrayList(getDriver().getWindowHandles());
        getDriver().switchTo().window(String.valueOf(tabs.get(2))).close();
        getDriver().switchTo().window(String.valueOf(tabs.get(1)));
        Assert.assertEquals(yandexDiskPage.newFileTextCheck(),
            "New File.docx", "Название не соответствует");
    }

    /**
     * Тест авторизации, Создание папки и Загрузка файла на Яндекс Диске.
     */
    @Test(description = "TC-2 Авторизация, Создание папки и Загрузка файла")
    @Feature(value = "Создание папки и Загрузка файла")
    @Description("Авторизация, Создание папки и Загрузка файла")
    public void autorizationUploadFileTest() {
        MainPage mainPage = new MainPage(getDriver());
        AuthorizationPage authorization = new AuthorizationPage(getDriver());
        mainPage.signInButtonClick()
            .signInYandexIdButtonClick();
        authorization.userInput(valueProperties("login"),
            valueProperties("password"));
        mainPage.logButtonClick();
        Assert.assertEquals(mainPage.userNameCheck(), "Timur Bekmatov");
        getDriver().switchTo().newWindow(WindowType.TAB);
        getDriver().get(valueProperties("yandexDiskPageUrl"));
        YandexDiskPage yandexDiskPage = new YandexDiskPage(getDriver());
        yandexDiskPage.createButtonClick()
            .createFolder("Two Folder")
            .openNewFolder()
            .uploadButtonClick()
            .openNewUploadFile();
        ArrayList tabs = new ArrayList(getDriver().getWindowHandles());
        getDriver().switchTo().window(String.valueOf(tabs.get(2)));
        Assert.assertEquals(yandexDiskPage.newFileText(), "Привет!",
            "Текст не соответствует");
        getDriver().switchTo().window(String.valueOf(tabs.get(2))).close();
        getDriver().switchTo().window(String.valueOf(tabs.get(1)));
        getDriver().navigate().refresh();
    }

    /**
     * Метод выхода с аккаунта на Яндекс Диске и на Яндекс Дзене.
     */
    @AfterMethod
    public void deauthorization() {
        YandexDiskPage yandexDiskPage = new YandexDiskPage(getDriver());
        yandexDiskPage.loginButtonClick()
            .outButtonClick();
        ArrayList tabs = new ArrayList(getDriver().getWindowHandles());
        getDriver().switchTo().window(String.valueOf(tabs.get(1))).close();
        getDriver().switchTo().window(String.valueOf(tabs.get(0)));
        MainPage mainPage = new MainPage(getDriver());
        mainPage.outButtonClick();
    }
}
