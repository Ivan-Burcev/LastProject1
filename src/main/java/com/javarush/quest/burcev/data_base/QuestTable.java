package com.javarush.quest.burcev.data_base;

import com.javarush.quest.burcev.models.Quest;

import java.util.ArrayList;
import java.util.List;

public class QuestTable {
     private static List<Quest> quests;
    public static void addQuest(Quest quest){
        quests.add(quest);
    }
    public static List<Quest> getQuests(int userId){
        List<Quest> userQuests = new ArrayList<>();
        for(Quest quest: quests)
        {
            if(quest.getUserId()==userId)
                userQuests.add(quest);

        }
        return userQuests;
    }
}
