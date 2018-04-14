package com.taylorsfan.blog.service;

import com.taylorsfan.blog.model.Blog;

import java.util.List;

/**
 * @author taylorsfan
 */
public interface BlogService extends BaseService<Blog> {

    List<Blog> findAllNormal(int pageNum, int pageSize);

    List<Blog> findAllNeedChecked(int pageNum, int pageSize);

}
