package com.taylorsfan.blog.controller;

import com.taylorsfan.blog.service.UserService;
import com.taylorsfan.blog.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author taylorsfan
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/login")
    public ResultUtil login(String username, String password) {
        if (userService.login(username, password) != null) {
            return new ResultUtil(200, "success");
        }
        return new ResultUtil(400, "failure");
    }

}
