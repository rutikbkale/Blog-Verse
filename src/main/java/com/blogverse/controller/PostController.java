package com.blogverse.controller;

import com.blogverse.entity.Category;
import com.blogverse.entity.Post;
import com.blogverse.entity.User;
import com.blogverse.service.CategoryService;
import com.blogverse.service.PostService;
import com.blogverse.service.UserService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/viewAllPosts")
    public String getAllPosts(@RequestParam(required = false) Integer categoryId,
            @RequestParam(required = false) Integer userId,
            Model model) {

        List<Post> list = null;
        try {
            if (categoryId != null && categoryId != 0) {
                list = service.getAllPostsByCategoryId(categoryId);
            } else if (userId != null && userId != 0) {
                list = service.getAllPostsByUserId(userId);
            } else {
                list = service.getAllPosts();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute("posts", list);
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "user/viewPost";
    }

    @RequestMapping("/singlePost")
    public String singlePost(@RequestParam int postId, Model model) {
        Post post = null;
        try {
            post = service.getPostById(postId);
            model.addAttribute("post", post);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "user/singlePost";
    }

}
