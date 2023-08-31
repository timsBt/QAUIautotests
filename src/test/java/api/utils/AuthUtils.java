package api.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;

import static utils.PropertiesUtils.valueProperties;

/**
 * Класс утилит для авторизации.
 */
public final class AuthUtils {

    private AuthUtils() {
    }

    /**
     * Метод для авторизации с помощью OAuth.
     *
     * @return авторизация
     */
    public static RequestSpecification auth() {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .header(new Header("Authorization", valueProperties("OAuth")))
                .baseUri(valueProperties("yandexApiDiskUrl"));
    }
}
