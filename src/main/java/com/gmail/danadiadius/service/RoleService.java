package com.gmail.danadiadius.service;

import com.gmail.danadiadius.model.Role;

public interface RoleService {
    Role save(Role role);

    Role getRoleByName(String roleName);
}
