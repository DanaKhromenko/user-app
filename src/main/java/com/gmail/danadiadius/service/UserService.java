package com.gmail.danadiadius.service;

import java.util.Optional;
import com.gmail.danadiadius.model.User;

public interface UserService {
    User save(User user);

    Optional<User> findById(Long id);

    Optional<User> findByEmail(String email);
}
