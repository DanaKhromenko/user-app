package com.gmail.danadiadius.service.impl;

import com.gmail.danadiadius.dao.RoleDao;
import com.gmail.danadiadius.model.Role;
import com.gmail.danadiadius.service.RoleService;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role save(Role role) {
        return roleDao.save(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleDao.getRoleByName(roleName).orElseThrow();
    }
}
