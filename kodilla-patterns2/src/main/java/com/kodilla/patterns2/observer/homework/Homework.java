package com.kodilla.patterns2.observer.homework;

import com.kodilla.patterns2.observer.homework.Observable;
import com.kodilla.patterns2.observer.homework.Observer;

import java.util.ArrayList;
import java.util.List;

public class Homework implements Observable {
    private final List<Observer> mentors;
    private final List<String> homeworks;
    private final String name;

    public Homework(String name) {
        mentors = new ArrayList<>();
        homeworks = new ArrayList<>();
        this.name = name;
    }

    public void addHomework(String homework) {
        homeworks.add(homework);
        notifyObservers();
    }

    @Override
    public void registerObserver(Observer observer) {
        mentors.add(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : mentors) {
            observer.update(this);
        }
    }

    @Override
    public void removeObserver(Observer observer) {
        mentors.remove(observer);
    }

    public List<String> getHomeworks() {
        return homeworks;
    }

    public String getName() {
        return name;
    }
}