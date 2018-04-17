package com.taylorsfan.blog.repository.relation;

import com.taylorsfan.blog.model.relation.UserComment;

/**
 * @author taylorsfan
 */
public interface UserCommentMapper extends BaseMapper<UserComment> {

    Integer deleteByUserId(int userId);

    Integer deleteByCommentId(int commentId);
}