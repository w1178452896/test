package com.taylorsfan.blog.controller.admin;

import com.taylorsfan.blog.model.Sort;
import com.taylorsfan.blog.service.BlogService;
import com.taylorsfan.blog.service.SortService;
import com.taylorsfan.blog.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

/**
 * @author tianle
 */
@Controller
@RequestMapping("/admin/sort")
public class DoSortController {
    private final SortService sortService;
    private final BlogService blogService;

    @Autowired
    public DoSortController(SortService sortService, BlogService blogService) {
        this.sortService = sortService;
        this.blogService = blogService;
    }

    @RequestMapping("/all")
    public String SortAll(Model model) {
        model.addAttribute("sortList", sortService.showAll(new HashMap<String, Integer>()));
        return "list/admin/sorts";
    }

    @ResponseBody
    @RequestMapping("/{sortId}/update")
    public ResultUtil update(Sort sort, @PathVariable int sortId) {
        if (sortService.update(sort)) {
            return new ResultUtil(200, "success");
        }
        return new ResultUtil(400, "failure");
    }

    @ResponseBody
    @RequestMapping("/insert")
    public ResultUtil insert(Sort sort) {
        if (sortService.insert(sort)) {
            return new ResultUtil(200, "success");
        }
        return new ResultUtil(400, "failure");
    }
}

