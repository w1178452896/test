package com.taylorsfan.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taylorsfan.blog.model.Blog;
import com.taylorsfan.blog.repository.BlogMapper;
import com.taylorsfan.blog.repository.BlogUserMapper;
import com.taylorsfan.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author taylorsfan
 */
@Service
public class BlogServiceImpl implements BlogService {

    private final BlogMapper blogMapper;
    private final BlogUserMapper blogUserMapper;

    @Autowired
    public BlogServiceImpl(BlogMapper blogMapper, BlogUserMapper blogUserMapper) {
        this.blogMapper = blogMapper;
        this.blogUserMapper = blogUserMapper;
    }

    @Override
    public List<Blog> findAll(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(blogMapper.selectAll()).getList();
    }

    @Override
    public List<Blog> findAllNormal(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(blogMapper.selectAllByStatus(1)).getList();
    }

    @Override
    public List<Blog> findAllNeedChecked(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return new PageInfo<>(blogMapper.selectAllByStatus(2)).getList();
    }

    @Override
    public boolean update(Blog blog) {
        return blogMapper.updateByPrimaryKey(blog) != 0;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean insert(Blog blog) {
        return false;
    }

}
