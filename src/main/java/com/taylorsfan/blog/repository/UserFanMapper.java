package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.UserFan;

/**
 * @author taylorsfan
 */
public interface UserFanMapper extends BaseMapper<UserFan> {
    int deleteByPrimaryKey(Integer id);

    int insert(UserFan record);

    int insertSelective(UserFan record);

    UserFan selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserFan record);

    int updateByPrimaryKey(UserFan record);
}