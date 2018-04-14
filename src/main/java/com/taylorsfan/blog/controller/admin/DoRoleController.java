package com.taylorsfan.blog.controller.admin;

import com.taylorsfan.blog.model.Role;
import com.taylorsfan.blog.service.RoleService;
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
@RequestMapping("/admin/role")
public class DoRoleController implements DoBaseController<Role> {

    private final RoleService roleService;

    @Autowired
    public DoRoleController(RoleService roleService) {
        this.roleService = roleService;
    }


    @Override
    public String findAll(Model model, @RequestBody int pageNum, @RequestBody int pageSize) {
        return null;
    }

    @Override
    public ResultUtil insert(Role role) {
        return null;
    }

    @Override
    public ResultUtil update(Role role) {
        return null;
    }

    @Override
    public ResultUtil delete(int id) {
        return null;
    }
}
