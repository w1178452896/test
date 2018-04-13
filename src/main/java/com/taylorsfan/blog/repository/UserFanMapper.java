package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.UserFan;

/**
 * @author taylorsfan
 */
public interface UserFanMapper extends BaseMapper<UserFan> {

    int count(String username);

}