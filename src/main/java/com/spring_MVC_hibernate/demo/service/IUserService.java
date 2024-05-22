package com.spring_MVC_hibernate.demo.service;


import com.spring_MVC_hibernate.demo.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public interface IUserService extends CrudRepository<User, Long> {
}
