package com.javarush.quest.burcev.models;

public class Quest {
    private static int countId = 0;
    private int id;
    private int userId;
    private String name_quest;
    private int correct_answer;
    private int incorrect_answer;

    private Quest(int id, int userId, String name_quest, int correct_answer, int incorrect_answer) {
        this.id = id;
        this.userId = userId;
        this.name_quest = name_quest;
        this.correct_answer = correct_answer;
        this.incorrect_answer = incorrect_answer;
    }
    public static Quest fabricQuest(int userId, String name_quest, int correct_answer, int incorrect_answer){
        return new Quest(countId++, userId, name_quest, correct_answer, incorrect_answer);
    }

    @Override
    public String toString() {
        return "Название квеста: " + name_quest + ". Верных ответов: " + correct_answer + ". Неверных ответов: " + incorrect_answer+".";
    }

    public String getName_quest() {
        return name_quest;
    }

    public void setName_quest(String name_quest) {
        this.name_quest = name_quest;
    }

    public int getCorrect_answer() {
        return correct_answer;
    }

    public void setCorrect_answer(int correct_answer) {
        this.correct_answer = correct_answer;
    }

    public int getIncorrect_answer() {
        return incorrect_answer;
    }

    public void setIncorrect_answer(int incorrect_answer) {
        this.incorrect_answer = incorrect_answer;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
