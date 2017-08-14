package com.github.xkylin.example.springmvc.web.controller;

import com.github.xkylin.example.springmvc.entities.User;
import com.github.xkylin.example.springmvc.exception.UserRegisterException;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 用户控制器
 * @author Xkylin
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping(value = "/info")
    public String info() {
        return "/user/info";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(HttpServletRequest request, HttpServletResponse response, @RequestParam("headImage") MultipartFile file) throws UserRegisterException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String realPath = request.getServletContext().getRealPath("/") + "temp/";


        List<User> users = new ArrayList<>();

        if (userName == null || userName.length() == 0) {
            throw new UserRegisterException("没有用户名");
        } else if (password == null || password.length() == 0) {
            throw new UserRegisterException("没有密码");
        } else if (file.getOriginalFilename().length() == 0) {
            throw new UserRegisterException("没有头像");
        }
        //存放头像到工程根目录的temp目录中
        FileUtils.writeByteArrayToFile(new File(realPath + file.getOriginalFilename()), file.getBytes());
        users.add(new User(1L, "Eugene", "88888888", file.getBytes()));
        users.add(new User(2L, "Xkylin", "66666666", file.getBytes()));
        request.setAttribute("users", users);
        System.out.println(file);
        System.out.println(file.getInputStream());

        return "/user/info";
    }
}
