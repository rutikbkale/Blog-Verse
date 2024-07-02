package com.blogverse.service;

import com.blogverse.entity.Post;
import com.blogverse.repository.PostRepository;
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

}
