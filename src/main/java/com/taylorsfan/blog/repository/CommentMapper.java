package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.Comment;

import java.util.List;

/**
 * @author taylorsfan
 */
public interface CommentMapper {

    List<Comment> selectAll();

    Comment selectOneByPrimaryKey(Integer id);

    Integer insert(Comment comment);

    /**
     * 根据用户id查询
     */
    List<Comment> selectAllByUserId(Integer userId);

    /**
     * 根据文章id查询
     */
    List<Comment> selectAllByBlogId(Integer blogId);

    List<Comment> selectAllByCommentId(Integer commentId);

    /**
     * 根据文章id删除
     */
    Integer deleteByBlogId(Integer blogId);

    /**
     * 根据用户id更新
     */
    Integer updateByUserId(Integer userId);

    /**
     * 根据评论id更新
     */
    Integer updateByCommentId(Integer commentId);
}