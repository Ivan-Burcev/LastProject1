package com.javarush.quest.burcev.controller;

import com.javarush.quest.burcev.data_base.PersonTable;
import com.javarush.quest.burcev.models.Quest;
import com.javarush.quest.burcev.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserController {



    public static boolean addUser(User user){
        return PersonTable.addUser(user);
    }
    public static boolean checkUser(User user)
    {
        return PersonTable.checkUser(user);
    }
    public static User getUser(int id){
        return PersonTable.getUser(id);
    }
    public static void addQuests(int id){
        getUser(id).setQuests(QuestController.getQuest(id));
    }
}
