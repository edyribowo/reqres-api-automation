package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.models.pojo.GeneralError;
import org.example.models.response.GetUsers;
import org.example.utils.apiHelper.GetUsersApi;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;

public class getUsersTest {
    private int correctId = 2;
    private int invalidId = 99;

    @Test
    public void getUserId() throws JsonProcessingException {
        GetUsersApi getUsersApi = new GetUsersApi();
        GetUsers getUsers = getUsersApi.getUsers(correctId);
        assertEquals(correctId, getUsers.getData().getId());
        assertEquals("Janet", getUsers.getData().getFirst_name());
        assertEquals("Weaver", getUsers.getData().getLast_name());
        assertEquals("https://reqres.in/img/faces/2-image.jpg",
                getUsers.getData().getAvatar());
    }

    @Test
    public void getUserInvalidId() throws JsonProcessingException {
        GetUsersApi getUsersApi = new GetUsersApi();
        GeneralError generalError = getUsersApi.getUsersInvalidId(invalidId);
        assertEquals("Missing API key", generalError.getError());
    }

    @Test
    public void getUserMissingId() throws JsonProcessingException {
        GetUsersApi getUsersApi = new GetUsersApi();
        GeneralError generalError = getUsersApi.getUsersMissingId();
        assertEquals("Missing API key", generalError.getError());
    }

    @Test
    public void getUserInvalidIdFormat() throws JsonProcessingException {
        GetUsersApi getUsersApi = new GetUsersApi();
        GeneralError generalError = getUsersApi.getUsersInvalidIdFormat("abc");
        assertEquals("Missing API key", generalError.getError());
    }

}
