package com.taylorsfan.blog.controller.user;

import com.taylorsfan.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author taylorsfan
 */
@Controller
public class BlogController {
    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    /**
     * 显示文章列表
     * @param model 存到model内
     * @return url
     */
    @RequestMapping("/list/blogs")
    public String checkBlogs(Model model, int pageNum, int pageSize) {
        model.addAttribute("blogList", blogService.findAllNormal(pageNum, pageSize));
        return "list/blog";
    }


}
