package com.gmail.danadiadius.controller;

import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import com.gmail.danadiadius.exception.AuthenticationException;
import com.gmail.danadiadius.model.User;
import com.gmail.danadiadius.model.dto.UserLoginDto;
import com.gmail.danadiadius.model.dto.UserRegistrationDto;
import com.gmail.danadiadius.security.AuthenticationService;
import com.gmail.danadiadius.security.jwt.JwtTokenProvider;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final JwtTokenProvider jwtTokenProvider;

    public AuthenticationController(AuthenticationService authenticationService,
                                    JwtTokenProvider jwtTokenProvider) {
        this.authenticationService = authenticationService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/register")
    public void register(@RequestBody @Valid UserRegistrationDto userRequestDto) {
        authenticationService.register(userRequestDto.getEmail(), userRequestDto.getPassword());
    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody @Valid UserLoginDto userLoginDto)
            throws AuthenticationException {
        User user = authenticationService.login(userLoginDto.getLogin(),
                userLoginDto.getPassword());
        List<String> roles = user.getRoles().stream()
                .map(role -> role.getRoleName().name())
                .toList();
        String token = jwtTokenProvider.createToken(user.getEmail(), roles);
        return new ResponseEntity<>(Map.of("token", token), HttpStatus.OK);
    }
}
