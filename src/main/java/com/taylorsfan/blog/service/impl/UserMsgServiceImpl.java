package com.taylorsfan.blog.service.impl;

import com.taylorsfan.blog.repository.PermissionMapper;
import com.taylorsfan.blog.repository.RoleMapper;
import com.taylorsfan.blog.repository.UserMapper;
import com.taylorsfan.blog.service.UserMsgService;
import com.taylorsfan.blog.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author taylorsfan
 * 用户个人信息
 */
@Service
public class UserMsgServiceImpl implements UserMsgService {

    private final RoleMapper roleMapper;
    private final PermissionMapper permissionMapper;
    private final UserMapper userMapper;

    @Autowired
    public UserMsgServiceImpl(RoleMapper roleMapper, PermissionMapper permissionMapper, UserMapper userMapper) {
        this.roleMapper = roleMapper;
        this.permissionMapper = permissionMapper;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserVo> findFanMsgByUserId(int id) {
        return null;
    }

    @Override
    public List<UserVo> findFocusMsgByUserId(int id) {
        return null;
    }

    @Override
    public UserVo findMsgByUserId(int id) {
        return userMapper.selectMsgByPrimaryKey(id);
    }

    @Override
    public Set<String> findRoleNameList(String username) {
        return new HashSet<>(roleMapper.selectRoleNameListByUsername(username));
    }

    @Override
    public Set<String> findPermissionNameList(String username) {
        return new HashSet<>(permissionMapper.selectPermissionNameListByUsername(username));
    }

}
