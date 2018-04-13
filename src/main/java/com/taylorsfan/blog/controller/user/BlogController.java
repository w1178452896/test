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
    @Autowired
    private BlogService blogService;

    /**
     * 显示文章列表
     * @param model 存到model内
     * @param map pageNum,pageSize,status
     * @return url
     */
    @RequestMapping("/list/blogs")
    public String checkBlogs(Model model, Map<String, Integer> map) {
        model.addAttribute("blogList", blogService.findAll(map));
        return "list/blog";
    }
}
