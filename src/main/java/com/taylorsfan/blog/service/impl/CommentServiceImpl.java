package com.taylorsfan.blog.service.impl;

import com.taylorsfan.blog.model.Comment;
import com.taylorsfan.blog.repository.CommentMapper;
import com.taylorsfan.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author taylorsfan
 */
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;

    @Autowired
    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }


    @Override
    public List<Comment> findAll(int pageNum, int pageSize) {
        return null;
    }

    @Override
    public boolean update(Comment comment) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }

    @Override
    public boolean insert(Comment comment) {
        return false;
    }
}
