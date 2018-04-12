package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.BlogComment;

/**
 * @author taylorsfan
 */
public interface BlogCommentMapper extends BaseMapper<BlogComment> {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogComment record);

    int insertSelective(BlogComment record);

    BlogComment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogComment record);

    int updateByPrimaryKey(BlogComment record);
}