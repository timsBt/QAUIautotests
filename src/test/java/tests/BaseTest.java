package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import static utils.ChromeDriverUtils.getChromeDriver;

/**
 * Базовый класс с настройками для всех тестов.
 */
public class BaseTest {

    /**
     * Объявление экземпляра драйвера.
     */
    private static final ThreadLocal<WebDriver> DRIVER
            = new InheritableThreadLocal<>();

    /**
     * Метод настройки браузера перед тестом.
     */
    @BeforeMethod
    public void setUp() {
        DRIVER.set(getChromeDriver());
        getDriver().manage().window().maximize();
        final int seconds = 10;
        getDriver().manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(seconds));
    }

    /**
     * Метод получения экземпляра драйвера.
     *
     * @return Экземпляр драйвера
     */
    public static WebDriver getDriver() {
        return DRIVER.get();
    }

    /**
     * Закрытие драйвера после теста.
     */
    @AfterMethod
    public void tearDown() {
        DRIVER.get().quit();
        DRIVER.remove();
    }
}
