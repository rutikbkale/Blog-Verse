package com.blogverse.controller;

import com.blogverse.entity.Category;
import com.blogverse.service.CategoryService;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @RequestMapping("/getCategories")
    public String getAllCategories(HttpSession session) {
        List<Category> list = null;
        try {
            list = service.getAllCategories();
            session.setAttribute("categories", list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:../user/addPost";
    }

}
