package com.taylorsfan.blog.service.impl;

import com.github.pagehelper.PageHelper;
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

    private final RoleMapper roleMapper;

    @Autowired
    public RoleServiceImpl(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    @Override
    public List<Role> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(roleMapper.selectAll()).getList();
    }

    @Override
    public boolean update(Role role) {
        return roleMapper.updateByPrimaryKey(role) != 0;
    }

    @Override
    public boolean delete(int id) {
        return roleMapper.deleteByPrimaryKey(id) != 0;
    }

    @Override
    public boolean insert(Role role) {
        return roleMapper.insertSelective(role) != 0;
    }
}
