package com.taylorsfan.blog.service;

import com.taylorsfan.blog.model.User;
import com.taylorsfan.blog.vo.UserVo;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author momo
 */
public interface UserService {
    /**
     * 后台显示所有用户
     */
    List<UserVo> showAll(Map<String, Integer> map);

    /**
     * 删除
     */
    boolean delete(int userId);

    /**
     * 更新
     */
    boolean update(User user);

    /**
     * 根据username判断是否在user表中
     */
    boolean judgeHaveUserOrNot(String username);

    /**
     * 登陆
     */
    User login(String username, String password);

    /**
     * 重置密码
     */
    boolean resetPassword(int userId);

    /**
     * 根据username 查询角色名
     */
    Set<String> findRoleNameList(int userId);

    /**
     * 根据username查询权限名
     */
    Set<String> findPermissionNameList(int userId);

    boolean changeRole(int userId, int[] roleIds);

    /**
     * 根据文章id查询user
     */
    UserVo showUserByBlogId(int blogId);

    /**
     * 根据评论id查询user
     */
    UserVo showUserByCommentId(int commentId);

    /**
     * 根据用户id查询用户
     */
    UserVo showUserVoByUserId(int userId);

    User showUserByUserId(int userId);

    boolean insert(User user);

}
