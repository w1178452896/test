package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.Comment;

import java.util.List;

/**
 * @author taylorsfan
 */
public interface CommentMapper extends BaseMapper<Comment> {
    List<Comment> selectAllByUserId(Integer userId);
}