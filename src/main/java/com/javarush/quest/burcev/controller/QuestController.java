package com.javarush.quest.burcev.controller;

import com.javarush.quest.burcev.data_base.QuestTable;
import com.javarush.quest.burcev.models.Quest;

import java.util.List;

public class QuestController {
    public static void addQuest(Quest quest){
        QuestTable.addQuest(quest);
    }
    public static List<Quest> getQuest(int userId){
        return QuestTable.getQuests(userId);
    }
}
