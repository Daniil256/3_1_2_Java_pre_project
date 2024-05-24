package com.spring_MVC_hibernate.demo.service;


import com.spring_MVC_hibernate.demo.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// Сделал свой запрос, так как в консоли была ошибка, но все работало
// o.h.engine.jdbc.spi.SqlExceptionHelper   : SQL Error: 0, SQLState: S0022
// o.h.engine.jdbc.spi.SqlExceptionHelper   : Column 'id' not found.

@Service
public interface IUserService extends CrudRepository<User, Long> {
    @Modifying
    @Query(value = "insert into users (name, city, married) values (?1, ?2, ?3)",
            nativeQuery = true)
    @Transactional
    void saveUser(String name, String city, Boolean married);
}
