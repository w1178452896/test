package com.taylorsfan.blog.repository.relation;

import com.taylorsfan.blog.model.relation.UserFocus;

/**
 * @author taylorsfan
 */
public interface UserFocusMapper extends BaseMapper<UserFocus> {


    int deleteByUserId(int userId);

    int deleteByFocusId(int focusId);
}