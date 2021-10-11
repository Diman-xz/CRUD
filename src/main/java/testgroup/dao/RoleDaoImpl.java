package testgroup.dao;

import org.springframework.stereotype.Repository;
import testgroup.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void addRole(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void editRole(Role role) {
        entityManager.merge(role);
    }

    @Override
    public void removeRoleById(long id) {
        entityManager.remove(entityManager.find(Role.class, id));
    }

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("from Role").getResultList();
    }

    @Override
    public Role getRole(String role) {
        TypedQuery<Role> queryRole = entityManager.createQuery("select r from Role r where r.role=:role",
                Role.class).setParameter("role", role);
        return queryRole.getSingleResult();
    }
}
