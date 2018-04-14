package com.taylorsfan.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taylorsfan.blog.model.Permission;
import com.taylorsfan.blog.repository.PermissionMapper;
import com.taylorsfan.blog.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author taylorsfan
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    private final PermissionMapper permissionMapper;

    @Autowired
    public PermissionServiceImpl(PermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }


    @Override
    public List<Permission> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(permissionMapper.selectAll()).getList();
    }

    @Override
    public boolean update(Permission permission) {
        return permissionMapper.updateByPrimaryKey(permission) != 0;
    }

    @Override
    public boolean delete(int id) {
        return permissionMapper.deleteByPrimaryKey(id) != 0;
    }

    @Override
    public boolean insert(Permission permission) {
        return permissionMapper.insertSelective(permission) != 0;
    }
}
