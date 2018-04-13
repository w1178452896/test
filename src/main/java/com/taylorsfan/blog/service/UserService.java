package com.taylorsfan.blog.service;

import com.taylorsfan.blog.model.User;

import java.util.List;
import java.util.Map;

/**
 * @author momo
 */
public interface UserService extends BaseService<User> {
    /**
     * list all fans(as user)
     *
     * @param map contains pageSize pageNum id
     * @return user's list
     */
    List<User> findAllFan(Map<String, Integer> map);

    /**
     * list all focus(as user)
     *
     * @param map contains pageSize pageNum id
     * @return user's list
     */
    List<User> findAllFocus(Map<String, Integer> map);

    boolean judgeHaveUserOrNot(String username);
    /**
     * login
     *
     * @param map contains username and password
     * @return one user
     */
    User login(Map<String, String> map);

    /**
     * reset password
     *
     * @param id user id
     * @return true/false
     */
    boolean resetPassword(int id);
}
