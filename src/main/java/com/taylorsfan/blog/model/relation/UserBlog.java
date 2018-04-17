package com.taylorsfan.blog.model.relation;

/**
 * @author taylorsfan
 */
public class UserBlog {
    private Integer id;

    private Integer userId;

    private Integer blog;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBlog() {
        return blog;
    }

    public void setBlog(Integer blog) {
        this.blog = blog;
    }
}