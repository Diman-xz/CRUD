package testgroup.dao;

import org.springframework.stereotype.Repository;
import testgroup.model.User;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> allUsers() {

        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public void add(User user) {

        entityManager.persist(user);
    }

    @Override
    public void remove(long id) {

        entityManager.remove(entityManager.find(User.class, id));
    }

    @Override
    public void edit(User user) {

        entityManager.merge(user);
    }

    @Override
    public User getById(long id) {

        return entityManager.find(User.class, id);
    }
}
