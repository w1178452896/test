package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.Blog;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author taylorsfan
 */
public interface BlogMapper {
    List<Blog> selectAll();

    Blog selectOneByPrimaryKey(Integer id);

    Integer insert(Blog blog);

    Integer deleteByPrimaryKey(Integer id);

    Integer updateByPrimaryKey(Blog record);

    /**
     * 根据用户id查找所有文章
     */
    List<Blog> selectAllByUserId(Integer userId);

    /**
     * 根据文章状态显示所有文章
     */
    List<Blog> selectAllByStatus(Integer status);

    /**
     * 根据分类id查询所有文章
     */
    List<Blog> selectAllBySortId(Integer sortId);

    /**
     * 根据用户id和状态查找所有文章
     */
    List<Blog> selectAllByUserIdAndStatus(Map<String, Integer> map);

    /**
     * 根据用户id获取收藏的文章
     */
    List<Blog> selectAllCollectByUserIdAndSort(int userId);

    /**
     * 根据评论id查询文章
     */

    Blog selectOneByCommentId(int commentId);

}