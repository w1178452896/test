package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.Role;

/**
 * @author taylorsfan
 */
public interface RoleMapper extends BaseMapper<Role> {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}