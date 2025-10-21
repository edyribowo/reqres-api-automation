package org.example.utils.apiHelper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.example.models.pojo.GeneralError;
import org.example.models.response.PostRegister;
import org.example.utils.ConfigReader;

public class PostRegisterApi {
    public static String apiURL = ConfigReader.get("reqresBaseURL");


    public PostRegister postRegister(String bodyRequest) throws JsonProcessingException {
        Response response = RestAssured
                .given()
                    .baseUri(apiURL)
                    .contentType("application/json; charset=UTF-8")
                    .body(bodyRequest)
                .when()
                    .post("/register")
                .then()
                    .statusCode(200)
                    .extract().response();
        System.out.println(bodyRequest);
        response.prettyPrint();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.getBody().asString(), PostRegister.class);
    }

    public GeneralError postRegisterNegativeCase(String bodyRequest) throws JsonProcessingException {
        Response response = RestAssured
                .given()
                .baseUri(apiURL)
                .contentType("application/json; charset=UTF-8")
                .body(bodyRequest)
                .when()
                .post("/register")
                .then()
                .statusCode(401)
                .extract().response();
        System.out.println(bodyRequest);
        response.prettyPrint();
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.getBody().asString(), GeneralError.class);
    }
}
