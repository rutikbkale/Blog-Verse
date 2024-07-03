package com.blogverse.service;

import com.blogverse.entity.Liked;
import com.blogverse.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LikeService {

    @Autowired
    private LikeRepository repository;

    public boolean addLike(int postId, int userId) {
        return repository.addLike(postId, userId);
    }

    public int getCountByPostId(int postId) {
        return repository.getCountByPostId(postId);
    }

    public boolean isLikedPostByUserId(int postId, int userId) {
        return repository.isLikedPostByUserId(postId, userId);
    }

    public boolean deleteLike(int postId, int userId) {
        return repository.deleteLike(postId, userId);
    }

}
