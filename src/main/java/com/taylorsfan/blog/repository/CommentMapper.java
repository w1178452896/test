package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.Comment;

/**
 * @author taylorsfan
 */
public interface CommentMapper extends BaseMapper<Comment> {
    int deleteByPrimaryKey(Integer id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
}