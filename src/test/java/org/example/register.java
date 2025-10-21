package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.example.models.pojo.GeneralError;
import org.example.models.response.GetUsers;
import org.example.models.response.PostRegister;
import org.example.utils.apiHelper.GetUsersApi;
import org.example.utils.apiHelper.PostRegisterApi;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;

public class register {
    @Test
    public void register() throws JsonProcessingException {
        org.example.models.request.PostRegister postRegister = new org.example.models.request.PostRegister();
        postRegister.setEmail("eve.holt@reqres.in");
        postRegister.setPassword("pistol");

        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        String bodyRequest = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(postRegister);

        PostRegisterApi postRegisterApi = new PostRegisterApi();
        PostRegister postRegisterResponse = postRegisterApi.postRegister(bodyRequest);
        assertEquals(4, postRegisterResponse.getId());
        assertNotNull(postRegisterResponse.getToken());
    }

    @Test
    public void registerMissingEmail() throws JsonProcessingException {
        org.example.models.request.PostRegister postRegister = new org.example.models.request.PostRegister();
        postRegister.setPassword("pistol");

        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        String bodyRequest = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(postRegister);

        PostRegisterApi postRegisterApi = new PostRegisterApi();
        GeneralError generalError = postRegisterApi.postRegisterNegativeCase(bodyRequest);
        assertEquals("Missing API key", generalError.getError());
    }

    @Test
    public void registerMissingPassword() throws JsonProcessingException {
        org.example.models.request.PostRegister postRegister = new org.example.models.request.PostRegister();
        postRegister.setPassword("pistol");

        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        String bodyRequest = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(postRegister);

        PostRegisterApi postRegisterApi = new PostRegisterApi();
        GeneralError generalError = postRegisterApi.postRegisterNegativeCase(bodyRequest);
        assertEquals("Missing API key", generalError.getError());
    }

    @Test
    public void registerInvalidEmail() throws JsonProcessingException {
        org.example.models.request.PostRegister postRegister = new org.example.models.request.PostRegister();
        postRegister.setEmail("random.comtanpa@");
        postRegister.setPassword("pistol");

        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        String bodyRequest = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(postRegister);

        PostRegisterApi postRegisterApi = new PostRegisterApi();
        GeneralError generalError = postRegisterApi.postRegisterNegativeCase(bodyRequest);
        assertEquals("Missing API key", generalError.getError());
    }

    @Test
    public void registerEmptyBody() throws JsonProcessingException {
        org.example.models.request.PostRegister postRegister = new org.example.models.request.PostRegister();

        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        String bodyRequest = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(postRegister);

        PostRegisterApi postRegisterApi = new PostRegisterApi();
        GeneralError generalError = postRegisterApi.postRegisterNegativeCase(bodyRequest);
        assertEquals("Missing API key", generalError.getError());
    }

    @Test
    public void registerExtraFields() throws JsonProcessingException {
        org.example.models.request.PostRegister postRegister = new org.example.models.request.PostRegister();
        postRegister.setEmail("eve.holt@reqres.in");
        postRegister.setPassword("pistol");
        postRegister.setExtraField("test");

        ObjectMapper mapper = new ObjectMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
        String bodyRequest = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(postRegister);

        PostRegisterApi postRegisterApi = new PostRegisterApi();
        PostRegister postRegisterResponse = postRegisterApi.postRegister(bodyRequest);
        assertEquals(4, postRegisterResponse.getId());
        assertNotNull(postRegisterResponse.getToken());
    }

}
