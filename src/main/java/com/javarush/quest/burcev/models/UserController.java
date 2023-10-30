package com.javarush.quest.burcev.models;

import java.util.ArrayList;
import java.util.List;

public class UserController {
    private static List<User> users = new ArrayList<>();


    public static boolean addUser(User user){
        System.out.println(user.toString()); //Лог
        if(checkUser(user)){

            return false;
        }

        users.add(user);

        return true;
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
    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
    public static void addQuest(int userId, Quest quest){
        User user = users.get(userId);
        if(user.getQuests() == null){
            user.setQuests(new ArrayList<>());
        }
        user.getQuests().add(quest);

    }
}
