package com.taylorsfan.blog.service;

import com.taylorsfan.blog.model.Blog;
import com.taylorsfan.blog.vo.BlogVo;

import java.util.List;
import java.util.Map;

/**
 * @author taylorsfan
 */
public interface BlogService {


    /**
     * 后台显示所有文章
     * 首页显示的正常的文章Vo
     * 首页显示的审核中的文章
     * 审核页面显示的需要被审核的文章
     * 显示
     * 用户正常的文章；
     * 被封禁的文章；
     * 正在审核中的文章。
     */
    List<BlogVo> showAll(Map<String, Integer> map);

    /**
     * 根据文章id显示文章内容
     */
    BlogVo show(int blogId);

    /**
     * 更新文章
     */

    boolean update(Blog blog);

    /**
     * 删除文章
     */
    boolean delete(int blogId);

    /**
     * 新写文章
     */
    boolean insert(BlogVo blogVo);
}
