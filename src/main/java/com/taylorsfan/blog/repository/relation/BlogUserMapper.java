package com.taylorsfan.blog.repository.relation;

import com.taylorsfan.blog.model.relation.BlogUser;

import java.util.List;

/**
 * @author taylorsfan
 */
public interface BlogUserMapper extends BaseMapper<BlogUser> {

    Integer deleteByUserId(Integer userId);

    Integer deleteByBlogId(Integer blogId);

    List<BlogUser> selectAllByBlogId(int blogId);
}