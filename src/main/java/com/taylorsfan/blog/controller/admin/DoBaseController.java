package com.taylorsfan.blog.controller.admin;

import com.taylorsfan.blog.util.ResultUtil;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * @author taylorsfan
 */
public interface DoBaseController<T> {

    String findAll(Model model, int pageNum, int pageSize);

    ResultUtil insert(T t);

    ResultUtil update(T t);

    ResultUtil delete(int id);
}
