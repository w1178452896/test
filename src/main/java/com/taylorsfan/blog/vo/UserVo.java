package com.taylorsfan.blog.vo;

import com.taylorsfan.blog.model.Blog;
import com.taylorsfan.blog.model.Comment;
import com.taylorsfan.blog.model.User;

import java.util.List;


/**
 * @author taylorsfan
 */

public class UserVo extends User {
    private int focus;
    private int fan;
    private List<String> roleNameList;
    private List<String> permissionNameList;
    private List<User> focusList;
    private List<User> fanList;
    private List<Blog> blogList;
    private List<Comment> commentList;

    public int getFocus() {
        return focus;
    }

    public void setFocus(int focus) {
        this.focus = focus;
    }

    public int getFan() {
        return fan;
    }

    public void setFan(int fan) {
        this.fan = fan;
    }

    public List<String> getRoleNameList() {
        return roleNameList;
    }

    public void setRoleNameList(List<String> roleNameList) {
        this.roleNameList = roleNameList;
    }

    public List<String> getPermissionNameList() {
        return permissionNameList;
    }

    public void setPermissionNameList(List<String> permissionNameList) {
        this.permissionNameList = permissionNameList;
    }

    public List<User> getFocusList() {
        return focusList;
    }

    public void setFocusList(List<User> focusList) {
        this.focusList = focusList;
    }

    public List<User> getFanList() {
        return fanList;
    }

    public void setFanList(List<User> fanList) {
        this.fanList = fanList;
    }

    public List<Blog> getBlogList() {
        return blogList;
    }

    public void setBlogList(List<Blog> blogList) {
        this.blogList = blogList;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }
}
