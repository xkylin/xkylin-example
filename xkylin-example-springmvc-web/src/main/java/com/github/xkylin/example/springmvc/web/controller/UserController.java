package com.github.xkylin.example.springmvc.web.controller;

import com.github.xkylin.example.springmvc.entities.User;
import com.github.xkylin.example.springmvc.exception.UserRegisterException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public String register(HttpServletRequest request, HttpServletResponse response, MultipartFile file) throws UserRegisterException, IOException {
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        List<User> users = new ArrayList<>();

        if (userName == null || userName.length() == 0) {
            throw new UserRegisterException("没有用户名");
        } else if (file.getOriginalFilename().length() == 0) {
            throw new UserRegisterException("没有头像");
        }
        users.add(new User(1L, "Eugene", "88888888", file.getBytes()));
        users.add(new User(2L, "Xkylin", "66666666", file.getBytes()));
        request.setAttribute("users", users);
        System.out.println(file);
        System.out.println(file.getInputStream());

        return "/user/info";
    }
}
