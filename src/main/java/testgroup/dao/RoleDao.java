package testgroup.dao;

import testgroup.model.Role;

import java.util.List;

public interface RoleDao {
    void addRole(Role role);

    void editRole(Role role);

    void removeRoleById(long id);

    List<Role> getAllRoles();

    Role getRole(String role);
}
