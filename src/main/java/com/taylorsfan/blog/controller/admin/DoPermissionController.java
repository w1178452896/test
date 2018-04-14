package com.taylorsfan.blog.controller.admin;

import com.taylorsfan.blog.model.Permission;
import com.taylorsfan.blog.service.PermissionService;
import com.taylorsfan.blog.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author taylorsfan
 */
@Controller
@RequestMapping("/admin/permission")
public class DoPermissionController implements DoBaseController<Permission> {

    private final PermissionService permissionService;

    @Autowired
    public DoPermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }


    @Override
    public String findAll(Model model, @RequestBody int pageNum, @RequestBody int pageSize) {
        return null;
    }

    @Override
    public ResultUtil insert(Permission permission) {
        return null;
    }

    @Override
    public ResultUtil update(Permission permission) {
        return null;
    }

    @Override
    public ResultUtil delete(int id) {
        return null;
    }
}
