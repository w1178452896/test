package com.taylorsfan.blog.controller.user;

import com.taylorsfan.blog.model.User;
import com.taylorsfan.blog.service.UserService;
import com.taylorsfan.blog.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author taylorsfan
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @RequestMapping("/judgeHaveUserOrNot")
    public ResultUtil judgeHaveUserOrNot(String username) {
        if (userService.judgeHaveUserOrNot(username)) {
            return new ResultUtil(200, "success");
        }
        return new ResultUtil(500, "failure");
    }

    /**
     * 登陆
     */
    @ResponseBody
    @RequestMapping("/login")
    public ResultUtil login(String username, String password) {
        if (userService.login(username, password) != null) {
            return new ResultUtil(200, "success");
        }
        return new ResultUtil(500, "failure");
    }

    /**
     * 注册
     */
    @ResponseBody
    @RequestMapping("/register")
    public ResultUtil register(User user) {
        if (userService.insert(user)) {
            return new ResultUtil(200, "success");
        }
        return new ResultUtil(500, "failure");
    }


}
