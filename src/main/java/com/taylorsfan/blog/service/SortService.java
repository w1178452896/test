package com.taylorsfan.blog.service;

import com.taylorsfan.blog.model.Sort;

import java.util.List;

/**
 * @author taylorsfan
 */
public interface SortService {
    List<Sort> showAll(int pageNum, int pageSize);

    boolean update(Sort sort);

    boolean delete(int id);

    boolean insert(Sort sort);

}
