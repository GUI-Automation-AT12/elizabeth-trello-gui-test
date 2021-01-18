package org.fundacionjala.trello.api.utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.fundacionjala.trello.api.config.ApiEnvironment;

public final class AuthenticationUtils {
    private static final String BASE_URL = ApiEnvironment.getInstance().getBaseUrl();
    private static final String KEY_VALUE = ApiEnvironment.getInstance().getKey();
    private static final String TOKEN_VALUE = ApiEnvironment.getInstance().getToken();
    private static final String KEY = "key";
    private static final String TOKEN = "token";

    /**
     * Constructor.
     */
    private AuthenticationUtils() {

    }

    /**
     * Gets request specifications.
     * @return request.
     */
    public static RequestSpecification getLoggedReqSpec() {
        RequestSpecification request = RestAssured.given();
        request.baseUri(BASE_URL)
                .contentType(ContentType.JSON.toString())
                .queryParam(KEY, KEY_VALUE)
                .queryParam(TOKEN, TOKEN_VALUE);
        return request;
    }

    /**
     * Gets request specifications.
     * @return request.
     */
    public static RequestSpecification getNotLoggedReqSpec() {
        RequestSpecification request = RestAssured.given();
        request.baseUri(BASE_URL);
        return request;
    }

    /**
     * Gets request specifications.
     * @return request.
     */
    public static RequestSpecification getNotLoggedWithKeyReqSpec() {
        RequestSpecification request = RestAssured.given();
        request.baseUri(BASE_URL)
                .contentType(ContentType.JSON.toString())
                .queryParam(KEY, KEY_VALUE);
        return request;
    }

    /**
     * Gets request specifications.
     * @return request.
     */
    public static RequestSpecification getNotLoggedWithTokenReqSpec() {
        RequestSpecification request = RestAssured.given();
        request.baseUri(BASE_URL)
                .contentType(ContentType.JSON.toString())
                .queryParam(TOKEN, TOKEN_VALUE);
        return request;
    }
}
