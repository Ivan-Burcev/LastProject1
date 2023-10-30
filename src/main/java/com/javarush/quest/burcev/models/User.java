package com.javarush.quest.burcev.models;

import java.util.List;

public class User {
    private int id;
    private String name;
    private String password;

    private List<Quest> quests;

    public User(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Quest> getQuests() {

        return quests;
    }

    public void setQuests(List<Quest> quests) {
        this.quests = quests;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }





}
