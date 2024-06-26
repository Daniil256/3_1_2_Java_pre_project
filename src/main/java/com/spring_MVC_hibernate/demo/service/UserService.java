package com.spring_MVC_hibernate.demo.service;

import com.spring_MVC_hibernate.demo.DAO.UserDAO;
import com.spring_MVC_hibernate.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService implements IUserService {
    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public void saveUser(String name, String city, boolean isMarried) {
        userDAO.saveUser(name, city, isMarried);
    }

    @Override
    public Iterable<User> findAllUsers() {
        return userDAO.findAllUsers();
    }

    @Override
    public Optional<User> findByIdUser(Long id) {
        return userDAO.findByIdUser(id);
    }

    @Override
    public void deleteByIdUser(Long id) {
        userDAO.deleteByIdUser(id);
    }

    @Override
    public void deleteAllUsers() {
        userDAO.deleteAllUsers();
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }
}
