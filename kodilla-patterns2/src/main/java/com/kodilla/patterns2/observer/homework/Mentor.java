package com.kodilla.patterns2.observer.homework;

public class Mentor implements Observer {
    private final String mentor;
    private int updateCount;

    public Mentor(String mentor) {
        this.mentor = mentor;
    }

    @Override
    public void update(Homework homework) {
        System.out.println(mentor + ": New homework from " + homework.getName() + "\n" +
                " (total: " + homework.getHomeworks().size() + " homeworks)");
        updateCount++;
    }

    public String getMentor() {
        return mentor;
    }

    public int getUpdateCount() {
        return updateCount;
    }
}

