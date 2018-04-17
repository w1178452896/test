package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.relation.UserBlog;

/**
 * @author taylorsfan
 */
public interface UserBlogMapper extends BaseMapper<UserBlog> {

    Integer deleteByUserId(Integer userId);

    Integer deleteByBlogId(Integer blogId);
}