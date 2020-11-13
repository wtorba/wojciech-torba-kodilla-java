package com.kodilla.testing.forum;

public class ForumComment {
    private ForumPost forumPost;
    private String commentBody;
    private String author;

    public ForumComment(ForumPost forumPost, String commentBody, String author) {
        this.forumPost = forumPost;
        this.commentBody = commentBody;
        this.author = author;
    }

    public ForumPost getForumPost() {
        return forumPost;
    }

    public String getCommentBody() {
        return commentBody;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ForumComment that = (ForumComment) o;

        if (getForumPost() != null ? !getForumPost().equals(that.getForumPost()) : that.getForumPost() != null)
            return false;
        if (getCommentBody() != null ? !getCommentBody().equals(that.getCommentBody()) : that.getCommentBody() != null)
            return false;
        return getAuthor() != null ? getAuthor().equals(that.getAuthor()) : that.getAuthor() == null;
    }

    @Override
    public int hashCode() {
        int result = getForumPost() != null ? getForumPost().hashCode() : 0;
        result = 31 * result + (getCommentBody() != null ? getCommentBody().hashCode() : 0);
        result = 31 * result + (getAuthor() != null ? getAuthor().hashCode() : 0);
        return result;
    }
}
