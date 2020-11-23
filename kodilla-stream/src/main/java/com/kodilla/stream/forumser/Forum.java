package com.kodilla.stream.forumser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Forum {
    private final List<ForumUser> forumUsersList = new ArrayList<>();

    public Collection<ForumUser> getUserList() {
        return new ArrayList<>(forumUsersList);
    }

    public Forum() {
        forumUsersList.add(new ForumUser(1,"user1",'M', LocalDate.parse("1982-03-02"),12));
        forumUsersList.add(new ForumUser(2,"user2",'F', LocalDate.parse("1982-03-04"),8));
        forumUsersList.add(new ForumUser(3,"user3",'M', LocalDate.parse("2000-12-02"),5));
        forumUsersList.add(new ForumUser(4,"user4",'F', LocalDate.parse("2000-12-22"),4));
        forumUsersList.add(new ForumUser(5,"user5",'M', LocalDate.parse("1981-03-02"),1));
        forumUsersList.add(new ForumUser(6,"user6",'F', LocalDate.parse("1981-03-01"),1));
        forumUsersList.add(new ForumUser(7,"user7",'M', LocalDate.parse("1981-03-02"),0));
        forumUsersList.add(new ForumUser(8,"user8",'F', LocalDate.parse("1981-03-01"),0));
    }
}
