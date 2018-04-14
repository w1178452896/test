package com.taylorsfan.blog.controller.admin;

import com.taylorsfan.blog.model.Comment;
import com.taylorsfan.blog.service.CommentService;
import com.taylorsfan.blog.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author taylorsfan
 */
@Controller
@RequestMapping("/admin/comment")
public class DoCommentController implements DoBaseController<Comment> {
    private final CommentService commentService;

    @Autowired
    public DoCommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @Override
    public String findAll(Model model, @RequestBody int pageNum, @RequestBody int pageSize) {
        return null;
    }

    @Override
    public ResultUtil insert(Comment comment) {
        return null;
    }

    @Override
    public ResultUtil update(Comment comment) {
        return null;
    }

    @Override
    public ResultUtil delete(int id) {
        return null;
    }
}
