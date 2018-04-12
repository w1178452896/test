package com.taylorsfan.blog.controller.admin;

import com.taylorsfan.blog.model.Blog;
import com.taylorsfan.blog.service.BlogService;
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
@RequestMapping("/admin/blog")
public class DoBlogController implements DoBaseController<Blog> {
    @Autowired
    private BlogService blogService;

    @Override
    public String findAll(Model model, @RequestBody int pageNum, @RequestBody int pageSize) {
        return null;
    }

    @Override
    public ResultUtil insert(Blog blog) {
        return null;
    }

    @Override
    public ResultUtil update(Blog blog) {
        return null;
    }

    @Override
    public ResultUtil delete(int id) {
        return null;
    }
}
