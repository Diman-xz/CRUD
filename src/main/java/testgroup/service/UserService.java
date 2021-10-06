package testgroup.service;

import testgroup.model.User;

import java.util.List;

public interface UserService {
    List<User> allUser();

    void add(User user);

    void remove(long id);

    void edit(User user);

    User getById(long id);
}
