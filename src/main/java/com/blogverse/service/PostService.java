package com.blogverse.service;

import com.blogverse.entity.Post;
import com.blogverse.repository.PostRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public boolean addPost(Post post) {
        boolean flag = false;
        try {
            flag = repository.addPost(post);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public List<Post> getAllPosts() {
        List<Post> list = null;
        try {
            list = repository.getAllPosts();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Post> getAllPostsByCategoryId(int categoryId) {
        List<Post> list = null;
        try {
            list = repository.getAllPostsByCategoryId(categoryId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<Post> getAllPostsByUserId(int userId) {
        return repository.getAllPostsByUserId(userId);
    }

    public Post getPostById(int postId) {
        return repository.getPostById(postId);
    }

}
