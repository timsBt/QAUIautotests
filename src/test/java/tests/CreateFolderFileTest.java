package tests;

import org.openqa.selenium.WindowType;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AuthorizationPage;
import pages.MainPage;
import pages.YandexDiskPage;


import java.util.ArrayList;

import static utils.PropertiesUtils.valueProperties;

public class CreateFolderFileTest extends BaseTest {

    /**
     * Открытие главной страницы.
     */
    @BeforeMethod
    public void openPage() {
        getDriver().get(valueProperties("mainPageUrl"));
    }

    /**
     * Тест авторизации и создания файла в папке на Яндекс Диске.
     */
    @Test(description = "TC-1 Авторизация и Создание папки и файла")
    public void authorizationCreateFolderFileTest() {
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
     * Метод выхода с аккаунта на Яндекс Диске и на Яндекс Дзене.
     */
    @AfterMethod
    public void deauthorization() {
        YandexDiskPage yandexDiskPage = new YandexDiskPage(getDriver());
        yandexDiskPage.loginButtonClick();
        yandexDiskPage.outButtonClick();
        ArrayList tabs = new ArrayList(getDriver().getWindowHandles());
        getDriver().switchTo().window(String.valueOf(tabs.get(0)));
        MainPage mainPage = new MainPage(getDriver());
        mainPage.outButtonClick();
    }
}
