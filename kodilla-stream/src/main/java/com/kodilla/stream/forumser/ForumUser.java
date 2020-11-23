package com.kodilla.stream.forumser;

import java.time.LocalDate;

public final class ForumUser {
    private final int userId;
    private final String userName;
    private final char userGender;
    private final LocalDate birthDate;
    private final int postQty;

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public char getUserGender() {
        return userGender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public int getPostQty() {
        return postQty;
    }

    public ForumUser(final int userId, final String userName, final char userGender, final LocalDate birthDate, final int postQty) {
        this.userId = userId;
        this.userName = userName;
        this.userGender = userGender;
        this.birthDate = birthDate;
        this.postQty = postQty;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userId=" + userId +
                ", userName='" + userName +
                ", userGender=" + userGender +
                ", birthDate=" + birthDate +
                ", postQty=" + postQty +
                '}';
    }
}
