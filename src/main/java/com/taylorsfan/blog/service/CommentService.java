package com.taylorsfan.blog.service;

import com.taylorsfan.blog.model.Blog;
import com.taylorsfan.blog.vo.CommentVo;

import java.util.List;
import java.util.Map;

/**
 * @author taylorsfan
 */
public interface CommentService {

    List<CommentVo> showAll(Map<String, Integer> map);

    /**
     * 新建评论
     */
    boolean insert(CommentVo commentVo);

    /**
     * 根据commentId删除评论
     */
    boolean deleteByCommentId(int commentId);

    /**
     * 根据userId删除comment
     */
    boolean deleteByUserId(int userId);

    /**
     * 根据blogId删除comment
     */
    boolean deleteByBlogId(int blogId);

}
