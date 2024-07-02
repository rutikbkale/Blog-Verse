package com.blogverse.repository;

import com.blogverse.entity.User;
import java.util.List;
import org.hibernate.Query;
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
        User user = template.execute(session -> {
            Query<User> query = session.createQuery("FROM User WHERE mobNo = :mobNo AND password = :password", User.class);
            query.setParameter("mobNo", mobNo);
            query.setParameter("password", password);
            return query.uniqueResult();
        });
        return user;
    }

    @Transactional
    public User editUser(int userId, String firstName, String lastName, String email, String dob) {
        User user = template.execute(session -> {
            // Fetch the user based on some identifier (e.g., user ID)
            Query<User> query = session.createQuery("FROM User WHERE userId = :userId", User.class);
            query.setParameter("userId", userId);  // Set the parameter for user ID
            User fetchedUser = query.uniqueResult();

            if (fetchedUser != null) {
                // Update the user's details
                fetchedUser.setFirstName(firstName);
                fetchedUser.setLastName(lastName);
                fetchedUser.setEmail(email);
                fetchedUser.setDob(dob);

                // Save the updated user back to the database
                session.update(fetchedUser);
            }

            return fetchedUser;
        });

        return user;
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

    @Transactional
    public User changePassword(int userId, String password) {
        User user = template.execute(session -> {
            // Fetch the user based on some identifier (e.g., user ID)
            Query<User> query = session.createQuery("FROM User WHERE userId = :userId", User.class);
            query.setParameter("userId", userId);  // Set the parameter for user ID
            User fetchedUser = query.uniqueResult();

            if (fetchedUser != null) {
                fetchedUser.setPassword(password);
                session.update(fetchedUser);
            }
            return fetchedUser;
        });
        return user;
    }
}
