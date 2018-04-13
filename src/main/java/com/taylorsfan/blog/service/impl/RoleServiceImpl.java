package com.taylorsfan.blog.service.impl;

import com.github.pagehelper.PageInfo;
import com.taylorsfan.blog.model.Role;
import com.taylorsfan.blog.repository.RoleMapper;
import com.taylorsfan.blog.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author momo
 */
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;


    @Override
    public List<Role> findAll(Map<String, Integer> map) {
        return null;
    }

    @Override
    public boolean update(Role role) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean insert(Role role) {
        return false;
    }
}
