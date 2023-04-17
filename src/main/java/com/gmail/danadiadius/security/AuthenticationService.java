package com.gmail.danadiadius.security;

import com.gmail.danadiadius.exception.AuthenticationException;
import com.gmail.danadiadius.model.User;

public interface AuthenticationService {
    User register(String email, String password);

    User login(String login, String password) throws AuthenticationException;
}
