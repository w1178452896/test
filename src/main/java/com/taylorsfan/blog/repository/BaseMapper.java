package com.taylorsfan.blog.repository;

/**
 * @author taylorsfan
 */
public interface BaseMapper<T> {

    Integer insert(T t);

    Integer count(Integer id);
}
