package com.taylorsfan.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taylorsfan.blog.model.Sort;
import com.taylorsfan.blog.repository.SortMapper;
import com.taylorsfan.blog.service.SortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author taylorsfan
 */
@Service
public class SortServiceImpl implements SortService {
    @Autowired
    private SortMapper sortMapper;


    @Override
    public List<Sort> showAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Sort> sortList = sortMapper.selectAll();
        PageInfo<Sort> pageInfo = new PageInfo<>(sortList);
        return pageInfo.getList();
    }

    @Override
    public boolean update(Sort sort) {
        return sortMapper.updateByPrimaryKey(sort) != 0;
    }

    @Override
    public boolean delete(int id) {
        return sortMapper.deleteByPrimaryKey(id) != 0;
    }

    @Override
    public boolean insert(Sort sort) {
        return sortMapper.insert(sort) != 0;
    }
}
