package com.taylorsfan.blog.repository.relation;

import com.taylorsfan.blog.model.relation.RolePermission;

/**
 * @author taylorsfan
 */
public interface RolePermissionMapper extends BaseMapper<RolePermission> {

    Integer deleteByRoleId(int roleId);

    Integer deleteByPermissionId(int permissionId);
}