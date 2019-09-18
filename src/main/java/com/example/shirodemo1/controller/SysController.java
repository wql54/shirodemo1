package com.example.shirodemo1.controller;

import com.example.shirodemo1.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class SysController {

    @RequestMapping({"/", "/index"})
    public String index() {
        return "/index";
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

    @PostMapping("login")
    @ResponseBody
    public String login(User user, HttpSession session) {
        Map map = new HashMap();
        System.out.println("login");
        Subject subject = SecurityUtils.getSubject();
        System.out.println("login1");
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
        System.out.println("login2");
        try {
            System.out.println("login3");
            subject.login(token);
            System.out.println("login4");
        } catch (UnknownAccountException uae) {
            return "未知账户";
        } catch (IncorrectCredentialsException ice) {
            return "密码不正确";
        } catch (LockedAccountException lae) {
            return "账户已锁定";
        } catch (ExcessiveAttemptsException eae) {
            return "用户名或密码错误次数过多";
        } catch (AuthenticationException ae) {
            return "用户名或密码不正确！";
        }
        if (subject.isAuthenticated()) {
            return "登录成功";
        } else {
            token.clear();
            return "登录失败";
        }

//        User selectbyusername = userService.selectbyusername(user.getUsername());
//        if (selectbyusername.getPassword().equals(user.getPassword())) {
//            System.out.println("登录成功！");
//            session.setAttribute("user",user);
//            return "redirect:/user/firstPage";
//        }else{
//            return "/login";
//        }
    }

    @PostMapping("logout")
    public String logout() {
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.logout();
        return "/login";
    }
}
