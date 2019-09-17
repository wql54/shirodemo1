package com.example.shirodemo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class SysController {

    @RequestMapping({"/","/index"})
    public String index(){
        return"/index";
    }

    @GetMapping("login")
    public String loginPage() {
        return "/login";
    }

    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "/login";
    }

}
