package com.gmail.danadiadius.controller;

import com.gmail.danadiadius.model.Role;
import com.gmail.danadiadius.security.AuthenticationService;
import com.gmail.danadiadius.service.RoleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inject")
public class InjectController {
    private final RoleService roleService;

    private final AuthenticationService authenticationService;

    public InjectController(RoleService roleService,
                            AuthenticationService authenticationService) {
        this.roleService = roleService;
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public String injectData() {
        roleService.save(new Role(Role.RoleName.ADMIN));
        roleService.save(new Role(Role.RoleName.USER));

        authenticationService.register("danadiadius@gmail.com", "Password_123");
        authenticationService.register("vadim.khromenko98@gmail.com", "AnotherPassword123!");

        return "Done!";
    }
}
