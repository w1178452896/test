package com.taylorsfan.blog.controller.admin;

import com.taylorsfan.blog.model.Permission;
import com.taylorsfan.blog.service.PermissionService;
import com.taylorsfan.blog.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

/**
 * @author tianle
 */
@Controller
@RequestMapping("/admin/permission")
public class DoPermissionController {
    private final PermissionService permissionService;

    @Autowired
    public DoPermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @RequestMapping("/all")
    public String permissionList(Model model) {
        model.addAttribute("permissionList", permissionService.showAll(new HashMap<>()));
        return "list/admin/permissions";
    }

    @ResponseBody
    @RequestMapping("/testAll")
    public List<Permission> testPermissionList() {
        return permissionService.showAll(new HashMap<>());
    }

    @RequestMapping("/insert")
    @ResponseBody
    public ResultUtil insert(Permission permission) {
        if (permissionService.insert(permission)) {
            return new ResultUtil(200, "success");
        }
        return new ResultUtil(400, "failure");
    }

    @RequestMapping("/{permissionId}/update")
    @ResponseBody
    public ResultUtil update(Permission permission, @PathVariable int permissionId) {
        if (permissionService.update(permission)) {
            return new ResultUtil(200, "success");
        }
        return new ResultUtil(400, "failure");
    }

    @RequestMapping("/{permissionId}/delete")
    @ResponseBody
    public ResultUtil delete(@PathVariable int permissionId) {
        if (permissionService.delete(permissionId)) {
            return new ResultUtil(200, "success");
        }
        return new ResultUtil(400, "failure");
    }
}
