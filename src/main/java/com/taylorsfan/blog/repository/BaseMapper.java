package com.taylorsfan.blog.repository;

import java.util.List;

/**
 * @author taylorsfan
 */
public interface BaseMapper<T> {

    List<T> selectAll();
}
