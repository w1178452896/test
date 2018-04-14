package com.taylorsfan.blog.controller.user;

import com.taylorsfan.blog.model.User;
import com.taylorsfan.blog.service.UserService;
import com.taylorsfan.blog.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author taylorsfan
 */

@RequestMapping("/user/manage/personal")
@Controller
public class UserMsgController {
    private final UserService userService;

    @Autowired
    public UserMsgController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 根据用户姓名查询到用户的信息
     */
    @RequestMapping("/")
    public String findUserMsg(Model model, int id) {
        model.addAttribute("userVo", userService.findMsgByUserId(id));
        return "index-user";
    }

    /**
     * 更新个人信息
     */
    @ResponseBody
    @RequestMapping("/update")
    public ResultUtil update(User user) {
        if (userService.update(user)) {
            return new ResultUtil(200, "success");
        }
        return new ResultUtil(500, "failure");
    }

    /**
     * 重置密码
     */
    @ResponseBody
    @RequestMapping("/resetPassword")
    public ResultUtil resetPassword(int id) {
        if (userService.resetPassword(id)) {
            return new ResultUtil(200, "success");
        }
        return new ResultUtil(500, "failure");
    }

    /**
     * 注销
     */
    @ResponseBody
    @RequestMapping("/logoff")
    public ResultUtil logoff(int id) {
        if (userService.delete(id)) {
            return new ResultUtil(200, "success");
        }
        return new ResultUtil(500, "failure");
    }

}
