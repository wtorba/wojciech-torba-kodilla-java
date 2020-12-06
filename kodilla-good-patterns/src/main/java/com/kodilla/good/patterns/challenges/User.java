package com.kodilla.good.patterns.challenges;

public class User {
    private String firstname;
    private String surname;

    public User(String firstname, String surname) {
        this.firstname = firstname;
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }
}
