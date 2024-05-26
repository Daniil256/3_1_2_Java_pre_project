package com.spring_MVC_hibernate.demo.DAO;

import com.spring_MVC_hibernate.demo.model.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// Сделал свой запрос, так как в консоли была ошибка, но все работало
// o.h.engine.jdbc.spi.SqlExceptionHelper   : SQL Error: 0, SQLState: S0022
// o.h.engine.jdbc.spi.SqlExceptionHelper   : Column 'id' not found.

public interface IUserDAO extends CrudRepository<User, Long> {
    @Modifying
    @Query(value = "insert into users (name, city, married) values (?1, ?2, ?3)",
            nativeQuery = true)
    @Transactional
    void saveUser(String name, String city, boolean isMarried);
}
