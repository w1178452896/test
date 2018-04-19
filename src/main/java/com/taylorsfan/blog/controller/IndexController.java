package com.taylorsfan.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author taylorsfan
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
