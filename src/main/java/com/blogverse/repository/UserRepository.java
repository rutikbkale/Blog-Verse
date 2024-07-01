package com.blogverse.repository;

import com.blogverse.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UserRepository {

    // creating hibernate template refference to perform database related operatios
    @Autowired
    private HibernateTemplate template;

    @Transactional
    public boolean saveUser(User user) {
        boolean flag = false;
        try {
            template.save(user);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public User validUser(String mobNo, String password) {
        User user = null;
        try {
            String hql = "FROM User WHERE mobNo = ? AND password = ?";
            user = (User) template.find(hql, mobNo, password).stream().findFirst().orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Transactional
    public boolean editUser(User user) {
        boolean flag = false;
        try {
            template.update(user);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public User getUser(int userId) {
        User user = null;
        try {
            user = template.get(User.class, userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

}
