package com.kodilla.stream;

import com.kodilla.stream.forumser.Forum;
import com.kodilla.stream.forumser.ForumUser;
import java.time.LocalDate;
import java.time.Period;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {
        Forum forum = new Forum();
        Map<Integer, Object> resultForumUserList = forum.getUserList().stream()
                .filter(forumUser -> forumUser.getUserGender() == 'M')
                .filter(forumUser -> forumUser.getPostQty() > 0)
                .filter(forumUser ->  Period.between(forumUser.getBirthDate(), LocalDate.now()).getYears() >= 20)
                .collect(Collectors.toMap(ForumUser::getUserId, forumUser -> forumUser));

        resultForumUserList.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

    }
}