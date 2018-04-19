package com.taylorsfan.blog.controller;

import com.taylorsfan.blog.model.User;
import com.taylorsfan.blog.model.relation.UserRole;
import com.taylorsfan.blog.service.UserService;
import com.taylorsfan.blog.service.relation.*;
import com.taylorsfan.blog.util.MapUtil;
import com.taylorsfan.blog.util.ResultUtil;
import com.taylorsfan.blog.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author taylorsfan
 */
@RequestMapping("/user")
@Controller
public class UserController {
    private final UserService userService;
    private final UserBlogService userBlogService;
    private final UserFanService userFanService;
    private final UserFocusService userFocusService;
    private final UserRoleService userRoleService;

    @Autowired
    public UserController(UserService userService, UserBlogService userBlogService, UserCommentService userCommentService, UserFanService userFanService, UserFocusService userFocusService, UserRoleService userRoleService) {
        this.userService = userService;
        this.userBlogService = userBlogService;
        this.userFanService = userFanService;
        this.userFocusService = userFocusService;
        this.userRoleService = userRoleService;
    }

    /**
     * 注册
     */
    @ResponseBody
    @RequestMapping("/register")
    public ResultUtil register(User user) {
        if (userService.insert(user)) {
            UserRole userRole = new UserRole();
            userRole.setRoleId(1);
            userRole.setUserId(user.getId());
            if (userRoleService.insert(userRole)) {
                return new ResultUtil(200, "success");
            }
        }
        return new ResultUtil(500, "failure");
    }

    /**
     * 注销
     */
    @ResponseBody
    @RequestMapping("/logoff")
    public ResultUtil logoff(int userId) {

        if (userService.delete(userId) &&
                userRoleService.deleteByOneId(userId) &&
                userBlogService.deleteByOneId(userId) &&
                userFanService.deleteByOneId(userId) &&
                userFocusService.deleteByOneId(userId)) {
            return new ResultUtil(200, "success");
        }
        return new ResultUtil(500, "failure");
    }

    /**
     * 登陆
     */
    @ResponseBody
    @RequestMapping("/login")
    public User login(String username, String password) {
        if (userService.login(username, password) != null) {
            return userService.login(username, password);
        }
        return null;
    }

    /**
     * 判断是否有此用户
     */
    @ResponseBody
    @RequestMapping("/judgeHaveUserOrNot")
    public ResultUtil judgeHaveUserOrNot(String username) {
        if (userService.judgeHaveUserOrNot(username)) {
            return new ResultUtil(200, "success");
        }
        return new ResultUtil(500, "failure");
    }

    /**
     * 更新个人信息
     */

    @ResponseBody
    @RequestMapping("/update")
    public ResultUtil updateUserMsg(User user) {
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
    public ResultUtil resetPassword(Integer userId) {
        if (userService.resetPassword(userId)) {
            return new ResultUtil(200, "success");
        }
        return new ResultUtil(500, "failure");
    }

    @RequestMapping("/user/all")
    public String userVoList(Model model, int userId, int fan, int focus, int pageNum, int pageSize) {
        Map<String, Integer> map = MapUtil.int2map(pageNum, pageSize);
        map.put("userId", userId);
        if (fan != 0 && focus == 0) {
            map.put("fan", fan);
            map2userVoList(map, model, userId);
            return "list/userVos";
        } else if (fan == 0 && focus != 0) {
            map.put("focus", focus);
            map2userVoList(map, model, userId);
            return "list/userVos";
        }
        return "404";
    }

    /**
     * 根据用户id查询到用户的信息
     */
    @RequestMapping("/{userId}")
    public String showUserVo(Model model, @PathVariable Integer userId) {
        UserVo userVo = new UserVo();
        userVo.setUser(userService.showOne(userId));
        userVo.setBlogCount(userBlogService.count(userId));
        userVo.setFanCount(userFanService.count(userId));
        userVo.setFocusCount(userFocusService.count(userId));
        model.addAttribute("userVo", userService.showOne(userId));
        return "user/index";
    }

    @RequestMapping("{userId}")
    public String showUser(Model model, @PathVariable int userId) {
        model.addAttribute("user", userService.showOne(userId));
        return "user/user";
    }

    @RequestMapping("/userTest")
    @ResponseBody
    public UserVo testShowUserVo() {
        UserVo userVo = new UserVo();
        userVo.setUser(userService.showOne(1));
        userVo.setBlogCount(userBlogService.count(1));
        userVo.setFanCount(userFanService.count(1));
        userVo.setFocusCount(userFocusService.count(1));
        return userVo;
    }

    private void map2userVoList(Map<String, Integer> map, Model model, int userId) {
        List<UserVo> userVoList = new ArrayList<>();
        List<User> userList = userService.showAll(map);
        for (User user : userList) {
            UserVo userVo = new UserVo();
            userVo.setUser(userService.showOne(userId));
            userVo.setBlogCount(userBlogService.count(userId));
            userVo.setFanCount(userFanService.count(userId));
            userVo.setFocusCount(userFocusService.count(userId));
            userVoList.add(userVo);
        }
        model.addAttribute("userVoList", userVoList);
    }

}
