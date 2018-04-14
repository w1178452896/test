package com.taylorsfan.blog.controller.admin;

import com.taylorsfan.blog.model.User;
import com.taylorsfan.blog.service.UserService;
import com.taylorsfan.blog.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author taylorsfan
 */
@Controller
@RequestMapping("/admin/user")
public class DoUserController {

    private final UserService userService;

    @Autowired
    public DoUserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/all")
    public String findAll(Model model, int pageNum, int pageSize) {
        model.addAttribute("userList", userService.findAll(pageNum, pageSize));
        return "/list/users";
    }

    @ResponseBody
    @RequestMapping("/resetPassword")
    public ResultUtil resetPassword(int id) {
        if (userService.resetPassword(id)) {
            return new ResultUtil(200, "success");
        }
        return new ResultUtil(500, "failure");
    }

    @ResponseBody
    @RequestMapping("/changeRole")
    public ResultUtil changeRole(int id, int[] roleIds) {
        if (userService.changeRole(id, roleIds)) {
            return new ResultUtil(200, "success");
        }
        return new ResultUtil(500, "failure");
    }
}
