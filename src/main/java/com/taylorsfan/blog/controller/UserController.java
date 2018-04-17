package com.taylorsfan.blog.controller;

import com.taylorsfan.blog.model.User;
import com.taylorsfan.blog.service.UserService;
import com.taylorsfan.blog.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author taylorsfan
 */
@Controller
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

    /**
     * 根据用户姓名查询到用户的信息
     */
    @RequestMapping("/{userId}")
    public String showUser(Model model, @PathVariable Integer userId) {
        model.addAttribute("userVo", userService.showUserByUserId(userId));
        return "user/personal";
    }

    /**
     * 更新个人信息
     */

    @ResponseBody
    @RequestMapping("/{userId}/update")
    public ResultUtil updateUserMsg(User user, @PathVariable Integer userId) {
        if (userService.update(user)) {
            return new ResultUtil(200, "success");
        }
        return new ResultUtil(500, "failure");
    }

    /**
     * 重置密码
     */
    @ResponseBody
    @RequestMapping("/{userId}/resetPassword")
    public ResultUtil resetPassword(@PathVariable Integer userId) {
        if (userService.resetPassword(userId)) {
            return new ResultUtil(200, "success");
        }
        return new ResultUtil(500, "failure");
    }

    /**
     * 注销
     */
    @ResponseBody
    @RequestMapping("/{userId}/logoff")
    public ResultUtil logoff(@PathVariable Integer userId) {
        if (userService.delete(userId)) {
            return new ResultUtil(200, "success");
        }
        return new ResultUtil(500, "failure");
    }


}
