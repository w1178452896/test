package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.BlogSort;

/**
 * @author taylorsfan
 */
public interface BlogSortMapper extends BaseMapper<BlogSort> {
    int deleteByPrimaryKey(Integer id);

    int insert(BlogSort record);

    int insertSelective(BlogSort record);

    BlogSort selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BlogSort record);

    int updateByPrimaryKey(BlogSort record);
}