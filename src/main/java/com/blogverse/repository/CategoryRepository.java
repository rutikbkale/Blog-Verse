package com.blogverse.repository;

import com.blogverse.entity.Category;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepository {

    @Autowired
    private HibernateTemplate template;

    public List<Category> getAllCategories() {
        List<Category> list = null;
        try {
            list = template.loadAll(Category.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Category getCategoryById(int categoryId) {
        Category category = null;
        try {
            category = template.get(Category.class, categoryId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return category;
    }

}
