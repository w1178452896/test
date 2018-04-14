package com.taylorsfan.blog.controller.admin;

import com.taylorsfan.blog.model.Sort;
import com.taylorsfan.blog.service.SortService;
import com.taylorsfan.blog.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author taylorsfan
 */
@Controller
@RequestMapping("/admin/sort")
public class DoSortController implements DoBaseController<Sort> {

    private final SortService sortService;

    @Autowired
    public DoSortController(SortService sortService) {
        this.sortService = sortService;
    }

    @Override
    public String findAll(Model model, @RequestBody int pageNum, @RequestBody int pageSize) {
        return null;
    }

    @Override
    public ResultUtil insert(Sort sort) {
        return null;
    }

    @Override
    public ResultUtil update(Sort sort) {
        return null;
    }

    @Override
    public ResultUtil delete(int id) {
        return null;
    }


}
