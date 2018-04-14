package com.taylorsfan.blog.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taylorsfan.blog.model.Sort;
import com.taylorsfan.blog.repository.SortMapper;
import com.taylorsfan.blog.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author taylorsfan
 */
@Service
public class SortServiceImpl implements SortService {

    private final SortMapper sortMapper;

    @Autowired
    public SortServiceImpl(SortMapper sortMapper) {
        this.sortMapper = sortMapper;
    }


    @Override
    public List<Sort> findAll(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public boolean update(Sort sort) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean insert(Sort sort) {
        return false;
    }
}
