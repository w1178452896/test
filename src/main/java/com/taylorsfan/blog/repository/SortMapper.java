package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.Sort;

import java.util.List;

/**
 * @author taylorsfan
 */
public interface SortMapper {

    List<Sort> selectAll();

    Sort selectOneByPrimaryKey(Integer id);

    Integer deleteByPrimaryKey(Integer id);

    Integer insert(Sort sort);

    Integer updateByPrimaryKey(Sort sort);

    Sort selectOneByBlogId(int blogId);
}