package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.UserRole;

/**
 * @author taylorsfan
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {
    int deleteByPrimaryKey(Integer id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);
}