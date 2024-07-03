package com.blogverse.repository;

import com.blogverse.entity.Liked;
import com.blogverse.entity.Post;
import com.blogverse.entity.User;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LikeRepository {

    @Autowired
    private HibernateTemplate template;

    @Transactional
    public boolean addLike(int postId, int userId) {
        boolean flag = false;
        try {
            flag = template.execute((session) -> {
                User user = session.get(User.class, userId);
                Post post = session.get(Post.class, postId);

                if (user != null && post != null) {
                    Liked like = new Liked();
                    like.setUser(user);
                    like.setPost(post);
                    session.save(like);
                    return true;
                }
                return false;
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Transactional
    public int getCountByPostId(int postId) {
        long count = 0;
        try {
            count = template.execute((session) -> {
                Query<Long> query = session.createQuery("SELECT COUNT(l) FROM Liked l WHERE l.post.postId = :postId", Long.class);
                query.setParameter("postId", postId);
                return query.uniqueResult();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (int) count;
    }

    public boolean isLikedPostByUserId(int postId, int userId) {
        long res = 0;
        try {
            res = template.execute((session) -> {
                Query<Long> query = session.createQuery("SELECT COUNT(l) FROM Liked l WHERE l.post.postId = :postId AND l.user.userId = :userId", Long.class);
                query.setParameter("postId", postId);
                query.setParameter("userId", userId);
                return query.uniqueResult();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res > 0;
    }

    @Transactional
    public boolean deleteLike(int postId, int userId) {
        int res = 0;
        try {
            res = template.execute((session) -> {
                Query query = session.createQuery("DELETE FROM Liked WHERE post.postId = :postId AND user.userId = :userId");
                query.setParameter("postId", postId);
                query.setParameter("userId", userId);
                return query.executeUpdate();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res > 0;
    }

}
