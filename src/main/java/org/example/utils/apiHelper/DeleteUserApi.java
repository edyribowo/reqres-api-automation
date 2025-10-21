package org.example.utils.apiHelper;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.utils.ConfigReader;

public class DeleteUserApi {
    public static String apiURL = ConfigReader.get("reqresBaseURL");

    public int deleteUser(int idx) throws JsonProcessingException {
        Response response = RestAssured
                .given()
                .baseUri(apiURL)
                .contentType("application/json; charset=UTF-8")
                .when()
                .delete("/users/" + idx)
                .then()
                .extract().response();
        return response.statusCode();
    }

    public int deleteUserWithoutUserId() {
        Response response = RestAssured
                .given()
                .baseUri(apiURL)
                .contentType("application/json; charset=UTF-8")
                .when()
                .delete("/users/")
                .then()
                .extract().response();
        return response.statusCode();
    }
}
