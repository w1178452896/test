package com.taylorsfan.blog.service.impl;

import com.taylorsfan.blog.model.BlogComment;
import com.taylorsfan.blog.service.BlogCommentService;

import java.util.List;
import java.util.Map;

/**
 * @author taylorsfan
 */
public class BlogCommentServiceImpl implements BlogCommentService {
    @Override
    public List<BlogComment> findAll(Map<String, Integer> map) {
        return null;
    }

    @Override
    public boolean update(BlogComment blogComment) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean insert(BlogComment blogComment) {
        return false;
    }
}
