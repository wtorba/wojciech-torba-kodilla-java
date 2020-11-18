package com.kodilla.testing.forum.statistics;

public class CalcStats {
    private int userCnt;
    private int postCnt;
    private int commCnt;
    private Double avgPostsPerUser;
    private Double avgCommsPerUser;
    private Double avgCommsPerPost;

    public void calculateAdvStatistics(Statistics statistics) {
        userCnt = statistics.usersNames().size();
        postCnt = statistics.postsCount();
        commCnt = statistics.commentsCount();
        if (userCnt > 0) {
            avgPostsPerUser = (double) postCnt / (double) userCnt;
            avgCommsPerUser = (double) commCnt / (double) userCnt;
        }
        if (postCnt > 0) {
            avgCommsPerPost = (double) commCnt / (double) postCnt;
        }
    }

    public int getUserCnt() {
        return userCnt;
    }

    public int getPostCnt() {
        return postCnt;
    }

    public int getCommCnt() {
        return commCnt;
    }

    public Double getAvgPostsPerUser() {
        return avgPostsPerUser;
    }

    public Double getAvgCommsPerUser() {
        return avgCommsPerUser;
    }

    public Double getAvgCommsPerPost() {
        return avgCommsPerPost;
    }
}
