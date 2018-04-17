package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.User;
import com.taylorsfan.blog.vo.UserVo;

import java.util.List;
import java.util.Map;

/**
 * @author taylorsfan
 */
public interface UserMapper {

    List<User> selectAll();

    User selectOneByPrimaryKey(Integer id);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int updateByPrimaryKey(User record);

    /**
     * 根据粉丝id查找用户
     */
    List<User> selectAllByFanId(int fanId);

    /**
     * 根据关注者id查用户
     */
    List<User> selectAllByFocusId(int focusId);

    /**
     * 根据文章id查用户
     */
    User selectOneByBlogId(int blogId);

    /**
     * 根据评论id查用户
     */
    User selectOneByCommentId(int commentId);

    /**
     * 重置密码
     */
    int updateByPrimaryKeyPassword2Null(Integer id);

    /**
     * 根据用户名查询用户
     */
    User selectOneByUsername(String username);

    /**
     * FIXME
     * 根据用户名和密码查询
     */
    User selectOneByUserNameAndPassword(Map<String, String> map);

}