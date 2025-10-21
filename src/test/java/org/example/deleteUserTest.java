package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.utils.apiHelper.DeleteUserApi;
import org.testng.annotations.Test;

import static junit.framework.Assert.assertEquals;

public class deleteUserTest {
    private int correctId = 2;
    private int invalidId = 99;

    @Test
    public void deleteUser() throws JsonProcessingException {
        DeleteUserApi deleteUserApi = new DeleteUserApi();
        int statusCode = deleteUserApi.deleteUser(2);
        assertEquals(201, statusCode);
    }

    @Test
    public void deleteNonExistedUser() throws JsonProcessingException {
        DeleteUserApi deleteUserApi = new DeleteUserApi();
        int statusCode = deleteUserApi.deleteUser(999999);
        assertEquals(404, statusCode);
    }

    @Test
    public void deleteWithoutUserId() throws JsonProcessingException {
        DeleteUserApi deleteUserApi = new DeleteUserApi();
        int statusCode = deleteUserApi.deleteUserWithoutUserId();
        assertEquals(404, statusCode);
    }
}
