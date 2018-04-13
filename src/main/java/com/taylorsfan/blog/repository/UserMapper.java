package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.User;
import com.taylorsfan.blog.vo.UserVo;

import java.util.List;
import java.util.Map;

/**
 * @author taylorsfan
 */
public interface UserMapper extends BaseMapper<User> {

    int updateByPrimaryKeyPassword2Null(Integer id);

    UserVo selectMsgByPrimaryKey(Integer id);

    List<User> selectAllFanByUserId(Integer id);

    List<User> selectAllFocusByUserId(Integer id);

    User selectOneByUsername(String username);

    User selectOneByUserNameAndPassword(Map<String, String> map);

}