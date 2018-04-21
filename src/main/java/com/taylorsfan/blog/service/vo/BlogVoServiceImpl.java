package com.taylorsfan.blog.service.vo;

import com.taylorsfan.blog.model.Blog;
import com.taylorsfan.blog.service.BlogService;
import com.taylorsfan.blog.service.CommentService;
import com.taylorsfan.blog.service.SortService;
import com.taylorsfan.blog.service.UserService;
import com.taylorsfan.blog.service.relation.*;
import com.taylorsfan.blog.util.MapUtil;
import com.taylorsfan.blog.vo.BlogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author tianle
 */
@Service
public class BlogVoServiceImpl implements BlogVoService {

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
    public BlogVoServiceImpl(BlogService blogService, BlogUserService blogUserService, BlogCommentService
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

    @Override
    public BlogVo blogVo(int blogId) {
        BlogVo blogVo = new BlogVo();
        blogVo.setBlog(blogService.showOne(blogId));
        blogVo.setUser(userService.showUserByBlogId(blogId));
        blogVo.setSort(sortService.showSortByBlogId(blogId));
        blogVo.setUserCount(blogUserService.count(blogId));
        blogVo.setCommentCount(blogCommentService.count(blogId));
        return blogVo;
    }

    @Override
    public List<BlogVo> blogVoList(int pageNum, int pageSize, int status, int userId, int sortId) {
        Map<String, Integer> map = MapUtil.int2map(pageNum, pageSize);
        // 用户主页按分类查询
        if (status != 0 && userId != 0 && sortId != 0) {
            map.put("status", status);
            map.put("userId", userId);
            map.put("sortId", sortId);
            return map2blogVoList(map);

        }
        //用户个人主页显示
        if (status != 0 && userId != 0 && sortId == 0) {
            map.put("status", status);
            map.put("userId", userId);
            return map2blogVoList(map);
        }
        //首页显示按分类
        if (status != 0 && userId == 0 && sortId != 0) {
            map.put("status", status);
            map.put("sortId", sortId);
            return map2blogVoList(map);
        }
        //首页显示
        if (status != 0 && userId == 0 && sortId == 0) {
            map.put("status", status);
            List<BlogVo> blogVoList = map2blogVoList(map);
            return blogVoList;
        }

        // 后台按分类
        if (status == 0 && userId == 0 && sortId != 0) {
            map.put("sortId", sortId);
            return map2blogVoList(map);
        }
        //后台按用户
        if (status == 0 && userId != 0 && sortId == 0) {
            map.put("userId", userId);
            return map2blogVoList(map);
        }
        //后台按状态
        if (status != 0 && userId == 0 && sortId == 0) {
            map.put("status", status);
            return map2blogVoList(map);
        }
        //后台所有
        if (status == 0 && userId == 0 && sortId == 0) {
            return map2blogVoList(map);
        }
        return null;
    }

    private List<BlogVo> map2blogVoList(Map<String, Integer> map) {
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
        return blogVoList;
    }
}
