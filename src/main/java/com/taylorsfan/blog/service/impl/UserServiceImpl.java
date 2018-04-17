package com.taylorsfan.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taylorsfan.blog.model.User;
import com.taylorsfan.blog.model.relation.UserRole;
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
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private PermissionMapper permissionMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private BlogUserMapper blogUserMapper;
    @Autowired
    private UserFocusMapper userFocusMapper;
    @Autowired
    private UserFanMapper userFanMapper;
    @Autowired
    private UserBlogMapper userBlogMapper;


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
    public List<UserVo> showAll(Map<String, Integer> map) {
        PageHelper.startPage(map.get("pageNum"), map.get("pageSize"));
        List<User> userList = userMapper.selectAll();
        List<UserVo> userVoList = new ArrayList<>();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        for (User user : pageInfo.getList()) {
            UserVo userVo = new UserVo();
            userVo.setUser(user);
            userVo.setFanCount(userFanMapper.count(user.getId()));
            userVo.setFocusCount(userFocusMapper.count(user.getId()));
            userVo.setBlogCount(userBlogMapper.count(user.getId()));
            userVoList.add(userVo);
        }
        return userVoList;
    }

    @Override
    public Set<String> findRoleNameList(int userId) {
        return new HashSet<>(roleMapper.selectAllRoleNameByUserId(userId));
    }

    @Override
    public Set<String> findPermissionNameList(int userId) {
        return new HashSet<>(permissionMapper.selectAllByUserId(userId));
    }

    @Override
    public boolean changeRole(int id, int[] roleIds) {
        if (userRoleMapper.deleteByUserId(id) != 0) {
            for (int roleId : roleIds) {
                UserRole userRole = new UserRole();
                userRole.setUserId(id);
                userRole.setRoleId(roleId);
                userRoleMapper.insert(userRole);
            }
        }
        return true;
    }

    @Override
    public UserVo showUserByBlogId(int blogId) {
        UserVo userVo = new UserVo();
        User user = userMapper.selectOneByBlogId(blogId);
        userVo.setUser(user);
        userVo.setFanCount(userFanMapper.count(user.getId()));
        userVo.setFocusCount(userFocusMapper.count(user.getId()));
        userVo.setBlogCount(userBlogMapper.count(user.getId()));
        return userVo;
    }

    @Override
    public UserVo showUserByCommentId(int commentId) {
        UserVo userVo = new UserVo();
        User user = userMapper.selectOneByCommentId(commentId);
        userVo.setUser(user);
        userVo.setFanCount(userFanMapper.count(user.getId()));
        userVo.setFocusCount(userFocusMapper.count(user.getId()));
        userVo.setBlogCount(userBlogMapper.count(user.getId()));
        return userVo;
    }

    @Override
    public UserVo showUserVoByUserId(int userId) {
        UserVo userVo = new UserVo();
        User user = userMapper.selectOneByPrimaryKey(userId);
        userVo.setUser(user);
        userVo.setFanCount(userFanMapper.count(user.getId()));
        userVo.setFocusCount(userFocusMapper.count(user.getId()));
        userVo.setBlogCount(userBlogMapper.count(user.getId()));
        return userVo;
    }

    @Override
    public User showUserByUserId(int userId) {
        return userMapper.selectOneByPrimaryKey(userId);
    }

    @Override
    public boolean insert(User user) {
        if (userMapper.insert(user) != 0) {
            UserRole userRole = new UserRole();
            userRole.setRoleId(1);
            userRole.setUserId(user.getId());
            return userRoleMapper.insert(userRole) != 0;
        }
        return false;
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

}
