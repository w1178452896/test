package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.User;

/**
 * @author taylorsfan
 */
public interface UserMapper extends BaseMapper<User> {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}