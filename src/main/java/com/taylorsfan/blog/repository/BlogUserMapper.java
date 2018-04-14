package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.BlogUser;

/**
 * @author taylorsfan
 */
public interface BlogUserMapper extends BaseMapper<BlogUser>{

    int deleteByUserId(int userId);
}