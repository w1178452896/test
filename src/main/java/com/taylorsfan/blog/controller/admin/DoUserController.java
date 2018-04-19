package com.taylorsfan.blog.controller.admin;

import com.taylorsfan.blog.model.User;
import com.taylorsfan.blog.model.relation.UserRole;
import com.taylorsfan.blog.service.PermissionService;
import com.taylorsfan.blog.service.RoleService;
import com.taylorsfan.blog.service.UserService;
import com.taylorsfan.blog.service.relation.UserRoleService;
import com.taylorsfan.blog.util.MapUtil;
import com.taylorsfan.blog.util.ResultUtil;
import com.taylorsfan.blog.vo.DoUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tianle
 */
@RequestMapping("/admin/user")
@Controller
public class DoUserController {
    private final UserService userService;
    private final RoleService roleService;
    private final UserRoleService userRoleService;
    private final PermissionService permissionService;

    @Autowired
    public DoUserController(UserService userService, RoleService roleService,
                            UserRoleService userRoleService, PermissionService permissionService) {
        this.userService = userService;
        this.roleService = roleService;
        this.userRoleService = userRoleService;
        this.permissionService = permissionService;
    }

    @RequestMapping("/all")
    public String userList(Model model, int pageNum, int pageSize) {
        Map<String, Integer> map = MapUtil.int2map(pageNum, pageSize);
        List<User> userList = userService.showAll(map);
        model.addAttribute("userList", userList);
        return "list/admin/users";
    }

    /*
    @ResponseBody
    @RequestMapping("/testAll")
    public List<User> testUserList() {
        List<UserVo> userVoList = new ArrayList<>();
        Map<String, Integer> map = MapUtil.int2map(1, 4);
        List<User> userList = userService.showAll(map);
        return userList;
    }*/
    @RequestMapping("/{userId}")
    public String doUserVo(Model model, @PathVariable int userId) {
        Map<String, Integer> map = new HashMap<>();
        map.put("userId", userId);
        User user = userService.showOne(userId);
        DoUserVo doUserVo = new DoUserVo();
        doUserVo.setUser(user);
        doUserVo.setRoleList(roleService.showAll(map));
        doUserVo.setPermissionList(permissionService.showAll(map));
        model.addAttribute("doUserVo", doUserVo);
        return "admin/doUserVo";
    }
/*
    @ResponseBody
    @RequestMapping("/1")
    public DoUserVo testDoUserVo() {
        Map<String, Integer> map = new HashMap<>();
        map.put("userId", 1);
        User user = userService.showOne(1);
        DoUserVo doUserVo = new DoUserVo();
        doUserVo.setUser(user);
        doUserVo.setRoleList(roleService.showAll(map));
        doUserVo.setPermissionList(permissionService.showAll(map));
        return doUserVo;
    }*/

    //    权限管理
    @RequestMapping("/{userId}/userRole")
    @ResponseBody
    public ResultUtil changeRolePermission(@PathVariable int userId, int[] roleIds) {
        if (userRoleService.deleteByOneId(userId)) {
            for (int roleId : roleIds) {
                UserRole userRole = new UserRole();
                userRole.setUserId(userId);
                userRole.setRoleId(roleId);
                if (!userRoleService.insert(userRole)) {
                    return new ResultUtil(500, "failure");
                }
            }
        }
        return new ResultUtil(200, "success");
    }
}
