package com.taylorsfan.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taylorsfan.blog.model.User;
import com.taylorsfan.blog.model.UserRole;
import com.taylorsfan.blog.repository.*;
import com.taylorsfan.blog.service.UserService;
import com.taylorsfan.blog.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author momo
 */

@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;
    private final RoleMapper roleMapper;
    private final PermissionMapper permissionMapper;
    private final UserRoleMapper userRoleMapper;
    private final BlogUserMapper blogUserMapper;
    private final UserFocusMapper userFocusMapper;
    private final UserFanMapper userFanMapper;

    @Autowired
    public UserServiceImpl(UserMapper userMapper, RoleMapper roleMapper, PermissionMapper permissionMapper, UserRoleMapper userRoleMapper, BlogUserMapper blogUserMapper, UserFocusMapper userFocusMapper, UserFanMapper userFanMapper) {
        this.userMapper = userMapper;
        this.roleMapper = roleMapper;
        this.permissionMapper = permissionMapper;
        this.userRoleMapper = userRoleMapper;
        this.blogUserMapper = blogUserMapper;
        this.userFocusMapper = userFocusMapper;
        this.userFanMapper = userFanMapper;
    }

    @Override
    public boolean judgeHaveUserOrNot(String username) {
        return userMapper.selectOneByUsername(username) != null;
    }

    @Override
    public User login(String username, String password) {
        Map<String, String> map = new HashMap<>(2);
        map.put("username", username);
        map.put("password", password);
        return userMapper.selectOneByUserNameAndPassword(map);
    }

    @Override
    public boolean resetPassword(int id) {
        return userMapper.updateByPrimaryKeyPassword2Null(id) != 0;
    }

    @Override
    public UserVo findMsgByUserId(int id) {
        UserVo userVo = userMapper.selectMsgByPrimaryKey(id);
        userVo.setFocus(userFocusMapper.count(id));
        userVo.setFan(userFanMapper.count(id));
        return userVo;
    }

    @Override
    public List<User> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userMapper.selectAll();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo.getList();
    }

    @Override
    public Set<String> findRoleNameList(String username) {
        return new HashSet<>(roleMapper.selectRoleNameListByUsername(username));
    }

    @Override
    public Set<String> findPermissionNameList(String username) {
        return new HashSet<>(permissionMapper.selectPermissionNameListByUsername(username));
    }

    @Override
    public boolean changeRole(int id, int[] roleIds) {
        if (userRoleMapper.deleteByUserId(id) != 0) {
            for (int roleId : roleIds) {
                UserRole userRole = new UserRole();
                userRole.setUserId(id);
                userRole.setRoleId(roleId);
                userRoleMapper.insertSelective(userRole);
            }
        }
        return true;
    }

    @Override
    public boolean update(User user) {
        return userMapper.updateByPrimaryKey(user) != 0;
    }

    @Override
    public boolean delete(int id) {
        return userMapper.deleteByPrimaryKey(id) != 0
                && userRoleMapper.deleteByUserId(id) != 0
                && userFanMapper.deleteByUserId(id) != 0
                && userFocusMapper.deleteByUserId(id) != 0
                && blogUserMapper.deleteByUserId(id) != 0;
    }

    @Override
    public boolean insert(User user) {
        UserRole userRole = new UserRole();
        userRole.setRoleId(1);
        if (userMapper.insertSelective(user) != 0) {
            userRole.setUserId(user.getId());
            return userRoleMapper.insertSelective(userRole) != 0;
        }
        return false;
    }
}
