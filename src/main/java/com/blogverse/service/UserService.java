package com.blogverse.service;

import com.blogverse.entity.User;
import com.blogverse.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // creating user repository refference to serve client request to repository layer
    @Autowired
    private UserRepository repository;

    public boolean saveUser(User user) {
        boolean flag = false;
        try {
            flag = repository.saveUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public User validUser(String mobNo, String password) {
        User user = null;
        try {
            user = repository.validUser(mobNo, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean editUser(User user) {
        boolean flag = false;
        try {
            flag = repository.editUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public User getUser(int userId) {
        User user = null;
        try {
            user = repository.getUser(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

}
