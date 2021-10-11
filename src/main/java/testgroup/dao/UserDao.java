package testgroup.dao;

import testgroup.model.User;

import java.util.List;

public interface UserDao {
    List<User> allUsers();

    void add(User user);

    void remove(long id);

    void edit(User user);

    User getById(long id);

    User getUserByName(String name);
}
