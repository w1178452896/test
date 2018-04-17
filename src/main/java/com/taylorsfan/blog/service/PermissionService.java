package com.taylorsfan.blog.service;

import com.taylorsfan.blog.model.Permission;

import java.util.List;

/**
 * @author taylorsfan
 */
public interface PermissionService {

    List<Permission> showAll(Integer pageNum, Integer pageSize);

    boolean update(Permission permission);

    boolean delete(Integer id);

    boolean insert(Permission permission);
}
