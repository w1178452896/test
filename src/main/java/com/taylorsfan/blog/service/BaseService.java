package com.taylorsfan.blog.service;

import java.util.List;

/**
 * @author momo
 */
public interface BaseService<T> {
    /**
     * list all <T> in pages
     * @return T's list
     */
    List<T> findAll(int pageNum, int pageSize);

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
