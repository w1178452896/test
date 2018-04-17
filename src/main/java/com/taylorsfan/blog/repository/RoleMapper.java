package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.Role;
import com.taylorsfan.blog.model.Sort;

import java.util.List;

/**
 * @author taylorsfan
 */
public interface RoleMapper {

    List<Role> selectAll();

    Role selectOneByPrimaryKey(Integer id);

    Integer deleteByPrimaryKey(Integer id);

    Integer insert(Role role);

    Integer updateByPrimaryKey(Role role);

    List<Role> selectAllByUserId(Integer userId);

    List<String> selectAllRoleNameByUserId(Integer userId);
}