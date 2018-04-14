package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.Blog;

import java.util.List;

/**
 * @author taylorsfan
 */
public interface BlogMapper extends BaseMapper<Blog> {

    List<Blog> selectAllByUserId(Integer userId);

    List<Blog> selectAllByStatus(Integer status);
}