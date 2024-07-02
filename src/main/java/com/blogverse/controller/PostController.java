package com.blogverse.controller;

import com.blogverse.entity.Category;
import com.blogverse.entity.Post;
import com.blogverse.entity.User;
import com.blogverse.service.CategoryService;
import com.blogverse.service.PostService;
import com.blogverse.service.UserService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService service;

    @Autowired
    private UserService userService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/addPostForm")
    public String addPost(@ModelAttribute Post post, HttpSession session) {
        boolean flag = false;
        try {
            User currentUser = userService.getUser(post.getUser().getUserId());
            post.setUser(currentUser);

            Category category = categoryService.getCategoryById(post.getCategory().getCategoryId());
            post.setCategory(category);

            flag = service.addPost(post);
            if (flag) {
                session.setAttribute("msg", "done");
            } else {
                session.setAttribute("msg", "done");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:../user/addPost";
    }

}
