package com.blogverse.controller;

import com.blogverse.entity.User;
import com.blogverse.service.UserService;
import javax.persistence.PostRemove;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    // creating user service refference to serve client request to service layer
    @Autowired
    private UserService service;

    @RequestMapping("/dashboard")
    public String userDashboard() {
        return "user/dashboard";
    }

    @PostMapping("/signupForm")
    public String signUp(@ModelAttribute User user, HttpSession session) {
        boolean flag = false;
        try {
            flag = service.saveUser(user);
            if (flag) {
                session.setAttribute("msg", flag);
            } else {
                session.setAttribute("msg", false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/signup";
    }

    @PostMapping("/signinForm")
    public String signIn(@RequestParam String mobNo, @RequestParam String password, HttpSession session) {
        User user = null;
        try {
            user = service.validUser(mobNo, password);
            if (user != null) {
                session.setAttribute("currentUser", user);
                session.setAttribute("msg", "done");
            } else {
                session.setAttribute("msg", "error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/signin";
    }

    @PostMapping("/editForm")
    public String editForm(@RequestParam int userId,
            @RequestParam String firstName,
            @RequestParam String lastName,
            @RequestParam String email,
            @RequestParam String dob, HttpSession session) {

        User user = null;
        try {
            user = service.editUser(userId, firstName, lastName, email, dob);
            if (user != null) {
                session.setAttribute("currentUser", user);
                session.setAttribute("msg", "done");
            } else {
                session.setAttribute("msg", "error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:dashboard";
    }

    @PostMapping("/changePassword")
    public String changePassword(@RequestParam String password, @RequestParam int userId, HttpSession session) {
        User user = null;
        try {
            user = service.changePassword(userId, password);
            if (user != null) {
                session.setAttribute("currentUser", user);
                session.setAttribute("msg", "done");
            } else {
                session.setAttribute("msg", "error");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:dashboard";
    }

}
