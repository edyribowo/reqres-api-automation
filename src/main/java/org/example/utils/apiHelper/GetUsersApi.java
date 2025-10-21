package org.example.utils.apiHelper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.models.pojo.GeneralError;
import org.example.models.response.GetUsers;
import org.example.utils.ConfigReader;

public class GetUsersApi {
    public static String apiURL = ConfigReader.get("reqresBaseURL");

    public GetUsers getUsers(int idx) throws JsonProcessingException {
        Response response = RestAssured
                .given()
                    .baseUri(apiURL)
                .when()
                    .get("/users/" + idx)
                .then()
                    .statusCode(200)
                    .extract().response();
        response.prettyPrint();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.getBody().asString(), GetUsers.class);
    }

    public GeneralError getUsersInvalidId(int invalidId) throws JsonProcessingException {
        Response response = RestAssured
                .given()
                    .baseUri(apiURL)
                .when()
                    .get("/users/" + invalidId)
                .then()
                    .statusCode(401)
                    .extract().response();
        response.prettyPrint();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.getBody().asString(), GeneralError.class);
    }

    public GeneralError getUsersMissingId() throws JsonProcessingException {
        Response response = RestAssured
                .given()
                    .baseUri(apiURL)
                .when()
                    .get("/users/")
                .then()
                    .statusCode(401)
                    .extract().response();
        response.prettyPrint();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.getBody().asString(), GeneralError.class);
    }

    public GeneralError getUsersInvalidIdFormat(String key) throws JsonProcessingException {
        Response response = RestAssured
                .given()
                    .baseUri(apiURL)
                .when()
                    .get("/users/" + key)
                .then()
                    .statusCode(401)
                    .extract().response();
        response.prettyPrint();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.getBody().asString(), GeneralError.class);
    }
}
