package com.javarush.quest.burcev.data_base;

import com.javarush.quest.burcev.models.User;

import java.util.ArrayList;
import java.util.List;

public class PersonTable {
    private static List<User> users = new ArrayList<>();
    public static boolean addUser(User user){
        if(checkUser(user)) {
            return false;
        } else
        {
            users.add(user);
            return true;
        }

    }
    public static User getUser(int id){
        return users.get(id);
    }
    public static boolean checkUser(User user)
    {
        for (User user1: users)
        {
            boolean name = user1.getName().equals(user.getName());

            boolean password = user1.getPassword().equals(user.getPassword());

            if(name&&password) {
                user.setId(user1.getId());
                return true;
            }
        }
        return false;
    }

}
