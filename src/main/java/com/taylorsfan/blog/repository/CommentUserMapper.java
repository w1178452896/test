package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.relation.CommentUser;

/**
 * @author taylorsfan
 */
public interface CommentUserMapper extends BaseMapper<CommentUser> {

    Integer deleteByUserId(Integer userId);

    Integer deleteByCommentId(Integer commentId);

}