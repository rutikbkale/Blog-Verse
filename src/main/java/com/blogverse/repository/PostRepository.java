package com.blogverse.repository;

import com.blogverse.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PostRepository {

    @Autowired
    private HibernateTemplate template;

    @Transactional
    public boolean addPost(Post post) {
        boolean flag = false;
        try {
            template.save(post);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

}
