package com.taylorsfan.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author taylorsfan
 */
@Controller
public class ToWhereController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
