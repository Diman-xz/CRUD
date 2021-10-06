package testgroup.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import testgroup.dao.UserDao;
import testgroup.model.User;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserDao usersDao;

    public UserServiceImpl(UserDao usersDao) {

        this.usersDao = usersDao;
    }

    @Override
    public List<User> allUser() {

        return usersDao.allUsers();
    }

    @Override
    public void add(User user) {

        usersDao.add(user);
    }

    @Override
    public void remove(long id) {

        usersDao.remove(id);
    }

    @Override
    public void edit(User user) {

        usersDao.edit(user);
    }

    @Override
    public User getById(long id) {
        return
                usersDao.getById(id);
    }
}
