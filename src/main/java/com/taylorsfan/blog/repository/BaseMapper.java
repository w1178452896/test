package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.User;

import java.util.List;
import java.util.Map;

/**
 * @author taylorsfan
 */
public interface BaseMapper<T> {

    List<T> selectAll();

    T selectByPrimaryKey(Integer id);

    int deleteByPrimaryKey(Integer id);

    int insertSelective(T t);

    int updateByPrimaryKey(T t);


}

