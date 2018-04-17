package com.taylorsfan.blog.controller;

import com.taylorsfan.blog.service.BlogService;
import com.taylorsfan.blog.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * @author taylorsfan
 * 个人主页的blogList，以及blog
 */
@RequestMapping("/blog")
@Controller
public class BlogController {
    private final BlogService blogService;

    @Autowired
    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    /**
     * 有userId 则显示用户的blogVoList
     * 无userId则为首页的blogVoList
     */
    @RequestMapping("/list/blogVos")
    public String blogVoListMe(Model model, Integer userId, Integer pageNum, Integer pageSize, Integer status) {
        Map<String, Integer> map = MapUtil.int2map(pageNum, pageSize);
        if (userId != 0) {
            map.put("userId", userId);
        }
        map.put("status", status);
        model.addAttribute("blogVoList", blogService.showAll(map));
        return "list/blogVos";
    }

    //    文章页面
    @RequestMapping("/{blogId}")
    public String blogVo(Model model, @PathVariable Integer blogId) {
        model.addAttribute("blogVo", blogService.show(blogId));
        return "user/blogVo";
    }

}
