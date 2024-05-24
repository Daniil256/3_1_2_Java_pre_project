package com.spring_MVC_hibernate.demo.service;

import com.spring_MVC_hibernate.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final IUserService service;

    @Autowired
    public UserService(IUserService service) {
        this.service = service;
    }

    public void saveUser(User user) {
        service.saveUser(user.getName(), user.getCity(), user.isMarried());
    }

    public Iterable<User> findAllUsers() {
        return service.findAll();
    }

    public Optional<User> findByIdUser(Long id) {
        return service.findById(id);
    }

    public void deleteByIdUser(Long id) {
        service.deleteById(id);
    }

    public void deleteAllUsers() {
        service.deleteAll();
    }

    public void updateUser(User user) {
        service.save(user);
    }
}
