package com.taylorsfan.blog.util;

import com.taylorsfan.blog.model.Comment;
import com.taylorsfan.blog.vo.CommentVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author momo
 */
public class ConvertUtil {

    public static List<CommentVo> Comment2CommentVo(List<Comment> commentList) {
        List<CommentVo> commentVoList = new ArrayList<>();
        for (Comment comment : commentList) {
            if (comment.getParentId() == 0) {
                CommentVo commentVo = new CommentVo();
                commentVo.setId(comment.getId());
                commentVo.setCreateTime(comment.getCreateTime());
                commentVo.setContent(comment.getContent());
                commentVoList.add(commentVo);
            } else {
                for (CommentVo commentVo : commentVoList) {
                    if (commentVo.getId() == comment.getParentId()) {
                        commentVo.getCommentList().add(comment);
                    }
                }
            }
        }

        return commentVoList;
    }
}
