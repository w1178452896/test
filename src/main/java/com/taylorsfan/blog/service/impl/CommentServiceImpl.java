package com.taylorsfan.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taylorsfan.blog.model.Comment;
import com.taylorsfan.blog.model.relation.BlogComment;
import com.taylorsfan.blog.model.relation.UserComment;
import com.taylorsfan.blog.repository.CommentMapper;
import com.taylorsfan.blog.repository.UserMapper;
import com.taylorsfan.blog.repository.BlogCommentMapper;
import com.taylorsfan.blog.repository.UserCommentMapper;
import com.taylorsfan.blog.service.CommentService;
import com.taylorsfan.blog.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author taylorsfan
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;
    @Autowired
    private BlogCommentMapper blogCommentMapper;
    @Autowired
    private UserCommentMapper userCommentMapper;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<CommentVo> showAll(Map<String, Integer> map) {
        List<CommentVo> commentVoList = new ArrayList<>();
        List<Comment> commentList = new ArrayList<>();
        PageHelper.startPage(map.get("pageNum"), map.get("pageSize"));
        if (map.containsKey("status")) {
            if (map.containsKey("userId")) {
                /*
                 * 根据用户查询评论
                 */
                commentList = commentMapper.selectAllByUserId(map.get("userId"));
            }
            if (map.containsKey("blogId")) {
                /*
                 * 根据文章查询评论
                 */
                commentList = commentMapper.selectAllByBlogId(map.get("blogId"));
            }
            if (map.containsKey("commentId")) {
                /*
                 * 根据评论查询评论
                 */
                commentList = commentMapper.selectAllByCommentId(map.get("commentId"));
            }
        } else {
            commentList = commentMapper.selectAll();
        }
        PageInfo<Comment> pageInfo = new PageInfo<>(commentList);
        for (Comment comment : pageInfo.getList()) {
            CommentVo commentVo = new CommentVo();
            commentVo.setComment(comment);
            commentVo.setCommentUser(userMapper.selectOneByCommentId(comment.getId()));
            if (comment.getParentId() == 0) {
                commentVo.setBeCommentedUser(null);
            }
            commentVo.setBeCommentedUser(userMapper.selectOneByCommentId(comment.getParentId()));
            commentVoList.add(commentVo);
        }
        return commentVoList;
    }

    @Override
    public boolean insert(CommentVo commentVo) {
        if (commentMapper.insert(commentVo.getComment()) != 0) {
            UserComment userComment = new UserComment();
            BlogComment blogComment = new BlogComment();
            userComment.setCommentId(commentVo.getComment().getId());
            userComment.setUserId(commentVo.getCommentUser().getId());
            blogComment.setBlogId(commentVo.getBlog().getId());
            blogComment.setCommentId(commentVo.getComment().getId());
            return userCommentMapper.insert(userComment) != 0
                    && blogCommentMapper.insert(blogComment) != 0;
        }
        return false;
    }

    @Override
    public boolean deleteByCommentId(int commentId) {
        return commentMapper.updateByCommentId(commentId) != 0;
    }

    @Override
    public boolean deleteByUserId(int userId) {
        return commentMapper.updateByUserId(userId) != 0;
    }

    @Override
    public boolean deleteByBlogId(int blogId) {
        return commentMapper.deleteByBlogId(blogId) != 0;
    }

}
