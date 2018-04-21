package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.Blog;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author taylorsfan
 */
public interface BlogMapper {

    int insert(@Param("blog") Blog blog);

    int deleteByPrimaryKey(@Param("id") int id);

    int updateByPrimaryKey(@Param("blog") Blog blog);

    Blog selectOneByPrimaryKey(@Param("id") int id);

    /**
     * 所有
     */
    List<Blog> selectAll();

    /**
     * 根据用户id查询
     */
    List<Blog> selectAllByUserId(@Param("userId") int userId);

    /**
     * 首页
     */
    List<Blog> selectAllNormal();

    /**
     * 根据分类id查询所有文章
     */
    List<Blog> selectAllBySortId(@Param("sortId") int sortId);

    /**
     * 根据用户id和分类id查找所有文章
     */
    List<Blog> selectAllNormalBySortId(@Param("status") int status, @Param("sortId") int sortId);

    /**
     * 用户主页显示
     */
    List<Blog> selectAllNormalByUserId( @Param("userId") int userId);

    /**
     *
     */
    List<Blog> selectAllForbiddenByUserId( @Param("userId") int userId);

    /**
     * 用户首页分类查看
     */
    List<Blog> selectAllNormalBySortIdAndUserId( @Param("userId") int userId, @Param("sortId") int sortId);

    /**
     * 根据评论id查询文章
     */
    Blog selectOneByCommentId(@Param("commentId") int commentId);

    /**
     * 审核
     */
    int updateBlogByStatus(@Param("status") int status, @Param("blogId") int blogId);


}