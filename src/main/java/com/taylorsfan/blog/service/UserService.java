package com.taylorsfan.blog.service;

import com.taylorsfan.blog.model.User;

/**
 * @author momo
 */
public interface UserService extends BaseService<User> {

    User findOneByUsername(String username);

    User login(String username, String password);

    boolean resetPassword(int id);
}
