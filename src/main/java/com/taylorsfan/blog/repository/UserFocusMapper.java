package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.UserFocus;

/**
 * @author taylorsfan
 */
public interface UserFocusMapper extends BaseMapper<UserFocus> {
    int deleteByPrimaryKey(Integer id);

    int insert(UserFocus record);

    int insertSelective(UserFocus record);

    UserFocus selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserFocus record);

    int updateByPrimaryKey(UserFocus record);
}