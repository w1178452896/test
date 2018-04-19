package com.taylorsfan.blog.controller;

import com.taylorsfan.blog.model.Comment;
import com.taylorsfan.blog.model.relation.BlogComment;
import com.taylorsfan.blog.model.relation.UserComment;
import com.taylorsfan.blog.service.BlogService;
import com.taylorsfan.blog.service.CommentService;
import com.taylorsfan.blog.service.UserService;
import com.taylorsfan.blog.service.relation.BlogCommentService;
import com.taylorsfan.blog.service.relation.UserCommentService;
import com.taylorsfan.blog.util.MapUtil;
import com.taylorsfan.blog.util.ResultUtil;
import com.taylorsfan.blog.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author taylorsfan
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;
    private final UserCommentService userCommentService;
    private final BlogCommentService blogCommentService;
    private final UserService userService;
    private final BlogService blogService;

    @Autowired
    public CommentController(CommentService commentService, UserCommentService userCommentService,
                             BlogCommentService blogCommentService, UserService userService,
                             BlogService blogService) {
        this.commentService = commentService;
        this.blogCommentService = blogCommentService;
        this.userCommentService = userCommentService;
        this.blogService = blogService;
        this.userService = userService;
    }

    @ResponseBody
    @RequestMapping("/insert")
    public ResultUtil insert(CommentVo commentVo) {
        if (commentService.insert(commentVo.getComment())) {
            UserComment userComment = new UserComment();
            BlogComment blogComment = new BlogComment();
            blogComment.setBlogId(commentVo.getBlogId());
            blogComment.setCommentId(commentVo.getComment().getId());
            userComment.setUserId(commentVo.getCommentUser().getId());
            userComment.setCommentId(commentVo.getComment().getId());
            if (userCommentService.insert(userComment) && blogCommentService.insert(blogComment)) {
                return new ResultUtil(200, "success");
            }
            return new ResultUtil(400, "failure");
        }
        return new ResultUtil(400, "failure");
    }

    @ResponseBody
    @RequestMapping("/{commentId}/delete")
    public ResultUtil deleteByCommentId(@PathVariable int commentId) {
        if (commentService.deleteByCommentId(commentId)) {
            return new ResultUtil(200, "success");
        }
        return new ResultUtil(400, "failure");
    }

    //    审核页面
    @RequestMapping("/check")
    public ResultUtil checkByCommentId(int commentId) {
        if (commentService.updateByChecker(commentId)) {
            return new ResultUtil(200, "success");
        }
        return new ResultUtil(400, "failure");
    }

    //文章页面显示的评论
    @RequestMapping("/all/blog")
    public String commentVoListBlog(Model model, int pageNum, int pageSize, int blogId) {
        Map<String, Integer> map = MapUtil.int2map(pageNum, pageSize);
        map.put("blogId", blogId);
        List<Comment> commentList = commentService.showAll(map);
        List<CommentVo> commentVoList = new ArrayList<>();
        for (Comment comment : commentList) {
            CommentVo commentVo = new CommentVo();
            commentVo.setBlogId(blogId);
            commentVo.setComment(comment);
            commentVo.setCommentUser(userService.showUserByCommentId(comment.getId()));
            if (comment.getParentId() != 0) {
                commentVo.setBeCommentedUser(userService.showUserByCommentId(comment.getParentId()));
            } else {
                commentVo.setBeCommentedUser(userService.showUserByBlogId(blogId));
            }
            commentVoList.add(commentVo);
        }
        model.addAttribute("commentVoList", commentVoList);
        return "list/commentVos";
    }

    //    个人主页的评论
    @RequestMapping("/all/user")
    public String commentVoListUser(Model model, int pageNum, int pageSize, int userId) {
        Map<String, Integer> map = MapUtil.int2map(pageNum, pageSize);
        map.put("userId", userId);
        List<Comment> commentList = commentService.showAll(map);
        List<CommentVo> commentVoList = new ArrayList<>();
        for (Comment comment : commentList) {
            CommentVo commentVo = new CommentVo();
            commentVo.setComment(comment);
            int blogId = blogService.showOneByCommentId(comment.getId()).getId();
            commentVo.setBlogId(blogId);
            commentVo.setCommentUser(userService.showOne(userId));
            if (comment.getParentId() != 0) {
                commentVo.setBeCommentedUser(userService.showUserByCommentId(comment.getParentId()));
            } else {
                commentVo.setBeCommentedUser(userService.showUserByBlogId(blogId));
            }
            commentVoList.add(commentVo);
        }
        model.addAttribute("commentVoList", commentVoList);
        return "list/commentVos";
    }

    /*
    @ResponseBody
    @RequestMapping("/list/testAll")
    public List<CommentVo> adminAll() {
        Map<String, Integer> map = MapUtil.int2map(1, 2);
        List<Comment> commentList = commentService.showAll(map);
        List<CommentVo> commentVoList = new ArrayList<>();
        for (Comment comment : commentList) {
            CommentVo commentVo = new CommentVo();
            commentVo.setComment(comment);
            int blogId = blogService.showOneByCommentId(comment.getId()).getId();
            commentVo.setBlogId(blogId);
            commentVo.setCommentUser(userService.showUserByCommentId(comment.getId()));
            if (comment.getParentId() != 0) {
                commentVo.setBeCommentedUser(userService.showUserByCommentId(comment.getParentId()));
            } else {
                commentVo.setBeCommentedUser(userService.showUserByBlogId(blogId));
            }
            commentVoList.add(commentVo);
        }
        return commentVoList;

    }*/

}
