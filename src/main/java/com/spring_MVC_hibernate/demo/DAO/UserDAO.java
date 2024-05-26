package com.spring_MVC_hibernate.demo.DAO;

import com.spring_MVC_hibernate.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserDAO {

    IUserDAO userDAO;
    
    @Autowired
    public UserDAO(IUserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void saveUser(String name, String city, boolean isMarried) {
        userDAO.saveUser(name, city, isMarried);
    }


    public Iterable<User> findAllUsers() {
        return userDAO.findAll();
    }


    public Optional<User> findByIdUser(Long id) {
        return userDAO.findById(id);
    }


    public void deleteByIdUser(Long id) {
        userDAO.deleteById(id);
    }


    public void deleteAllUsers() {
        userDAO.deleteAll();
    }


    public void updateUser(User user) {
        userDAO.save(user);
    }
}
