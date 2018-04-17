package com.taylorsfan.blog.vo;


import com.taylorsfan.blog.model.Blog;
import com.taylorsfan.blog.model.Comment;
import com.taylorsfan.blog.model.User;


/**
 * @author momo
 */
public class CommentVo {
    private Blog blog;
    private Comment comment;
    /**
     * 对应用户
     */
    private User commentUser;
    /**
     * 评论的对象
     */
    private User beCommentedUser;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public User getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(User commentUser) {
        this.commentUser = commentUser;
    }

    public User getBeCommentedUser() {
        return beCommentedUser;
    }

    public void setBeCommentedUser(User beCommentedUser) {
        this.beCommentedUser = beCommentedUser;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
