package com.gmail.danadiadius.dao;

import java.util.Optional;
import com.gmail.danadiadius.model.User;

public interface UserDao {
    User save(User user);

    Optional<User> findByEmail(String email);

    Optional<User> findById(Long id);
}
