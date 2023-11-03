package com.javarush.quest.burcev.models;

import com.javarush.quest.burcev.controller.UserController;
import com.javarush.quest.burcev.enums.PreparedValues;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import org.mockito.*;
import static org.mockito.Mockito.*;

class UserControllerTest {
    @Test
    void addUserTest(){
        UserController.addUser(new User(1, "1", "1"));
        assertFalse(UserController.addUser(new User(1, "1", "1")));
        assertTrue(UserController.addUser(new User(2, "2", "2")));
    }
    @Test
    void checkUserTest(){
        UserController.addUser(new User(1, "1", "1"));
        assertTrue(UserController.checkUser(new User(1, "1", "1")));
        assertFalse(UserController.checkUser(new User(2, "2", "2")));
    }
    @Test
    void addQuestTest(){

    }

}