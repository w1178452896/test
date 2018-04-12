package com.taylorsfan.blog.controller.admin;

import com.taylorsfan.blog.model.User;
import com.taylorsfan.blog.service.UserService;
import com.taylorsfan.blog.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author taylorsfan
 */
@Controller
@RequestMapping("/admin/user")
public class DoUserController implements DoBaseController<User> {

    @Autowired
    private UserService userService;

    @Override
    public String findAll(Model model, int pageNum, int pageSize) {
        return null;
    }

    @Override
    public ResultUtil insert(User user) {
        return null;
    }

    @Override
    public ResultUtil update(User user) {
        return null;
    }

    @Override
    public ResultUtil delete(int id) {
        return null;
    }
}
