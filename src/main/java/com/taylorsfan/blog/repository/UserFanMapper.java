package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.relation.UserFan;

/**
 * @author taylorsfan
 */
public interface UserFanMapper extends BaseMapper<UserFan> {


    int deleteByUserId(int userId);

    int deleteByFanId(int fanId);
}