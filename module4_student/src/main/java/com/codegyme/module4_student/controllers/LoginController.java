package com.codegyme.module4_student.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    @GetMapping("/login")
    public String showPageLogin(@CookieValue(value="userName",defaultValue = "") String userName, @CookieValue(value="password",defaultValue = "") String password, Model model) {
        model.addAttribute("userName", userName);
        model.addAttribute("password", password);
        return "security/login";
    }
    @PostMapping("/login")
    public String login(@RequestParam String userName, @RequestParam String password, @RequestParam(value = "rememberMe", defaultValue = "false") boolean rememberMe, HttpServletResponse response, Model model) {
        if (rememberMe){
            Cookie cookieUserName = new Cookie("userName", userName);
            cookieUserName.setHttpOnly(true);
            cookieUserName.setMaxAge(3600);
            response.addCookie(cookieUserName);
            Cookie cookiePassword = new Cookie("password", password);
            cookiePassword.setHttpOnly(true);
            cookiePassword.setMaxAge(3600);
            response.addCookie(cookiePassword);
        }
        return "redirect:/student";
    }
}
