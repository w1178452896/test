package com.taylorsfan.blog.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author taylorsfan
 */
@Controller
public class ToWhereController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/user/manage/checkBlog")
    public String checkBlog() {
        return "redirect:/list/blogs";
    }

    @RequestMapping("/user-index")
    public String user_index() {
        return "user-index";
    }
}
