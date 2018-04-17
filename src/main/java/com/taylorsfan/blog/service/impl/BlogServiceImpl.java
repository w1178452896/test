package com.taylorsfan.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taylorsfan.blog.model.Blog;
import com.taylorsfan.blog.model.relation.UserBlog;
import com.taylorsfan.blog.repository.BlogMapper;
import com.taylorsfan.blog.repository.SortMapper;
import com.taylorsfan.blog.repository.UserMapper;
import com.taylorsfan.blog.repository.BlogUserMapper;
import com.taylorsfan.blog.repository.UserBlogMapper;
import com.taylorsfan.blog.service.BlogService;
import com.taylorsfan.blog.vo.BlogVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author taylorsfan
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;
    @Autowired
    private UserBlogMapper userBlogMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private SortMapper sortMapper;
    @Autowired
    private BlogUserMapper blogUserMapper;

    @Override
    public List<BlogVo> showAll(Map<String, Integer> map) {
        List<BlogVo> blogVoList = new ArrayList<>();
        List<Blog> blogList = new ArrayList<>();
        PageHelper.startPage(map.get("pageNum"), map.get("pageSize"));
        if (map.containsKey("userId") && map.containsKey("status")) {
            map.remove("pageNum");
            map.remove("pageSize");
            blogList = blogMapper.selectAllByUserIdAndStatus(map);
        } else if (!map.containsKey("userId") && map.containsKey("status")) {
            blogList = blogMapper.selectAllByStatus(map.get("status"));
        } else if (!map.containsKey("userId") && !map.containsKey("status")) {
            blogList = blogMapper.selectAll();
        }
        PageInfo<Blog> pageInfo = new PageInfo<>(blogList);
        for (Blog blog : pageInfo.getList()) {
            BlogVo blogVo = new BlogVo();
            blogVo.setBlog(blog);
            blogVo.setUser(userMapper.selectOneByBlogId(blog.getId()));
            blogVo.setSort(sortMapper.selectOneByBlogId(blog.getId()));
            blogVo.setCountUser(blogUserMapper.count(blog.getId()));
            blogVoList.add(blogVo);
        }
        return blogVoList;
    }

    @Override
    public BlogVo show(int blogId) {
        BlogVo blogVo = new BlogVo();
        blogVo.setBlog(blogMapper.selectOneByPrimaryKey(blogId));
        blogVo.setUser(userMapper.selectOneByBlogId(blogId));
        blogVo.setCountUser(blogUserMapper.count(blogId));
        return blogVo;
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
    public boolean insert(BlogVo blogVo) {
        if (blogMapper.insert(blogVo.getBlog()) != 0) {
            UserBlog userBlog = new UserBlog();
            userBlog.setBlog(blogVo.getBlog().getId());
            userBlog.setUserId(blogVo.getUser().getId());
            return userBlogMapper.insert(userBlog) != 0;
        }
        return false;
    }
}
