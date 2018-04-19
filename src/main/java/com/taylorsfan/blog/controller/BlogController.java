package com.taylorsfan.blog.controller;

import com.taylorsfan.blog.model.Blog;
import com.taylorsfan.blog.model.Comment;
import com.taylorsfan.blog.model.relation.SortBlog;
import com.taylorsfan.blog.model.relation.UserBlog;
import com.taylorsfan.blog.service.BlogService;
import com.taylorsfan.blog.service.CommentService;
import com.taylorsfan.blog.service.SortService;
import com.taylorsfan.blog.service.UserService;
import com.taylorsfan.blog.service.relation.*;
import com.taylorsfan.blog.util.MapUtil;
import com.taylorsfan.blog.util.ResultUtil;
import com.taylorsfan.blog.vo.BlogVo;
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
 * @author taylorsfan
 * 个人主页的blogList，以及blog
 */
@RequestMapping("/blog")
@Controller
public class BlogController {
    private final BlogService blogService;
    private final BlogUserService blogUserService;
    private final UserBlogService userBlogService;
    private final BlogCommentService blogCommentService;
    private final UserService userService;
    private final SortService sortService;
    private final CommentService commentService;
    private final SortBlogService sortBlogService;
    private final CommentUserService commentUserService;
    private final UserCommentService userCommentService;

    @Autowired
    public BlogController(BlogService blogService, BlogUserService blogUserService, BlogCommentService
            blogCommentService, UserService userService, SortService sortService,
                          CommentService commentService, SortBlogService sortBlogService,
                          UserBlogService userBlogService, CommentUserService commentUserService,
                          UserCommentService userCommentService) {
        this.blogService = blogService;
        this.blogUserService = blogUserService;
        this.blogCommentService = blogCommentService;
        this.userService = userService;
        this.sortService = sortService;
        this.commentService = commentService;
        this.sortBlogService = sortBlogService;
        this.userBlogService = userBlogService;
        this.commentUserService = commentUserService;
        this.userCommentService = userCommentService;
    }

    /**
     * 新增文章
     */
    @ResponseBody
    @RequestMapping("/insert")
    public ResultUtil insert(BlogVo blogVo) {
        if (blogService.insert(blogVo.getBlog())) {
            UserBlog userBlog = new UserBlog();
            userBlog.setBlogId(blogVo.getBlog().getId());
            userBlog.setUserId(blogVo.getUser().getId());
            if (userBlogService.insert(userBlog)) {
                return new ResultUtil(200, "success");
            }
        }
        return new ResultUtil(500, "failure");
    }

    /**
     * 删除
     */
    @ResponseBody
    @RequestMapping("/{blogId}/delete")
    public ResultUtil delete(@PathVariable int blogId) {
        Map<String, Integer> map = new HashMap<>();
        map.put("blogId", blogId);
        if (blogService.delete(blogId) && blogUserService.deleteByOneId(blogId)
                && userBlogService.deleteByMoreId(blogId) && blogCommentService.deleteByOneId(blogId)
                && commentService.deleteByBlogId(blogId)) {
            for (Comment comment : commentService.showAll(map)) {
                if (commentUserService.deleteByOneId(comment.getId()) &&
                        userCommentService.deleteByMoreId(comment.getId())) {
                    continue;
                }
                return new ResultUtil(500, "failure");
            }
        }
        return new ResultUtil(200, "success");
    }

    /**
     * 更新
     */
    @ResponseBody
    @RequestMapping("/{blogId}/update")
    public ResultUtil update(BlogVo blogVo, @PathVariable int blogId) {
        if (blogService.update(blogVo.getBlog())) {
            sortBlogService.deleteByMoreId(blogVo.getBlog().getId());
            SortBlog sortBlog = new SortBlog();
            sortBlog.setBlogId(blogVo.getSort().getId());
            sortBlog.setSortId(blogId);
            if (sortBlogService.insert(sortBlog)) {
                return new ResultUtil(200, "success");
            }
        }
        return new ResultUtil(500, "failure");
    }

    /**
     * 观看文章页面
     */
    @RequestMapping("/{blogId}")
    public String blogVo(Model model, @PathVariable int blogId) {
        BlogVo blogVo = new BlogVo();
        blogVo.setBlog(blogService.showOne(blogId));
        blogVo.setUser(userService.showUserByBlogId(blogId));
        blogVo.setSort(sortService.showSortByBlogId(blogId));
        blogVo.setUserCount(blogUserService.count(blogId));
        blogVo.setCommentCount(blogCommentService.count(blogId));
        model.addAttribute("blogVo", blogService.showOne(blogId));
        return "user/blogVo";
    }
/*
    @ResponseBody
    @RequestMapping("/1")
    public BlogVo testBlogVo() {
        BlogVo blogVo = new BlogVo();
        blogVo.setBlog(blogService.showOne(1));
        blogVo.setUser(userService.showUserByBlogId(1));
        blogVo.setSort(sortService.showSortByBlogId(1));
        blogVo.setUserCount(blogUserService.count(1));
        blogVo.setCommentCount(blogCommentService.count(1));
        return blogVo;
    }*/

    /**
     * 文章显示
     */
    @RequestMapping("/all")
    public String blogVoList(Model model, int pageNum, int pageSize, int status, int userId, int sortId) {
        Map<String, Integer> map = MapUtil.int2map(pageNum, pageSize);
        // 用户主页按分类查询
        if (status != 0 && userId != 0 && sortId != 0) {
            map.put("status", status);
            map.put("userId", userId);
            map.put("sortId", sortId);
            map2blogVoList(map, model);
            return "list/blogVos";
        }
        //用户个人主页显示
        if (status != 0 && userId != 0 && sortId == 0) {
            map.put("status", status);
            map.put("userId", userId);
            map2blogVoList(map, model);
            return "list/blogVos";
        }
        //首页显示按分类
        if (status != 0 && userId == 0 && sortId != 0) {
            map.put("status", status);
            map.put("sortId", sortId);
            map2blogVoList(map, model);
            return "list/blogVos";
        }
        //首页显示
        if (status != 0 && userId == 0 && sortId == 0) {
            map.put("status", status);
            map2blogVoList(map, model);
            return "list/blogVos";
        }

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
        return "404";
    }
    /*
    @ResponseBody
    @RequestMapping("/testAll")
    public List<BlogVo> testBlogVoList() {
        Map<String, Integer> map = MapUtil.int2map(1, 2);
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
        return blogVoList;
    }*/

    private void map2blogVoList(Map<String, Integer> map, Model model) {
        List<BlogVo> blogVoList = new ArrayList<>();
        List<Blog> blogList = blogService.showAll(map);
        for (Blog blog : blogList) {
            BlogVo blogVo = new BlogVo();
            int blogId = blog.getId();
            blogVo.setUser(userService.showUserByBlogId(blogId));
            blogVo.setBlog(blogService.showOne(blogId));
            blogVo.setSort(sortService.showSortByBlogId(blogId));
            blogVo.setCommentCount(blogCommentService.count(blogId));
            blogVo.setUserCount(blogUserService.count(blogId));
            blogVoList.add(blogVo);
        }
        model.addAttribute("blogVoList", blogVoList);
    }
}
