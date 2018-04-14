package com.taylorsfan.blog.service;

import com.taylorsfan.blog.model.User;
import com.taylorsfan.blog.vo.UserVo;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author momo
 */
public interface UserService extends BaseService<User> {
    /**
     * 根据username判断是否在user表中
     * @param username 用户名
     */
    boolean judgeHaveUserOrNot(String username);

    /**
     * login
     *
     * @return one user
     */
    User login(String username, String password);

    /**
     * reset password
     *
     * @param id user id
     * @return true/false
     */
    boolean resetPassword(int id);

    /**
     * 根据user id查询 UserVo
     */
    UserVo findMsgByUserId(int id);

    /**
     * 根据username 查询角色名
     */
    Set<String> findRoleNameList(String username);

    /**
     * 根据username查询权限名
     */
    Set<String> findPermissionNameList(String username);

    boolean changeRole(int id, int[] roleIds);
}
