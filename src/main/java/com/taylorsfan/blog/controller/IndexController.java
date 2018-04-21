package com.taylorsfan.blog.controller;

import com.taylorsfan.blog.model.User;
import com.taylorsfan.blog.service.CommentService;
import com.taylorsfan.blog.service.UserService;
import com.taylorsfan.blog.service.vo.BlogVoService;
import com.taylorsfan.blog.service.vo.CommentVoService;
import com.taylorsfan.blog.service.vo.UserVoService;
import com.taylorsfan.blog.util.StringsUtil;
import com.taylorsfan.blog.vo.BlogVo;
import com.taylorsfan.blog.vo.CommentVo;
import com.taylorsfan.blog.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;


/**
 * @author taylorsfan
 */
@Controller
public class IndexController {
    private final BlogVoService blogVoService;
    private final UserVoService userVoService;
    private final UserService userService;
    private final CommentVoService commentVoService;

    @Autowired
    public IndexController(BlogVoService blogVoService, UserVoService userVoService, CommentVoService commentVoService, UserService userService, CommentService commentService) {
        this.blogVoService = blogVoService;
        this.userVoService = userVoService;
        this.commentVoService = commentVoService;
        this.userService = userService;
    }

    @RequestMapping("/")
    public String index(Model model) {
        List<BlogVo> blogVoList = blogVoService.blogVoList(1, 5, 0, 0, 0,StringsUtil.FRONT);
        model.addAttribute("blogVoList", blogVoList);
        return "index";
    }

    @RequestMapping("/user/{userId}")
    public String userIndex(Model model, HttpSession httpSession, @PathVariable int userId, String span) {
        List<UserVo> userVoList;
        List<BlogVo> blogVoList;
        List<CommentVo> commentVoList;
        //从session获取user信息，减少数据库查询
        User user = (User) httpSession.getAttribute("user");
        //点击到关注按钮
        if (span.equals(StringsUtil.FOCUS)) {
            userVoList = userVoService.userVoList(userId, 0, 1, 1, 5);
            model.addAttribute("userVoList", userVoList);
        }
        //点击到粉丝按钮
        else if (span.equals(StringsUtil.FAN)) {
            userVoList = userVoService.userVoList(userId, 1, 0, 1, 5);
            model.addAttribute("userVoList", userVoList);
        }
        //点击到文章按钮
        else if (span.equals(StringsUtil.ARTICLE)) {
            blogVoList = blogVoService.blogVoList(1, 5, 1, userId, 0,StringsUtil.FRONT);
            model.addAttribute("blogVoList", blogVoList);
        }
        //点击到最新评论按钮
        else if (span.equals(StringsUtil.COMMENT)) {
            commentVoList = commentVoService.commentVoListUser(1, 20, userId);
            model.addAttribute("commentVoList", commentVoList);
        }
        UserVo userVo = userVoService.userVo(userId, user != null);
        userVo.setUser(user);
        httpSession.setAttribute("userVo", user);
        return "content";
    }

    @RequestMapping("/settings/basic")
    public String showUser(Model model, int userId) {
        model.addAttribute("user", userService.showOne(userId));
        return "user/user";
    }
    //    审核评论

}
