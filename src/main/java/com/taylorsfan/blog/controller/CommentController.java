package com.taylorsfan.blog.controller;

import com.taylorsfan.blog.service.CommentService;
import com.taylorsfan.blog.util.MapUtil;
import com.taylorsfan.blog.util.ResultUtil;
import com.taylorsfan.blog.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author taylorsfan
 */
@Controller
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //文章页面显示的评论
    @RequestMapping("/list/blog")
    public String commentVoListBlog(Model model, Integer pageNum, Integer pageSize, Integer blogId) {
        Map<String, Integer> map = MapUtil.int2map(pageNum, pageSize);
        map.put("blogId", blogId);
        model.addAttribute("commentVoList", commentService.showAll(map));
        return "list/commentVos";
    }

    //    个人主页的评论
    @RequestMapping("/list/user")
    public String commentVoListUser(Model model, Integer pageNum, Integer pageSize, Integer userId) {
        Map<String, Integer> map = MapUtil.int2map(pageNum, pageSize);
        map.put("userId", userId);
        model.addAttribute("commentVoList", commentService.showAll(map));
        return "list/commentVos";
    }

    //    显示两个人之间的评论
    @RequestMapping("/list/comment")
    public String commentVoListComment(Model model, Integer pageNum, Integer pageSize, Integer commentId) {
        Map<String, Integer> map = MapUtil.int2map(pageNum, pageSize);
        map.put("commentId", commentId);
        model.addAttribute("commentVoList", commentService.showAll(map));
        return "list/commentVos";
    }

    @ResponseBody
    @RequestMapping("/insert")
    public ResultUtil insert(CommentVo commentVo) {
        if (commentService.insert(commentVo)) {
            return new ResultUtil(200, "success");
        }
        return new ResultUtil(400, "failure");
    }

    @ResponseBody
    @RequestMapping("/delete/comment/{commentId}")
    public ResultUtil deleteByCommentId(@PathVariable Integer commentId) {
        if (commentService.deleteByCommentId(commentId)) {
            return new ResultUtil(200, "success");
        }
        return new ResultUtil(400, "failure");
    }

    @ResponseBody
    @RequestMapping("/delete/blog/{blogId}")
    public ResultUtil deleteByBlogId(@PathVariable Integer blogId) {
        if (commentService.deleteByBlogId(blogId)) {
            return new ResultUtil(200, "success");
        }
        return new ResultUtil(400, "failure");
    }

    @ResponseBody
    @RequestMapping("/delete/user/{userId}")
    public ResultUtil deleteByUserId(@PathVariable Integer userId) {
        if (commentService.deleteByUserId(userId)) {
            return new ResultUtil(200, "success");
        }
        return new ResultUtil(400, "failure");
    }
}
