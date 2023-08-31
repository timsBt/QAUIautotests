package api.tests;

import io.qameta.allure.Description;
import org.apache.http.HttpStatus;
import org.testng.annotations.Test;
import static api.utils.AuthUtils.auth;
import static org.hamcrest.Matchers.equalTo;

public class ApiTests {

    /**
     * Объявление переменной (Имя папки).
     */
    private final String folderName = "New Folder Api";

    /**
     * Объявление переменной (Имя файла).
     */
    private final String fileName = "Файл для копирования.txt";

    /**
     * Объявление переменной (Имя переименованного файла).
     */
    private final String renamedFileName = "Переименованный файл.txt";

    /**
     * Объявление переменной (Приоритет запуска теста).
     */
    private final int number3 = 3;

    /**
     * Тест Создания папки.
     */
    @Test(priority = 1)
    @Description("Создание папки")
    public void createFolderTest() {
        auth()
                .when()
                .put("?path=" + folderName)
                .then().log().body()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .body("method", equalTo("GET"))
                .body("templated", equalTo(false));
    }

    /**
     * Тест Копирования файла в Созданную ранее папку.
     */
    @Test(priority = 2)
    @Description("Копирование файла в Созданную ранее папку")
    public void copyFileTest() {
        auth()
                .when()
                .post("/copy?from=" + fileName + "&path=" + folderName
                        + "/" + fileName)
                .then().log().body()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .body("method", equalTo("GET"))
                .body("templated", equalTo(false));
    }

    /**
     * Тест Переименования файла в папке.
     */
    @Test(priority = number3)
    @Description("Переименование файла в папке")
    public void renameFileTest() {
        auth()
                .when()
                .post("/move?from=" + folderName + "/" + fileName + "&path="
                        + folderName + "/" + renamedFileName)
                .then().log().body()
                .assertThat()
                .statusCode(HttpStatus.SC_CREATED)
                .body("method", equalTo("GET"))
                .body("templated", equalTo(false));
    }
}
