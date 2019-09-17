package com.example.shirodemo1.controller;

import com.example.shirodemo1.entity.User;
import com.example.shirodemo1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;



    @GetMapping("firstPage")
    public String firstPage() {
        return "/firstPage";
    }

    @PostMapping("login")
    public String login(User user, HttpSession session) {
        Map map = new HashMap();
        User selectbyusername = userService.selectbyusername(user.getUsername());
        if (selectbyusername.getPassword().equals(user.getPassword())) {
            System.out.println("登录成功！");
            session.setAttribute("user",user);
            return "redirect:/user/firstPage";
        }else{
            return "/login";
        }
    }


}
