package com.spring_MVC_hibernate.demo.service;

import com.spring_MVC_hibernate.demo.model.User;

import java.util.Optional;

public interface IUserService {

    void saveUser(String name, String city, boolean isMarried);

    Iterable<User> findAllUsers();

    Optional<User> findByIdUser(Long id);

    void deleteByIdUser(Long id);

    void deleteAllUsers();

    void updateUser(User user);
}
