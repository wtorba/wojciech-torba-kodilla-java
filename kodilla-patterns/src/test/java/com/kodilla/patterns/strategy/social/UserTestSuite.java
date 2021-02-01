package com.kodilla.patterns.strategy.social;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTestSuite {

    @Test
    void testDefaultSharingStrategy() {
        //Given
        User old = new Millenials("Johny Old");
        User med = new YGeneration("Bobby Med");
        User young = new ZGeneration("Ken Young");

        //When
        String oldPost = old.socialPublisher.share();
        String medPost = med.socialPublisher.share();
        String youngPost = young.socialPublisher.share();
        System.out.println("Millenials says: " + oldPost);
        System.out.println("YGeneration says: " + medPost);
        System.out.println("ZGeneration says: " + youngPost);

        //Then
        assertEquals("Facebook",oldPost);
        assertEquals("Twitter",medPost);
        assertEquals("Snapchat",youngPost);
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User modernMillenials = new Millenials("Johny Bravo");

        //When
        String modernPost = modernMillenials.sharePost();
        System.out.println("Modern first says " + modernPost);

        modernMillenials.setSocialPublisher(new SnapchatPublisher());
        modernPost = modernMillenials.sharePost();
        System.out.println("Modern then says " + modernPost);

        //Then
        assertEquals("Snapchat", modernPost);
    }
}
