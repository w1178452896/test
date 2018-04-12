package com.taylorsfan.blog.service;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @author momo
 */
public interface BaseService<T> {

    List<T> findAll(int pageNum, int pageSize);

    T findOneById(int id);

    boolean update(T t);

    boolean delete(int id);

    boolean insert(T t);

}
