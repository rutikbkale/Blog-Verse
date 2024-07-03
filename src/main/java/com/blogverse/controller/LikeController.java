package com.blogverse.controller;

import com.blogverse.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/like")
public class LikeController {

    @Autowired
    private LikeService service;

    @RequestMapping("/doLike")
    public String doLike(@RequestParam int postId, @RequestParam int userId, Model model) {
        if (service.isLikedPostByUserId(postId, userId)) {
            service.deleteLike(postId, userId);
            model.addAttribute("msg", "delete");
        } else {
            service.addLike(postId, userId);
            model.addAttribute("msg", "add");
        }
        return "post/singlePost";
    }

}
