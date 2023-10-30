package com.javarush.quest.burcev.models;

public class Quest {

    private String name_quest;
    private int correct_answer;
    private int incorrect_answer;

    public Quest(String name_quest, int correct_answer, int incorrect_answer) {
        this.name_quest = name_quest;
        this.correct_answer = correct_answer;
        this.incorrect_answer = incorrect_answer;
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


}
