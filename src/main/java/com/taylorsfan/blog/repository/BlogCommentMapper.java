package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.relation.BlogComment;

import java.util.List;

/**
 * @author taylorsfan
 */
public interface BlogCommentMapper extends BaseMapper<BlogComment> {

    Integer deleteByBlogId(Integer blogId);

    List<BlogComment> selectAllByBlogId(int blogId);
}