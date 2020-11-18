package com.kodilla.testing.forum.statistics;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CalcStatsTestSuite {

    private static int testCounter;

    private List<String> generateUsersList(int n) {
        List<String> usersList = new ArrayList<>();
        for (int i=1;i<=n;i++) {
            usersList.add("User_"+i);
        }
        return usersList;
    }

    @Mock
    private Statistics StatisticsMock;

    @DisplayName("Test users=0, posts=0, comments=0")
    @Test
    void testCalcStats_0_0_0() {

        // Given
        CalcStats calcStats = new CalcStats();
        List<String> usersList;
        usersList = generateUsersList(0);
        when(StatisticsMock.usersNames()).thenReturn(usersList);
        when(StatisticsMock.postsCount()).thenReturn(0);
        when(StatisticsMock.commentsCount()).thenReturn(0);

        // When
        calcStats.calculateAdvStatistics(StatisticsMock);

        // Then
        assertEquals(0, calcStats.getUserCnt());
        assertEquals(0, calcStats.getPostCnt());
        assertEquals(0, calcStats.getCommCnt());
        assertNull(calcStats.getAvgCommsPerPost());
        assertNull(calcStats.getAvgPostsPerUser());
        assertNull(calcStats.getAvgCommsPerUser());
    }

    @DisplayName("Test users=0, posts=1000, comments=10 -> comments < posts")
    @Test
    void testCalcStats_0_1000_10() {

        // Given
        CalcStats calcStats = new CalcStats();
        List<String> usersList;
        usersList = generateUsersList(0);
        when(StatisticsMock.usersNames()).thenReturn(usersList);
        when(StatisticsMock.postsCount()).thenReturn(1000);
        when(StatisticsMock.commentsCount()).thenReturn(10);

        // When
        calcStats.calculateAdvStatistics(StatisticsMock);

        // Then
        assertEquals(0, calcStats.getUserCnt());
        assertEquals(1000, calcStats.getPostCnt());
        assertEquals(10, calcStats.getCommCnt());
        assertEquals(0.01, calcStats.getAvgCommsPerPost());
        assertNull(calcStats.getAvgPostsPerUser());
        assertNull(calcStats.getAvgCommsPerUser());
    }


    @DisplayName("Test users=20, posts=0, comments=800")
    @Test
    void testCalcStats_20_0_800() {

        // Given
        CalcStats calcStats = new CalcStats();
        List<String> usersList;
        usersList = generateUsersList(20);
        when(StatisticsMock.usersNames()).thenReturn(usersList);
        when(StatisticsMock.postsCount()).thenReturn(0);
        when(StatisticsMock.commentsCount()).thenReturn(800);

        // When
        calcStats.calculateAdvStatistics(StatisticsMock);

        // Then
        assertEquals(20, calcStats.getUserCnt());
        assertEquals(0, calcStats.getPostCnt());
        assertEquals(800, calcStats.getCommCnt());
        assertNull( calcStats.getAvgCommsPerPost());
        assertEquals(0.0, calcStats.getAvgPostsPerUser());
        assertEquals(40, calcStats.getAvgCommsPerUser());
    }

    @DisplayName("Test users=20, posts=400, comments=1000 -> comments > posts")
    @Test
    void testCalcStats_20_400_1000() {

        // Given
        CalcStats calcStats = new CalcStats();
        List<String> usersList;
        usersList = generateUsersList(20);
        when(StatisticsMock.usersNames()).thenReturn(usersList);
        when(StatisticsMock.postsCount()).thenReturn(400);
        when(StatisticsMock.commentsCount()).thenReturn(1000);

        // When
        calcStats.calculateAdvStatistics(StatisticsMock);

        // Then
        assertEquals(20, calcStats.getUserCnt());
        assertEquals(400, calcStats.getPostCnt());
        assertEquals(1000, calcStats.getCommCnt());
        assertEquals(2.5, calcStats.getAvgCommsPerPost());
        assertEquals(20.0, calcStats.getAvgPostsPerUser());
        assertEquals(50, calcStats.getAvgCommsPerUser());
    }

    @DisplayName("Test users=100, posts=21, comments=0")
    @Test
    void testCalcStats_100_21_0() {

        // Given
        CalcStats calcStats = new CalcStats();
        List<String> usersList;
        usersList = generateUsersList(100);
        when(StatisticsMock.usersNames()).thenReturn(usersList);
        when(StatisticsMock.postsCount()).thenReturn(21);
        when(StatisticsMock.commentsCount()).thenReturn(0);

        // When
        calcStats.calculateAdvStatistics(StatisticsMock);

        // Then
        assertEquals(100, calcStats.getUserCnt());
        assertEquals(21, calcStats.getPostCnt());
        assertEquals(0, calcStats.getCommCnt());
        assertEquals(0.0, calcStats.getAvgCommsPerPost());
        assertEquals(0.21, calcStats.getAvgPostsPerUser());
        assertEquals(0.0, calcStats.getAvgCommsPerUser());
    }
}
