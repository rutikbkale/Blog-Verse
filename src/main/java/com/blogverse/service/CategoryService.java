package com.blogverse.service;

import com.blogverse.entity.Category;
import com.blogverse.repository.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {
    
    @Autowired
    private CategoryRepository repository;
    
    public List<Category> getAllCategories() {
        List<Category> list = null;
        try {
            list = repository.getAllCategories();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public Category getCategoryById(int categoryId) {
        Category category = null;
        try {
            category = repository.getCategoryById(categoryId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return category;
    }
    
}
