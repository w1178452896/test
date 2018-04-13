package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.UserFocus;

/**
 * @author taylorsfan
 */
public interface UserFocusMapper extends BaseMapper<UserFocus> {

    int count(String username);

}