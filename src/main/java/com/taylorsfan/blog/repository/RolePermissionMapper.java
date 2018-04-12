package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.RolePermission;

/**
 * @author taylorsfan
 */
public interface RolePermissionMapper extends BaseMapper<RolePermission> {
    int deleteByPrimaryKey(Integer id);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);
}