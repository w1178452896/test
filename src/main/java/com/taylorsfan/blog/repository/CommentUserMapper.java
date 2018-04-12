package com.taylorsfan.blog.repository;

import com.taylorsfan.blog.model.CommentUser;

/**
 * @author taylorsfan
 */
public interface CommentUserMapper extends BaseMapper<CommentUser> {
    int deleteByPrimaryKey(Integer id);

    int insert(CommentUser record);

    int insertSelective(CommentUser record);

    CommentUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CommentUser record);

    int updateByPrimaryKey(CommentUser record);
}