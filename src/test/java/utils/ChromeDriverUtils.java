package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Класс создания WebDriver для запуска браузера.
 */
public final class ChromeDriverUtils {

    private ChromeDriverUtils() {
    }

    /**
     * Метод установки драйвера.
     *
     * @return экземпляр драйвера для браузера
     */
    public static ChromeDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }
}
