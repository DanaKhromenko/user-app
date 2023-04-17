package com.gmail.danadiadius.dao;

import java.util.Optional;
import com.gmail.danadiadius.model.Role;

public interface RoleDao {
    Role save(Role role);

    Optional<Role> getRoleByName(String roleName);
}
