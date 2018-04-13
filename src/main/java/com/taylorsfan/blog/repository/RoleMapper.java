package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.Role;

import java.util.List;

/**
 * @author taylorsfan
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<String> selectRoleNameListByUsername(String username);

}