package com.blogverse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

    // landing page
    @RequestMapping("/")
    public String index() {
        return "index";
    }
    
    // landing page
    @RequestMapping("/home")
    public String home() {
        return "index";
    }

    // handelling sign up request from user
    @RequestMapping("/signup")
    public String signup() {
        return "signup";
    }

    // handelling sign in request from user
    @RequestMapping("/signin")
    public String signin() {
        return "signin";
    }

}
