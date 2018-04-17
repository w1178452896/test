package com.taylorsfan.blog.repository.relation;

import com.taylorsfan.blog.model.relation.SortBlog;

/**
 * @author taylorsfan
 */
public interface SortBlogMapper extends BaseMapper<SortBlog> {

    Integer deleteByBlogId(int blogId);

    Integer deleteBySortId(int sortId);

}
