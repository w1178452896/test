package com.taylorsfan.blog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taylorsfan.blog.model.User;
import com.taylorsfan.blog.repository.UserMapper;
import com.taylorsfan.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
    public User findOneByUsername(String username) {
        return null;
    }

    @Override
    public User login(String username, String password) {
        return null;
    }

    @Override
    public boolean resetPassword(int id) {
        return false;
    }

    @Override
    public List<User> findAll(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public User findOneById(int id) {
        return null;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean insert(User user) {
        return false;
    }
}
