package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.Permission;

/**
 * @author taylorsfan
 */
public interface PermissionMapper extends BaseMapper<Permission> {
    int deleteByPrimaryKey(Integer id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}