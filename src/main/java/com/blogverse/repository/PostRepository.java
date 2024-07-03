package com.blogverse.repository;

import com.blogverse.entity.Post;
import java.util.List;
import org.hibernate.Query;
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

    public List<Post> getAllPosts() {
        List<Post> list = null;
        try {
            list = template.loadAll(Post.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Post> getAllPostsByCategoryId(int categoryId) {
        List<Post> list = template.execute(session -> {
            Query<Post> query = session.createQuery("FROM Post WHERE category.categoryId = :categoryId", Post.class);
            query.setParameter("categoryId", categoryId);
            return query.list();
        });
        return list;
    }

    public List<Post> getAllPostsByUserId(int userId) {
        return template.execute(session -> {
            Query<Post> query = session.createQuery("FROM Post WHERE user.userId = :userId", Post.class);
            query.setParameter("userId", userId);
            return query.list();
        });
    }

}
