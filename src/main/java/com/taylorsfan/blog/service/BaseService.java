package com.taylorsfan.blog.service;

import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * @author momo
 */
public interface BaseService<T> {
    /**
     * list all <T> in pages
     * @param map pageNum pageSize
     * @return T's list
     */
    List<T> findAll(Map<String, Integer> map);

    /**
     * update T
     * @param t T
     * @return true/false
     */
    boolean update(T t);

    /**
     * delete by id
     * @param id id
     * @return true/false
     */
    boolean delete(int id);
    /**
     * insert T
     * @param t T
     * @return true/false
     */
    boolean insert(T t);

}
