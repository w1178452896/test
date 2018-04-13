package com.taylorsfan.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taylorsfan.blog.model.User;
import com.taylorsfan.blog.repository.UserMapper;
import com.taylorsfan.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author momo
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(Map<String, String> map) {
        return userMapper.selectOneByUserNameAndPassword(map);
    }

    @Override
    public boolean resetPassword(int id) {
        return userMapper.updateByPrimaryKeyPassword2Null(id) != 0;
    }

    @Override
    public List<User> findAll(Map<String, Integer> map) {
        PageHelper.startPage(map.get("pageNum"), map.get("pageSize"));
        List<User> userList = userMapper.selectAll();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo.getList();
    }

    @Override
    public List<User> findAllFan(Map<String, Integer> map) {
        PageHelper.startPage(map.get("pageNum"), map.get("pageSize"));
        List<User> userList = userMapper.selectAllFanByUserId(map.get("id"));
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo.getList();
    }

    @Override
    public List<User> findAllFocus(Map<String, Integer> map) {
        PageHelper.startPage(map.get("pageNum"), map.get("pageSize"));
        List<User> userList = userMapper.selectAllFocusByUserId(map.get("id"));
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        return pageInfo.getList();
    }

    @Override
    public boolean judgeHaveUserOrNot(String username) {
        return userMapper.selectOneByUsername(username) != null;
    }

    @Override
    public boolean update(User user) {
        return userMapper.updateByPrimaryKey(user) != 0;
    }

    @Override
    public boolean delete(int id) {
        return userMapper.deleteByPrimaryKey(id) != 0;
    }

    @Override
    public boolean insert(User user) {
        return userMapper.insertSelective(user) != 0;
    }
}
