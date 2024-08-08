package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
    void add(User user);

    List<User> listUsers();

    void dropUsersTable();

    User getUserById(Long id);

    void update(User user);

    void delete(Long id);

    void addUserIfNotExist(User user);
}

