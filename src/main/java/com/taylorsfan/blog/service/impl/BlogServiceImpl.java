package com.taylorsfan.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taylorsfan.blog.model.Blog;
import com.taylorsfan.blog.repository.BlogMapper;
import com.taylorsfan.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author taylorsfan
 */
@Service
public class BlogServiceImpl implements BlogService {

    private final BlogMapper blogMapper;

    @Autowired
    public BlogServiceImpl(BlogMapper blogMapper) {
        this.blogMapper = blogMapper;
    }

    /**
     * 后台显示所有文章
     * 首页显示的正常的文章
     * 显示的审核中的文章
     * 显示
     * 用户正常的文章；
     * 被封禁的文章；
     * 正在审核中的文章。
     */
    @Override
    public List<Blog> showAll(Map<String, Integer> map) {
        List<Blog> blogList;
        //分页
        PageHelper.startPage(map.get("pageNum"), map.get("pageSize"));
        // 用户主页按分类查询
        if (map.containsKey("userId") && map.containsKey("status") && map.containsKey("sortId")) {
            blogList = blogMapper.selectAllByStatusAndSortIdAndUserId(map.get("status"), map.get("userId"), map.get("sortId"));
            PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
            return pageInfo.getList();
        }
        //用户个人主页显示
        else if (map.containsKey("userId") && map.containsKey("status") && !map.containsKey("sortId")) {
            blogList = blogMapper.selectAllByStatusAndUserId(map.get("status"), map.get("userId"));
            PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
            return pageInfo.getList();
        }
        //首页显示按分类
        else if (!map.containsKey("userId") && map.containsKey("status") && map.containsKey("sortId")) {
            blogList = blogMapper.selectAllByStatusAndSortId(map.get("status"), map.get("sortId"));
            PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
            return pageInfo.getList();
        }
        //首页显示|后台按状态
        else if (!map.containsKey("userId") && map.containsKey("status") && !map.containsKey("sortId")) {
            blogList = blogMapper.selectAllByStatus(map.get("status"));
            PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
            return pageInfo.getList();
        }
        // 后台按用户
        else if (map.containsKey("userId") && !map.containsKey("status") && !map.containsKey("sortId")) {
            blogList = blogMapper.selectAllByUserId(map.get("userId"));
            PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
            return pageInfo.getList();
        }
        // 后台按分类
        else if (!map.containsKey("userId") && !map.containsKey("status") && map.containsKey("sortId")) {
            blogList = blogMapper.selectAllBySortId(map.get("sortId"));
            PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
            return pageInfo.getList();
        }
        //后台所有
        else if (!map.containsKey("userId") && !map.containsKey("status") && !map.containsKey("sortId")) {
            blogList = blogMapper.selectAll();
            PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
            return pageInfo.getList();
        }
        return null;
    }

    @Override
    public Blog showOne(int blogId) {
        return blogMapper.selectOneByPrimaryKey(blogId);
    }

    @Override
    public boolean update(Blog blog) {
        return blogMapper.updateByPrimaryKey(blog) != 0;
    }

    @Override
    public boolean delete(int blogId) {
        return blogMapper.deleteByPrimaryKey(blogId) != 0;
    }

    @Override
    public boolean insert(Blog blog) {
        return blogMapper.insert(blog) != 0;
    }

    @Override
    public Blog showOneByCommentId(int commentId) {
        return blogMapper.selectOneByCommentId(commentId);
    }
}
