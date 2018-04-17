package com.taylorsfan.blog.repository.relation;

import com.taylorsfan.blog.model.relation.UserRole;

/**
 * @author taylorsfan
 */
public interface UserRoleMapper extends BaseMapper<UserRole> {

    int deleteByUserId(int userId);

    int deleteByRoleId(int roleId);
}