package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.Sort;

/**
 * @author taylorsfan
 */
public interface SortMapper extends BaseMapper<Sort> {

    int deleteByPrimaryKey(Integer id);

    int insert(Sort record);

    int insertSelective(Sort record);

    Sort selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sort record);

    int updateByPrimaryKey(Sort record);
}