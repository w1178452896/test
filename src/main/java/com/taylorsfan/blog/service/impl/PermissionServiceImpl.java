package com.taylorsfan.blog.service.impl;

import com.github.pagehelper.PageInfo;
import com.taylorsfan.blog.model.Permission;
import com.taylorsfan.blog.repository.PermissionMapper;
import com.taylorsfan.blog.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author taylorsfan
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;


    @Override
    public List<Permission> findAll(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public Permission findOneById(int id) {
        return null;
    }

    @Override
    public boolean update(Permission permission) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean insert(Permission permission) {
        return false;
    }
}
