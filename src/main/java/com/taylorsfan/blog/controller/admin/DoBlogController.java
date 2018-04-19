package com.taylorsfan.blog.controller.admin;

import com.taylorsfan.blog.model.Blog;
import com.taylorsfan.blog.service.BlogService;
import com.taylorsfan.blog.service.SortService;
import com.taylorsfan.blog.service.UserService;
import com.taylorsfan.blog.service.relation.BlogCommentService;
import com.taylorsfan.blog.service.relation.BlogUserService;
import com.taylorsfan.blog.util.MapUtil;
import com.taylorsfan.blog.vo.BlogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author tianle
 */
@Controller
@RequestMapping("/admin/blog")
public class DoBlogController {

    private final BlogService blogService;
    private final BlogUserService blogUserService;
    private final BlogCommentService blogCommentService;
    private final UserService userService;
    private final SortService sortService;

    @Autowired
    public DoBlogController(BlogService blogService, BlogUserService blogUserService,
                            BlogCommentService blogCommentService, UserService userService,
                            SortService sortService) {
        this.blogService = blogService;
        this.blogUserService = blogUserService;
        this.blogCommentService = blogCommentService;
        this.userService = userService;
        this.sortService = sortService;
    }

    /**
     * 文章显示
     */
    @RequestMapping("/all")
    public String blogVoList(Model model, int pageNum, int pageSize, int status, int userId, int sortId) {
        Map<String, Integer> map = MapUtil.int2map(pageNum, pageSize);
        // 后台按分类
        if (status == 0 && userId == 0 && sortId != 0) {
            map.put("sortId", sortId);
            map2blogVoList(map, model);
            return "list/blogVos";
        }
        //后台按用户
        if (status == 0 && userId != 0 && sortId == 0) {
            map.put("userId", userId);
            map2blogVoList(map, model);
            return "list/blogVos";
        }
        //后台按状态
        if (status != 0 && userId == 0 && sortId == 0) {
            map.put("status", status);
            map2blogVoList(map, model);
            return "list/blogVos";
        }
        //后台所有
        if (status == 0 && userId == 0 && sortId == 0) {
            map2blogVoList(map, model);
            return "list/blogVos";
        }
        return null;
    }

    private void map2blogVoList(Map<String, Integer> map, Model model) {
        List<BlogVo> blogVoList = new ArrayList<>();
        List<Blog> blogList = blogService.showAll(map);
        for (Blog blog : blogList) {
            BlogVo blogVo = new BlogVo();
            int blogId = blog.getId();
            blogVo.setBlog(blogService.showOne(blogId));
            blogVo.setUser(userService.showUserByBlogId(blogId));
            blogVo.setSort(sortService.showSortByBlogId(blogId));
            blogVo.setCommentCount(blogCommentService.count(blogId));
            blogVo.setUserCount(blogUserService.count(blogId));
            blogVoList.add(blogVo);
        }
        model.addAttribute("blogVoList", blogVoList);
    }
}
