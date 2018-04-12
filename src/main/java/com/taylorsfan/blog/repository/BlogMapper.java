package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.Blog;

/**
 * @author taylorsfan
 */
public interface BlogMapper extends BaseMapper<Blog> {
    int deleteByPrimaryKey(Integer id);

    int insert(Blog record);

    int insertSelective(Blog record);

    Blog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Blog record);

    int updateByPrimaryKey(Blog record);
}