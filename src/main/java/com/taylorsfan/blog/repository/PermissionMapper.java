package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.Permission;

import java.util.List;

/**
 * @author taylorsfan
 */
public interface PermissionMapper extends BaseMapper<Permission> {
    List<String> selectPermissionNameListByUsername(String username);


}