package com.taylorsfan.blog.controller.admin;

import com.taylorsfan.blog.model.Role;
import com.taylorsfan.blog.model.relation.RolePermission;
import com.taylorsfan.blog.service.PermissionService;
import com.taylorsfan.blog.service.RoleService;
import com.taylorsfan.blog.service.relation.RolePermissionService;
import com.taylorsfan.blog.util.ResultUtil;
import com.taylorsfan.blog.vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author tianle
 */
@RequestMapping("/admin/role")
@Controller
public class DoRoleController {
    private final RolePermissionService rolePermissionService;
    private final RoleService roleService;
    private final PermissionService permissionService;

    @Autowired
    public DoRoleController(RolePermissionService rolePermissionService, RoleService roleService, PermissionService permissionService) {
        this.rolePermissionService = rolePermissionService;
        this.roleService = roleService;
        this.permissionService = permissionService;
    }

    /**
     * 增加角色，分配权限
     */
    @ResponseBody
    @RequestMapping("/insert")
    public ResultUtil insert(Role role, int permissionId) {
        if (roleService.insert(role)) {
            RolePermission rolePermission = new RolePermission();
            rolePermission.setRoleId(role.getId());
            rolePermission.setPermissionId(permissionId);
            if (rolePermissionService.insert(rolePermission)) {
                return new ResultUtil(200, "success");
            }
        }
        return new ResultUtil(500, "failure");
    }

    /**
     * 更改角色名
     */
    @ResponseBody
    @RequestMapping("/{roleId}/update")
    public ResultUtil update(Role role, @PathVariable int roleId) {
        if (roleService.update(role)) {
            return new ResultUtil(200, "success");
        }
        return new ResultUtil(500, "failure");
    }

    /**
     * 所有
     */
    @RequestMapping("/all")
    public String roleVoList(Model model) {
        List<Role> roleList = roleService.showAll(null);
        List<RoleVo> roleVoList = new ArrayList<>();
        for (Role role : roleList) {
            RoleVo roleVo = new RoleVo();
            roleVo.setRole(role);
            Map<String, Integer> map = new HashMap<>();
            map.put("roleId", role.getId());
            roleVo.setPermissionList(permissionService.showAll(map));
            roleVoList.add(roleVo);
        }
        model.addAttribute("roleVoList", roleVoList);
        return "list/admin/roleVos";
    }

    @RequestMapping("/{roleId}")
    public String roleVo(Model model, @PathVariable int roleId) {
        Role role = roleService.showOne(roleId);
        RoleVo roleVo = new RoleVo();
        roleVo.setRole(role);
        Map<String, Integer> map = new HashMap<>();
        map.put("roleId", role.getId());
        roleVo.setPermissionList(permissionService.showAll(map));
        model.addAttribute("roleVo", roleVo);
        return "admin/roleVo";
    }
    /*
    @ResponseBody
    @RequestMapping("/testAll")
    public List<RoleVo> testRoleVoList() {
        List<Role> roleList = roleService.showAll(new HashMap<>());
        List<RoleVo> roleVoList = new ArrayList<>();
        for (Role role : roleList) {
            RoleVo roleVo = new RoleVo();
            roleVo.setRole(role);
            Map<String, Integer> map = new HashMap<>();
            map.put("roleId", role.getId());
            roleVo.setPermissionList(permissionService.showAll(map));
            roleVoList.add(roleVo);
        }
        return roleVoList;
    }*/
}
