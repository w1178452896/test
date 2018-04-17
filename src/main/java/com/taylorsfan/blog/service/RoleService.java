package com.taylorsfan.blog.service;

import com.taylorsfan.blog.model.Role;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author momo
 */
public interface RoleService {
    List<Role> showAll(Integer pageNum, Integer pageSize);

    boolean update(Role role);

    boolean insert(Role role);

    boolean delete(Integer id);
}
