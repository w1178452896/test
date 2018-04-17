package com.taylorsfan.blog.repository.relation;

/**
 * @author taylorsfan
 */
public interface BaseMapper<T> {

    Integer insert(T t);

    Integer count(Integer id);
}
