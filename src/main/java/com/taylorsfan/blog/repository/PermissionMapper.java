package com.taylorsfan.blog.repository;

import com.github.pagehelper.PageInfo;
import com.taylorsfan.blog.model.Permission;
import com.taylorsfan.blog.model.Permission;
import com.taylorsfan.blog.model.Sort;

import java.util.List;

/**
 * @author taylorsfan
 */
public interface PermissionMapper {

    List<Permission> selectAll();

    Permission selectOneByPrimaryKey(Integer id);

    Integer deleteByPrimaryKey(Integer id);

    Integer insert(Permission permission);

    Integer updateByPrimaryKey(Permission permission);

    List<Permission> selectAllByRoleId(int permissionId);

    List<String> selectAllByUserId(int userId);
}