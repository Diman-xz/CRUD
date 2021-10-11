package testgroup.service;

import testgroup.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();

    Role getRole(String role);
}
