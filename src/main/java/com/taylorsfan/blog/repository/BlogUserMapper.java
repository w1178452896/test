package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.BlogUser;

/**
 * @author taylorsfan
 */
public interface BlogUserMapper extends BaseMapper<BlogUser> {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogUser record);

    int insertSelective(BlogUser record);

    BlogUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogUser record);

    int updateByPrimaryKey(BlogUser record);
}