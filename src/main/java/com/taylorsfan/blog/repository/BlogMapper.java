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
     * 根据状态查询
     */
    List<Blog> selectAllByStatus(@Param("status") int status);

    /**
     * 根据分类id查询所有文章
     */
    List<Blog> selectAllBySortId(@Param("sortId") int sortId);

    /**
     * 根据用户id和分类id查找所有文章
     */
    List<Blog> selectAllByStatusAndSortId(@Param("status") int status, @Param("sortId") int sortId);

    /**
     * 根据用户id和状态查找所有文章
     */
    List<Blog> selectAllByStatusAndUserId(@Param("status") int status, @Param("userId") int userId);

    /**
     * 根据用户id和分类查找所有文章
     */
    List<Blog> selectAllBySortIdAndUserId(@Param("sortId") int sortId, @Param("userId") int userId);

    /**
     * 根据用户和分类和状态查找文章
     */
    List<Blog> selectAllByStatusAndSortIdAndUserId(@Param("status") int status, @Param("userId") int userId, @Param("sortId") int sortId);

    /**
     * 根据评论id查询文章
     */
    Blog selectOneByCommentId(@Param("commentId") int commentId);


}