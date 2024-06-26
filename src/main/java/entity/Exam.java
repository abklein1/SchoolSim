package entity;

import entity.Boss;

import java.util.concurrent.ThreadLocalRandom;

public class Exam implements Boss {

    private final int questions;
    private final int time;
    private final int difficulty;
    private String fullName;

    public Exam(){
        this.questions = setRandom(6, 50);
        this.time = setRandom(30,130);
        this.difficulty = setRandom(30, 200);
        this.fullName = "entity.Exam";
    }


    @Override
    public void setName(String name) {
        fullName = name;
    }

    @Override
    public int getStatsNumberOfQuestions() {
        return this.questions;
    }

    @Override
    public int getStatsDifficulty() {
        return this.difficulty;
    }

    @Override
    public int getStatsTime() {
        return this.time;
    }

    @Override
    public String getName() {
        return this.fullName;
    }

    private static Integer setRandom(int min, int max) {
        int random = ThreadLocalRandom.current().nextInt(min, max + 1);
        return random;
    }


}
