package com.taylorsfan.blog.controller;

import com.taylorsfan.blog.util.VerifyCodeUtils;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;


/**
 * @author taylorsfan
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/user/index")
    public String userIndex() {
        return "user/index";
    }

    @RequestMapping("/veryCode")
    public void veryCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");
        //生成随机字串
        String verifyCode = VerifyCodeUtils.generateVerifyCode(4);
        //存入会话session
        HttpSession session = request.getSession(true);
        //删除以前的
        session.removeAttribute("veryCode");
        session.setAttribute("veryCode", verifyCode.toLowerCase());
        //生成图片
        int w = 110, h = 40;
        VerifyCodeUtils.outputImage(w, h, response.getOutputStream(), verifyCode);
    }

    @RequestMapping("/uploadPic")
    public void uploadPic(HttpServletResponse response, @RequestParam(value = "editormd-image-file", required = false) MultipartFile multipartFile) {
        try {
            String pictureName = multipartFile.getOriginalFilename();
            String newFileName = UUID.randomUUID().toString() + pictureName.substring(pictureName.lastIndexOf("."));
            String uploadDir = "F:/Pictures/";
            File file = new File(uploadDir + newFileName);
            if (!file.exists()) {
                file.mkdirs();
            }
            multipartFile.transferTo(file);
            String success = "{\"success\": 1, \"message\":\"上传成功\",\"url\":\"/upload/" + newFileName + "\"}";
            response.getWriter().write(success);
        } catch (Exception e) {
            e.printStackTrace();
            try {
                response.getWriter().write("{\"success\":0, \"message\":\"上传失败\"}");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

}
